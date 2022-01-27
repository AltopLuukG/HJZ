#define DEBUG 1          // DEBUG modus "1" Debug berichten worden gecompileerd
#include "ToggleDebug.h" // Debug library beheert inschakelbare debug berichten
#include "Ethernet.h"
#include "SPI.h"
#include <MySQL_Connection.h>
#include <MySQL_Cursor.h>
#define nailsensor I0_0 // Input van inductieve sensor

#define N_4_7

// Mac adressen aanpassen bij andere arduinos
IPAddress server(192, 168, 50, 1); // Lokaal HJZ server IP-adres

EthernetClient client;
MySQL_Connection conn(&client);
MySQL_Cursor *cursor;

/*
  Capaciteiten:

  Spijkermachines S110:    350/min.
  Spijkermachines N-41:    550/min.
  Spijkermachines N31:     700/min.
  Spijkermachines Malmedy: 150/min.
  Spijkermachines DP 80:   75/min.
*/

#ifdef S_110_1
    String machine = "S-110-1";
    byte mac[6] = {0x90, 0xA2, 0xDA, 0x69, 0xA5, 0x50};
    float max_productivity = 350.0;
#endif
#ifdef S_110_2
    String machine = "S-110-2";
    byte mac[6] = {0x90, 0xA2, 0xDA, 0x8E, 0x64, 0xF5};
    float max_productivity = 350.0;
#endif
#ifdef S_110_3
    String machine = "S-110-3";
    byte mac[6] = {0x90, 0xA2, 0xDA, 0x72, 0xAD, 0x4B};
    float max_productivity = 350.0;
#endif
#ifdef S_110_4
    String machine = "S-110-4";
    byte mac[6] = {0x90, 0xA2, 0xDA, 0x16, 0x2D, 0x2B};
    float max_productivity = 350.0;
#endif
#ifdef N_4_5
    String machine = "N-4-5";
    byte mac[6] = {0x90, 0xA2, 0xDA, 0xC0, 0x18, 0x42};
    float max_productivity = 550.0;
#endif
#ifdef N_3_6
    String machine = "N-3-6";
    byte mac[6] = {0x90, 0xA2, 0xDA, 0xDE, 0x24, 0x33};
    float max_productivity = 700.0;
#endif
#ifdef N_4_7
    String machine = "N-4-7";
    byte mac[6] = {0x90, 0xA2, 0xDA, 0xB5, 0x17, 0x90};
    float max_productivity = 550.0;
#endif
#ifdef N_4_8
    String machine = "N-4-8";
    byte mac[6] = {0x90, 0xA2, 0xDA, 0xF0, 0x51, 0xE0};
    float max_productivity = 550.0;
#endif
#ifdef N_4_9
    String machine = "N-4-9";
    byte mac[6] = {0x90, 0xA2, 0xDA, 0xDF, 0x40, 0x25};
    float max_productivity = 550.0;
#endif
#ifdef N_4_10
    String machine = "N-4-10";
    byte mac[6] = {0x90, 0xA2, 0xDA, 0x27, 0x1D, 0x61};
    float max_productivity = 550.0;
#endif
#ifdef N_3_11
    String machine = "N-3-11";
    byte mac[6] = {0x90, 0xA2, 0xDA, 0xFB, 0xD8, 0x90};
    float max_productivity = 700.0;
#endif
#ifdef N_3_12
    String machine = "N-3-12";
    byte mac[6] = {0x90, 0xA2, 0xDA, 0xC0, 0x00, 0xE2};
    float max_productivity = 700.0;
#endif
#ifdef N_3_13
    String machine = "N-3-13";
    byte mac[6] = {0x90, 0xA2, 0xDA, 0xA8, 0x52, 0xE3};
    float max_productivity = 700.0;
#endif
#ifdef N_3_14
    String machine = "N-3-14";
    byte mac[6] = {0x90, 0xA2, 0xDA, 0x00, 0x51, 0xA2};
    float max_productivity = 700.0;
#endif
#ifdef MAL_16
    String machine = "MAL-16";
    byte mac[6] = {0x90, 0xA2, 0xDA, 0x22, 0xA8, 0x5D};
    float max_productivity = 150.0;
#endif
#ifdef DP80_17
    String machine = "DP80-17";
    byte mac[6] = {0x90, 0xA2, 0xDA, 0x36, 0x84, 0xE7};
    float max_productivity = 75.0;
#endif
#ifdef DP80_18
    String machine = "DP80-18";
    byte mac[6] = {0x90, 0xA2, 0xDA, 0x36, 0xE1, 0x37};
    float max_productivity = 75.0;
#endif
#ifdef S_110_19
    String machine = "S-110-19";
    byte mac[6] = {0x90, 0xA2, 0xDA, 0x59, 0x3C, 0xD1};
    float max_productivity = 350.0;
#endif

// MySQL Gegevens
char user[] = "IndustrialShield";
char pass[] = "HJZAdmin143%";
// String machine = "N-4-7";
// float max_productivity = 550.0; // Hoogste waarde uit database halen

unsigned long nails; // Spijkers per minuut
bool added = false;  // Voorkomt dat spijkers dubbel geteld worden

long previousMillis;    // Counterwaarde die verstreken tijd tussen data functie onthoudt
long calcTimer = 60000; // Data verzend timer waarde
int errorCounter = 0;   // Counter voor errorcontrole

void setup()
{ // totaal stilstand
    DEBUG_BEGIN(115200);
    pinMode(nailsensor, INPUT);

    if (Ethernet.begin(mac) == 0) // Verkrijg een IP-adres via DHCP mbv het MAC-adres
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
    else // Geen verbindingsproblemen. Weergeef het verkregen IP-adres
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
    if (!client.connected()) // Controleer of netwerkverbinding nog in stand is
    {
        Serial.println("Client not connected. Reconnecting...");
        if (Ethernet.begin(mac) == 0)
        {
            Serial.println("Reconnect failed.");
        }
        else
        {
            Serial.println("Reconnected to the network");
            delay(1000);
            connectDB();
        }
    }
    Ethernet.maintain(); // Behoud of vernieuw DHCP lease wanneer nodig

    if (!conn.connected())
    {
        Serial.println("Connection lost. retrying...");
        if (connectDB())
            Serial.println("OK.");
        else
            Serial.println("FAILED.");
    }

    if (digitalRead(nailsensor) && !added) // Tel nieuwe spijker op wanneer deze wordt gemeten
    {
        added = true;
        nails++;
    }
    if (!digitalRead(nailsensor)) // Kijk of er een nieuwe spijker geteld mag worden
    {
        added = false;
    }

    if (millis() - previousMillis > calcTimer) // Meet productiesnelheid per minuut.
    {
        errorCounter++;
        float productivity = nails * (100 / max_productivity); // Bereken productiviteit
        Serial.println(productivity, 3);

        String data = "INSERT INTO dev.spijkers (machine, productiesnelheid, productiviteit) VALUES ('" + machine + "'," + String(nails) + "," + String(productivity) + ")";

        sendData(data); // Stuur spijkers per minuut naar database

        if (nails < 250)
            errorCounter = 0;

        if (nails > 250 && errorCounter == 2)
        {
            String errData = "INSERT INTO dev.algemeen (machine, persoon, status) VALUES ('" + machine + "', 'arduino', 'goed')";
            sendData(errData); // Geef aan dat er geen fouten zijn als machine
            errorCounter = 0;  // twee minuten lang meer dan 250 spijkers/m produceert
        }

        Serial.println("Average per minute = " + String(nails));
        nails = 0;                 // Reset spijker teller
        previousMillis = millis(); // reset timer
    }

    // conn.close();
}

boolean connectDB()
{
    return conn.connect(server, 3306, user, pass); // Verbind met HJZ server met IP-adres
}

void sendData(String data)
{
    char INSERT_SQL[200];
    data.toCharArray(INSERT_SQL, sizeof(INSERT_SQL));

    if (conn.connected())            // Controleer of database nog is verbonden
        cursor->execute(INSERT_SQL); // Voer SQL Insert uit
    DEBUG_PRINTLN("Data sent");
}

String getData()
{
    row_values *row = NULL;
    char SELECT_SQL[128];
    String data = "SELECT MAX(productiesnelheid) FROM dev.spijkers WHERE machine = " + machine;
    data.toCharArray(SELECT_SQL, sizeof(SELECT_SQL));

    cursor->execute(SELECT_SQL);
    cursor->get_columns();

    do
    {
        row = cursor->get_next_row();
        if (row != NULL)
        {
            max_productivity = atol(row->values[0]);
        }
    } while (row != NULL);
    cursor->close();
}
