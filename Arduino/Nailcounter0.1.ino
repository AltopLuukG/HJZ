#define DEBUG 1
#include "ToggleDebug.h"
#include "Ethernet.h"
#include "SPI.h"
#define nailsensor I0_0

byte mac[] = {0xDE, 0xAD, 0xBE, 0xEF, 0xFE, 0xED0};
byte ip[] = {10, 0, 0, 240};
byte gw[] = {10, 0, 0, 1};
byte subnet[] = {255, 255, 0, 0};
char server[] = "google.com"; //{10,0,0,223};
EthernetClient client;

String Machine = "Machine1";

unsigned long nails;
bool added = false;
bool error = false;

long previousMillis;
int calcTimer = 3000;

void setup()
{

    //iedere 3 seconden totaal vergelijken om snelheid per minuut te berekenen

    DEBUG_BEGIN(115200);
    pinMode(nailsensor, INPUT);

    Ethernet.begin(mac, ip, gw, gw, subnet);

    delay(1000);

    if (client.connect(server, 80))
    {
        DEBUG_PRINTLN("Connected");
    }

    /*
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
    }*/
}

void loop()
{
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
        resetError();
    }
    DEBUG_PRINTLN(nails);
    delay(5000);

    if (millis() - previousMillis > calcTimer)
    {

    }
}

void resetError()
{
}
/*
void setup()
{
    Serial.begin(115200);
    pinMode(I0_0, INPUT);
}
void loop()
{
    Serial.println(digitalRead(I0_0));
    delay(100);
}
*/
