# NodeRed dashboard
Hier kun je de Flow vinden voor NodeRed. Samen met andere bestanden die van toepassing zijn voor het dashboard. 

### Wat is NodeRed?
NodeRed is een programma waar je makkelijk dashboards mee kunt programmeren. Het programmeren zelf gebeurt door middel van zo geheten nodes. Deze nodes zijn blokjes die je in het werk veld kan slepen en met draden aan elkaar kan verbinden. Zo kun je heel snel en relatief eenvoudig een dashboard maken met een professionele look.  

### Hoe installeer ik NodeRED?
Ga naar: (https://nodered.org/docs/getting-started/) en klik aan op welk apparaat of besturingssysteem je NodeRed wil installeren. Wij hebben om te testen NodeRed op onze laptop geïnstalleerd omdat dit het testen erg makkelijk maakt.  
Om NodeRed op je laptop te installeren ga je naar deze link: (https://nodered.org/docs/getting-started/windows). Volg de instructie op de website om NodeRed te installeren. 
Binnen het bedrijf hebben we NodeRed op de server gezet. 

### Hoe start ik NodeRed?
Windows: 
1.	Windowstoets.
2.	Typ ```CMD``` in.
3.	Druk op ```ENTER```.
4.	Typ dit in het geopende menu: ```node-red start``` 

![image](https://user-images.githubusercontent.com/44370997/146731288-19c82b58-633a-4650-ae52-49d8deb18e15.png)

5.	Druk op ```ENTER```.
6.	Je zal, als NodeRed succesvol is opgestart, dit op je scherm zien verschijnen. Je kunt nu naar je browser gaan en het aangegeven IP-adres in je zoekbalk typen. Dit zal          vrijwel altijd ```http://127.0.0.1:1880/``` zijn. Druk op ```ENTER```. 

![image](https://user-images.githubusercontent.com/44370997/146731370-53c516f7-e703-46cb-98f9-e1ee01a85a7d.png)

7.	Als je het IP-adres ingetoetst hebt zul je op deze pagina terecht komen. 
![image](https://user-images.githubusercontent.com/44370997/146731422-f5e5d1ec-036b-466e-8cdb-59ea93cdb782.png)

### Hoe gebruik ik NodeRED?
Rechts bovenin staat de knop ```deploy``` hiermee kan je je code compileren, dit kan ook als updaten gezien worden. 

Naast de knop ```deploy``` staat een knop met 3 balkjes. Als je op deze knop drukt krijg je dit menu te zien. Met de knop ```import``` kun je code bestanden importeren. Deze bestanden kun je in de map NodeRed dashboard vinden op deze GitHub pagina. 

![image](https://user-images.githubusercontent.com/44370997/146731473-fa034523-652b-434f-9936-b4cc479d6b49.png)

Met de knop ```export``` kun je je code exporteren. Zelf gebruik ik het ook om de code lokaal op te slaan want als je NodeRed afsluit slaat NodeRed niet al je werk op. Daarom is het altijd een goed idee om, om de zoveel tijd je code te exporteren en op te slaan zodat je niks kwijtraakt.

Onderaan staat de knop ```manage palette``` hiermee kun je libraries installeren. Voor het dashboard heb je een aantal libraries nodig.   Hoe je een library installeert staat in het volgende hoofdstuk beschreven.

### Hoe installeer ik libraries?
1.	Ga naar de 3 balkjes links bovenin in je scherm. 
2.	Klik op de knop ```manage palette```.
3.	Je krijgt nu dit scherm te zien. 

4.	Klik op ```install```.

![image](https://user-images.githubusercontent.com/44370997/146731679-e7d05bcb-1e9f-40fc-bf45-30269bb4a2e9.png)

5.	Klik op ```search modules```.

6.	Typ de naam van de library die je wil installeren in. Bijvoorbeeld ```mysql``` en klik op de libary die je wilt hebben en klik op ```install```. 

![image](https://user-images.githubusercontent.com/44370997/146731701-1d7090f5-ec6c-4cb2-97f9-a47a3b924daf.png)

De library installeert zichzelf. Je hoeft nu niks te doen.

7.	Herhaal stap 1 tot 6 net zolang totdat alle libraries geïnstalleerd zijn. 
    De libraries die we in ons programma hebben gebruikt zijn:

     •	```Node-red-node-mysql```
 
     •	```Node-red-contrib-startup-trigger```

     •	```Node-red-dashboard```

### Hoe start ik de code (flow)?
1.	Druk op ```deploy```.
2.	Klik op ```dashboard``` in het drop down menuutje. 

![image](https://user-images.githubusercontent.com/44370997/146731757-25df262f-3648-40fe-ad7e-1e1e164a2a23.png)

3.	klik nu op dit icoontje:

![image](https://user-images.githubusercontent.com/44370997/146731789-007ba798-0588-4700-8abf-2c1f1aa6a468.png)

Er wordt nu een nieuw tabblad met het dashboard geopend. 

## Instellingen
Als je een Flow (code) importeert kan het zo zijn dat er geen of weinig knoppen in je dashboard staan. Dit komt omdat NodeRed niet weet in welke ```group``` de knoppen moeten komen te staan.
Je kunt dit zien door een button, tekst of drop down menu node open te klikken. Als je zo’n node open klikt zul je ongeveer dit scherm te zien krijgen. Als NodeRed niet weet in welke ```group``` de knop geplaatst moet worden zal er in plaats van ```Controle```, ```undefined``` staan. 

![image](https://user-images.githubusercontent.com/44370997/146752007-1d11b762-1174-4ffb-8442-958c0ee9db1d.png)
 
Je kunt dit oplossend door op het pennetje rechts van ```[undefined] Machine``` aan te klikken. Je zult nu dit scherm zien. Door op het naar in rood omcirkelde knopje aan te klikken opent je een menuutje. Hier klik je ```Controle``` aan. 

![image](https://user-images.githubusercontent.com/44370997/146752054-c954d103-8247-4256-9217-274f354bc4cd.png)
 
Daarna klik je op ```Update``` rechts bovenaan en vervolgens op ```update```. 
Daarna klik je op ```deploy``` en dan zou je de knoppen en ander functies moeten zien verschijnen. 

## volgorde en layout van dashboard aanpassen
Om de volgorde van het dashboard aan te passen moet je in het dashboard tabje op ```layout``` klikken. Nu krijg je een menuutje waar alle dashboard items zichtbaar zijn. Je kunt deze gewoon rondslepen. 

![image](https://user-images.githubusercontent.com/44370997/146752102-9823366d-8d0e-4aac-b8d6-267aaf658fe8.png)
 
Dat menu ziet er zo uit:

![image](https://user-images.githubusercontent.com/44370997/146752131-9fe81215-d7e6-4234-a210-48c51cfe71d7.png)
 
Als je klaar bent klik je op ```done``` en ```deploy```.

## instellen van MySQL nodes
Zo ziet de MySQL database node eruit. 

![image](https://user-images.githubusercontent.com/44370997/146752164-768634dd-3500-42f0-bd2c-6b366b68375b.png)
 
Als je hierop dubbelklikt krijg je het keuzemenu te zien.

![image](https://user-images.githubusercontent.com/44370997/146752180-e8e6bdbd-3c96-4ef7-a47a-e7368df8b834.png)
 
Als je op het pennetje drukt krijg je de instellingen te zien. De code en instellingen voor de database zullen in de projectmap te vinden zijn.

![image](https://user-images.githubusercontent.com/44370997/146752209-4fb4c7e3-7e97-4267-9925-de198c136d8f.png)
