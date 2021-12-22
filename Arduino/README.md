# Installatie Industrial Shield

### Aansluiten inductieve naderingsschakelaar
De volgende aansluitingen gelden voor de Turck bi3m08ap6x sensor

```
* bruin - vcc
* blauw - gnd en Industrial shield GND 1
* zwart - Industrial shield Pin I0_0
```
![image](https://user-images.githubusercontent.com/57816069/147159540-c1bc548f-1fb9-48f6-ba03-479e40d557b6.png)

## Arduino code

### Gebruikersgegevens
De inloggegevens van de database in de Arduino code hoeven in principe niet worden aangepast.
De machinenaam heeft echter wel invloed op hoe data wordt opgeslagen en verwerkt. Deze moet zowel in Arduino, Nodered en het Java dashboard overeen komen.
```cpp
// MySQL Gegevens
char user[] = "Gebruikersnaam"; //De gebruikersnaam van de MySQL database.
char pass[] = "Wachtwoord";     //Het bijbehorende wachtwoord.
String machine = "N-4-7";       //De nagelproductiemachine waarop de teller wordt geïnstalleerd
```
