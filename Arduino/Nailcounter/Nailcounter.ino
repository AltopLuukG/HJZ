#define DEBUG 1          // DEBUG modus "1" Debug berichten worden gecompileerd
#include "ToggleDebug.h" // Debug library beheert inschakelbare debug berichten
#include "Ethernet.h"
#include "SPI.h"
#include <MySQL_Connection.h>
#include <MySQL_Cursor.h>
#define nailsensor I0_0 // Input van inductieve sensor

byte mac[] = {0xDE, 0xAD, 0xBE, 0xEF, 0xFE, 0xED0}; // Mac adressen aanpassen bij andere arduinos
IPAddress server(192, 168, 50, 1);                  // Lokaal FHJZ server IP-adres

EthernetClient client;
MySQL_Connection conn(&client);
MySQL_Cursor *cursor;

// MySQL Gegevens
char user[] = "IndustrialShield";
char pass[] = "HJZAdmin143%";
String machine = "N-4-7";

float max_productivity = 550.0; // Hoogste waarde uit database halen

unsigned long nails; // Spijkers per minuut
bool added = false;  // Voorkomt dat spijkers dubbel geteld worden

long previousMillis;    // Counterwaarde die verstreken tijd tussen data functie onthoudt
long calcTimer = 60000; // Data verzend timer waarde
int errorCounter = 0;   // Counter voor errorcontrole

void setup()
{ // totaal stilstand
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

    if (millis() - previousMillis > calcTimer) // Meet productiesnelheid per minuut.
    {
        errorCounter++;
        float productivity = nails * (100 / max_productivity);
        Serial.println(productivity, 3);
        String data = "INSERT INTO dev.spijkers (machine, productiesnelheid, productiviteit) VALUES ('" + machine + "'," + String(nails) + "," + String(productivity) + ")";
        char INSERT_SQL[200];
        data.toCharArray(INSERT_SQL, sizeof(INSERT_SQL));

        if (conn.connected())
            cursor->execute(INSERT_SQL);
        DEBUG_PRINTLN("Data sent");

        if (nails < 250)
            errorCounter = 0;

        if (nails > 250 && errorCounter == 2)
        {
            DEBUG_PRINTLN("Machine status \"Goed\"");
            String errData = "INSERT INTO dev.algemeen (machine, status) VALUES ('" + machine + "', 'goed')";
            char INSERT_SQL2[100];
            errData.toCharArray(INSERT_SQL2, sizeof(INSERT_SQL2));

            if (conn.connected())
                cursor->execute(INSERT_SQL2);
            DEBUG_PRINTLN("Data sent");
            errorCounter = 0;
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
