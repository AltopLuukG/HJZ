#define DEBUG 1
#include "ToggleDebug.h"
#include "Ethernet.h"
#include "SPI.h"
//#include <MySQL_Connection.h>
//#include <MySQL_Cursor.h>
#define nailsensor I0_0

byte mac[] = {0xDE, 0xAD, 0xBE, 0xEF, 0xFE, 0xED0};
byte ip[] = {10, 0, 0, 240};
byte gw[] = {10, 0, 0, 1};
byte subnet[] = {255, 255, 0, 0};
byte server[] = {10,0,0,223};
EthernetClient client;

String Machine = "Machine1";

unsigned long nails;
bool added = false;
bool error = false;

long previousMillis;
long previousMillis2;
int calcTimer = 10000;
int sendTimer = 6000;

void setup()
{
    DEBUG_BEGIN(115200);
    pinMode(nailsensor, INPUT);

    //Ethernet.begin(mac, ip, gw, gw, subnet);

    delay(1000);


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
}

void loop()
{
    if (client.available())
    {
        char c = client.read();
        Serial.print(c);
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
        //resetError();
    }
    //DEBUG_PRINTLN(nails);

    if (millis() - previousMillis > calcTimer) //Meet gemiddelde productiesnelheid per minuut iedere 10 seconden.
    {
        previousMillis = millis(); //reset timer
        Serial.println("Average per minute = " + (String(nails * 6)));
        nails = 0;
    }

    delay(5000);
    //if (millis() - previousMillis2 > sendTimer)
    //{
        Serial.println("Netwerktest");
        //previousMillis2 = millis();

        if (client.connect(server, 80))
        {
            Serial.println("Connected");
            client.println("GET / HTTP/1.1");
            client.println("Host: google.com");
            client.println("Connection: close\r\n");
            client.println();
        }
        else
        {
            Serial.println("Connection failed");
        }
    //}
}
