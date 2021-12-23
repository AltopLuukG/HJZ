# Installatie Microcontroller en programma

## Aansluitingen schakelkast

### Microcontroller

De microcontroller moet worden voorzien van een 24V voeding. De microcontroller kan eenvoudig op een DIN-rail worden geplaatst samen met andere elektrische componenten.

### Aansluiten inductieve naderingsschakelaar
De volgende aansluitingen gelden voor de Turck bi3m08ap6x sensor

```
* bruin - vcc
* blauw - gnd en microcontroller GND 1
* zwart - microcontroller Pin I0_0
```
Om te testen of de sensor functioneert houdt je deze, nadat hij is aangesloten, met de kop tegen een metalen oppervlak aan. Wanneer de sensor iets meet gaat het lampje achterop de sensor branden.

![image](https://user-images.githubusercontent.com/57816069/147159540-c1bc548f-1fb9-48f6-ba03-479e40d557b6.png)<br>  Aansluitingen microcontroller

## Spijkertellers gereed maken voor nagelproductiemachines


### Programma

Om het programma te installeren op de microcontroller moeten er enkele dingen worden voorbereid. De schakelkast moet gereed zijn en de sensor moet zijn aangesloten. De microcontroller met een netwerkkabel zijn aangesloten op het lokale netwerk. Dit kan direct via een kabel of met een router die als client is ingesteld.

Allereerst moet de Arduino IDE worden geïnstalleerd. Dit is het software platform waarmee een programma op de Industrial Shield kan worden geladen.
Download hier de [Arduino IDE.](https://www.arduino.cc/en/software)

### De Arduino IDE gereedmaken

#### Bibliotheken
Voordat het programma op de microcontroller kan worden geladen moeten er enkele bibliotheken worden geïnstalleerd. Hiervoor klik je bovenin op `hulpmiddelen` en vervolgens op `Bibliotheken beheren`. Er verschijnt nu een nieuw scherm. Tik in de zoekbalk `mysql` in. Selecteer vervolgens `MySQL Connector Arduino` en klik rechtsonderin het balkje op installeren.

![image](https://user-images.githubusercontent.com/57816069/147211582-7c2bb4e8-8b33-427c-866a-330ee556a403.png)
![image](https://user-images.githubusercontent.com/57816069/147211910-a3c1085c-9641-4041-b148-cc77067957bc.png)


#### Board beheer
De Arduino omgeving heeft extra informatie nodig over de microcontroller om het programma te flashen. Klik hiervoor linksboven op `bestand` en daarna op `voorkeuren`. Voeg in het balkje bij `Meer Board Manager URL's` de volgende regel toe: `http://apps.industrialshields.com/main/arduino/boards/package_industrialshields_index.json` Klik vervolgens op OK.

![image](https://user-images.githubusercontent.com/57816069/147211077-7a6eccb1-c6ab-4d22-a340-58818df4c03a.png)<br>  Openen `voorkeuren` scherm


![image](https://user-images.githubusercontent.com/57816069/147210051-3c82d35f-7fdf-42d7-8191-ccf5045c7e94.png)<br>  Toevoegen Industrialshield gegevens

Ga nu naar `Hulpmiddelen` en vervolgens naar het tabje `Board`. Klik in de lijst op "Industrial Shields megaAVR Boards" en zorg dat `10 IOS PLC Family` is geselecteerd. Zorg dat bij het tabje `model` `10 IOS PLC` is geselecteerd. Nu is de juiste microcontroller ingesteld.

![image](https://user-images.githubusercontent.com/57816069/147212193-7eda3674-964a-4ee7-ae3b-9cd69416ef26.png)<br>  Microcontroller instellen


### Programma inladen

Kies in het mapje met programma's het .ino bestand met de naam van de gewenste nagelproductiemachine. Open dit bestand in de Arduino IDE. Verbind je laptop of PC met de microcontroller met een micro-USB kabel. Zorg dat de juiste USB-poort is geselecteerd bij `hulpmiddelen` > `poort`. Druk linksbovenin het programma op de upload knop (de groene knop met het pijltje). Nu is het programma aan het "flashen". Wanneer de statusbalk onderaan "Uploaden voltooid" weergeeft kan de microcontroller in gebruik worden genomen.
Werkt het uploaden niet? Probeer dan een andere poort uit bij `hulpmiddelen` > `poort`.

![image](https://user-images.githubusercontent.com/57816069/147213212-77fa5090-395e-4d28-a1a8-8d73798650a1.png)<br>  Uploaden programma op microcontroller


## Arduino code

### Gebruikersgegevens
De inloggegevens van de database in de Arduino code hoeven in principe niet worden aangepast.
De machinenaam heeft echter wel invloed op hoe data wordt opgeslagen en verwerkt. Deze moet zowel in Arduino, Nodered en het Java dashboard overeen komen.

Om te voorkomen dat bestaande programma's moeten worden aangepast wordt er een map opgeleverd waarin per machine een programma klaarstaat. Hiervoor hoeft er alleen bij de juiste machine het bijbehorende programma worden ingeladen. De .ino bestanden zijn herkenbaar aan de naam van de productiemachine.
```cpp
// MySQL Gegevens
char user[] = "Gebruikersnaam"; //De gebruikersnaam van de MySQL database.
char pass[] = "Wachtwoord";     //Het bijbehorende wachtwoord.
String machine = "N-4-7";       //De nagelproductiemachine waarop de teller wordt geïnstalleerd
```
