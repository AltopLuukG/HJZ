#define DEBUG 1
#include "ToggleDebug.h"
#include "Ethernet.h"
#include "SPI.h"
#include <MySQL_Connection.h>
#include <MySQL_Cursor.h>
#define nailsensor I0_0

byte mac[] = {0xDE, 0xAD, 0xBE, 0xEF, 0xFE, 0xED0};
IPAddress server(192, 168, 50, 1);

EthernetClient client;
MySQL_Connection conn(&client);
MySQL_Cursor *cursor;

char user[] = "Username";
char pass[] = "Password";
String machine = "Machine 7";

unsigned long nails;
bool added = false;
bool error = false;

long previousMillis;
long previousMillis2;
long calcTimer = 60000;
int errorCounter = 0;

void setup()
{
    DEBUG_BEGIN(115200);
    pinMode(nailsensor, INPUT);

    DEBUG_PRINTLN("Connecting to network...");
    if (Ethernet.begin(mac) == 0)
    {
        DEBUG_PRINTLN("Ethernet error");
        if (Ethernet.hardwareStatus() == EthernetNoHardware)
        {
            DEBUG_PRINTLN("Ethernet module not found");
            while (1)
            {
                delay(10);
            }
        }
        if (Ethernet.linkStatus() == LinkOFF)
        {
            DEBUG_PRINTLN("No ethernet cable connected");
        }
    }
    else
    {
        Serial.println(Ethernet.localIP());
    }

    delay(1000);

    if (connectDB())
        Serial.println("OK.");
    else
        Serial.println("FAILED.");

    cursor = new MySQL_Cursor(&conn);
}

void loop()
{
    if (!conn.connected())
    {
        Serial.println("Connection lost. retrying...");
        if (connectDB)
            Serial.println("OK.");
        else
            Serial.println("FAILED.");
    }

    if (digitalRead(nailsensor) && !added)
    {
        added = true;
        nails++;
    }
    if (!digitalRead(nailsensor))
    {
        added = false;
    }
    if (error && (nails > 500))
    {
        error = false;
    }

    if (millis() - previousMillis > calcTimer) // Meet productiesnelheid per minuut.
    {
        int random = random(500);

        errorCounter++;
        String data = "INSERT INTO dev.spijkers (machine, productiesnelheid) VALUES ('" + machine + "'," + String(random) + ")";
        char INSERT_SQL[100];
        data.toCharArray(INSERT_SQL, sizeof(INSERT_SQL));

        if (conn.connected())
            cursor->execute(INSERT_SQL);
        DEBUG_PRINTLN("Data sent");

        if (errorCounter == 5)
        {
            errorCounter = 0;
            if (nails > 300)
            {
                DEBUG_PRINTLN("Machine status \"Goed\"");
                String errData = "INSERT INTO dev.algemeen (machine, status) VALUES ('" + machine + ", goed')";
                errData.toCharArray(INSERT_SQL, sizeof(INSERT_SQL));
            }
        }

        Serial.println("Average per minute = " + String(nails));
        nails = 0;
        previousMillis = millis(); // reset timer
    }
}

boolean connectDB()
{
    return conn.connect(server, 3306, user, pass);
}
