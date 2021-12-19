# NodeRed dashboard
Hier kun je de Flow vinden voor NodeRed.

### Wat is NodeRed?
NodeRed is een programma waar je makkelijk dashboards mee kunt programmeren. Het programmeren zelf gebeurt door middel van zo geheten nodes. Deze nodes zijn blokjes die je in het werk veld kan slepen en met draden aan elkaar kan verbinden. Zo kun je heel snel en relatief eenvoudig een dashboard maken met een professionele look.  

### Hoe installeer ik NodeRED?
Ga naar: Getting Started : Node-RED (nodered.org) en klik aan op welk apparaat of besturingssysteem je NodeRed wil installeren. Wij hebben om te testen NodeRed op onze laptop geïnstalleerd omdat dit het testen erg makkelijk maakt.  
Om NodeRed op je laptop te installeren ga je naar deze link: Running on Windows : Node-RED (nodered.org). Volg de instructie op de website om NodeRed te installeren. 
Binnen het bedrijf hebben we NodeRed op de server gezet. 

### Hoe start ik NodeRed?
Windows: 
1.	Windowstoets.
2.	Typ ```CMD``` in.
3.	Druk op ```ENTER```.
4.	Typ dit in het geopende menu: ```node-red start``` 
5.	Druk op ```ENTER```.
6.	Je zal, als NodeRed succesvol is opgestart, dit op je scherm zien verschijnen. Je kunt nu naar je browser gaan en het aangegeven IP-adres in je zoekbalk typen. Dit zal vrijwel altijd ```http://127.0.0.1:1880/``` zijn. Druk op ```ENTER```. 
7.	Als je het IP-adres ingetoetst hebt zul je op deze pagina terecht komen. 

### Hoe gebruik ik NodeRED?
Rechts bovenin staat de knop ```deploy``` hiermee kan je je code compileren, dit kan ook als updaten gezien worden. 

Naast de knop ```deploy``` staat een knop met 3 balkjes. Als je op deze knop drukt krijg je dit menu te zien. Met de knop ```import``` kun je code bestanden importeren. Deze bestanden kun je in de map NodeRed dashboard vinden op deze GitHub pagina. 

Met de knop ```export``` kun je je code exporteren. Zelf gebruik ik het ook om de code lokaal op te slaan want als je NodeRed afsluit slaat NodeRed niet al je werk op. Daarom is het altijd een goed idee om, om de zoveel tijd je code te exporteren en op te slaan zodat je niks kwijtraakt.

Onderaan staat de knop ```manage palette``` hiermee kun je libraries installeren. Voor het dashboard heb je een aantal libraries nodig.   Hoe je een library installeert staat in het volgende hoofdstuk beschreven.

### Hoe installeer ik libraries?
1.	Ga naar de 3 balkjes links bovenin in je scherm. 
2.	Klik op de knop ```manage palette```.
3.	Je krijgt nu dit scherm te zien. 

4.	Klik op ```install```.

5.	Klik op ```search modules```.

6.	Typ de naam van de library die je wil installeren in. Bijvoorbeeld ```mysql``` en klik op de libary die je wilt hebben en klik op ``ìnstall```. 
 
De library installeert zichzelf. Je hoeft nu niks te doen.

7.	Herhaal stap 1 tot 6 net zolang totdat alle libraries zijn geïnstalleerd. 
De libraries die we in ons programma hebben gebruikt zijn:
•	```Node-red-node-mysql```
•	```Node-red-contrib-startup-trigger```
•	```Node-red-dashboard```

### Hoe start ik de code (flow)?
1.	Druk op ```deploy```.
2.	Klik op ```dashboard``` in het drop down menuutje. 
3.	klik nu op dit icoontje:
Er wordt nu een nieuw tabblad met het dashboard geopend. 

