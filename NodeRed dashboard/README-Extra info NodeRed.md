# NodeRed dashboard
Hier kun je de Flow vinden voor NodeRed. Samen met andere bestanden die van toepassing zijn voor het dashboard. 


### Wat is NodeRed?
NodeRed is een programma waar je makkelijk dashboards mee kunt programmeren. Het programmeren zelf gebeurt door middel van zo geheten nodes. Deze nodes zijn blokjes die je in het werk veld kan slepen en met draden aan elkaar kan verbinden. Zo kun je heel snel en relatief eenvoudig een dashboard maken met een professionele look.  


### Hoe installeer ik NodeRED?
Ga naar: (https://nodered.org/docs/getting-started/ “Getting Started : Node-RED (nodered.org)”) en klik aan op welk apparaat of besturingssysteem je NodeRed wil installeren. Wij hebben om te testen NodeRed op onze laptop geïnstalleerd omdat dit het testen erg makkelijk maakt.  
Om NodeRed op je laptop te installeren ga je naar deze link: (https://nodered.org/docs/getting-started/windows “Running on Windows : Node-RED (nodered.org)”). Volg de instructie op de website om NodeRed te installeren. 
Binnen het bedrijf hebben we NodeRed op de server gezet. 
### Hoe start ik NodeRed?
Windows: 
1.	Windowstoets.
2.	Typ ```CMD``` in.
3.	Druk op ```ENTER```.
4.	Typ dit in het geopende menu: ```node-red start```. 

![image](https://user-images.githubusercontent.com/44370997/151350011-04970346-ebf7-4563-b301-7c7cb6b6420b.png)

5.	Druk op ```ENTER```. 
6.	Je zal, als NodeRed succesvol is opgestart, dit op je scherm zien verschijnen. Je kunt nu naar je browser gaan en het aangegeven IP-adres in je zoekbalk typen. Dit zal vrijwel altijd ```http://127.0.0.1:1880/``` zijn. Druk op ```ENTER```. 

![image](https://user-images.githubusercontent.com/44370997/151350175-297b5148-6ac0-49e2-91b4-df13d4feb183.png)

7.	Als je het IP-adres ingetoetst hebt zul je op deze pagina terecht komen. 

![image](https://user-images.githubusercontent.com/44370997/151350226-b3681f24-2a66-4617-88da-be5452a1fc2d.png)

### Hoe gebruik ik NodeRED?
Rechts bovenin staat de knop ```deploy``` hiermee kan je je code compileren, dit kan ook als updaten gezien worden. 

Naast de knop ```deploy``` staat een knop met 3 balkjes. Als je op deze knop drukt krijg je dit menu te zien. Met de knop ```import``` kun je code bestanden importeren. Deze bestanden kun je in de map NodeRed dashboard vinden op deze GitHub pagina. 

![image](https://user-images.githubusercontent.com/44370997/151350269-df588dbc-2283-4209-801e-42c9abd5274f.png)

Met de knop ```export``` kun je je code exporteren. Zelf gebruik ik het ook om de code lokaal op te slaan want als je NodeRed afsluit slaat NodeRed niet al je werk op. Daarom is het altijd een goed idee om, om de zoveel tijd je code te exporteren en op te slaan zodat je niks kwijtraakt.

Onderaan staat de knop ```manage palette``` hiermee kun je libraries installeren. Voor het dashboard heb je een aantal libraries nodig.   Hoe je een library installeert staat in het volgende hoofdstuk beschreven.


### Hoe installeer ik libraries?
1.	Ga naar de 3 balkjes links bovenin in je scherm. 
2.	Klik op de knop ```manage palette```.
3.	Je krijgt nu dit scherm te zien. 
4.	Klik op ```install```.

![image](https://user-images.githubusercontent.com/44370997/151350443-e767661e-c118-4187-aa5d-e232af21517c.png)

5.	Klik op ```search modules```.
6.	Typ de naam van de library die je wil installeren in. Bijvoorbeeld ```mysql``` en klik op de libary die je wilt hebben en klik op ```ìnstall```. 

![image](https://user-images.githubusercontent.com/44370997/151350632-fcd0a56f-642d-4770-8345-5bce5e390edc.png)
 
De library installeert zichzelf. Je hoeft nu niks te doen.

7.	Herhaal stap 1 tot 6 net zolang totdat alle libraries geïnstalleerd zijn. 
De libraries die we in ons programma hebben gebruikt zijn:
•	```Node-red-node-mysql```
•	```Node-red-contrib-startup-trigger```
•	```Node-red-dashboard```
•	```Node-red-node-email``` 


### Hoe start ik de code (flow)?
1.	Druk op ```deploy```.
2.	Klik op ```dashboard``` in het drop down menuutje. 

![image](https://user-images.githubusercontent.com/44370997/151350749-01a90627-a2e7-4477-8358-52db604a1068.png)

3.	klik nu op dit icoontje:
Er wordt nu een nieuw tabblad met het dashboard geopend. 

![image](https://user-images.githubusercontent.com/44370997/151350840-498adf34-eb15-4b15-a4b5-01f371173c01.png)


## Instellingen
Als je een Flow (code) importeert kan het zo zijn dat er geen of weinig knoppen in je dashboard staan. Dit komt omdat NodeRed niet weet in welke ```group``` de knoppen moeten komen te staan.
Je kunt dit zien door een button, tekst of drop down menu node open te klikken. Als je zo’n node open klikt zul je ongeveer dit scherm te zien krijgen. Als NodeRed niet weet in welke ```group``` de knop geplaatst moet worden zal er in plaats van ```Controle```, ```undefined``` staan. 

![image](https://user-images.githubusercontent.com/44370997/151350870-a8a88264-5db9-4bbf-9e33-30c2f0f5e57c.png) 
 
Je kunt dit oplossend door op het pennetje rechts van ```[undefined] Machine``` aan te klikken. Je zult nu dit scherm zien. Door op het naar in rood omcirkelde knopje aan te klikken opent je een menuutje. Hier klik je ```Controle``` aan. 

![image](https://user-images.githubusercontent.com/44370997/151350921-e009ecef-0023-4160-b7c9-633cbd148798.png)
 
Daarna klik je op ```Update``` rechts bovenaan en vervolgens op ```update```. 
Daarna klik je op ```deploy``` en dan zou je de knoppen en ander functies moeten zien verschijnen. 


## volgorde en layout van dashboard aanpassen
Om de volgorde van het dashboard aan te passen moet je in het dashboard tabje op ```layout``` klikken. Nu krijg je een menuutje waar alle dashboard items zichtbaar zijn. Je kunt deze gewoon rondslepen. 

![image](https://user-images.githubusercontent.com/44370997/151351010-677cb381-78d3-4467-b417-737c1a2d932c.png)

Dat menu ziet er zo uit:

![image](https://user-images.githubusercontent.com/44370997/151351031-2e40aad9-eb90-4bf3-afa1-2654fef2a5fd.png)
 
Als je klaar bent klik je op ```done``` en ```deploy```.

## instellen van MySQL nodes
Zo ziet de MySQL database node eruit:

![image](https://user-images.githubusercontent.com/44370997/151351182-d95fc89b-8c8b-4342-9fd7-4e5a1edb7470.png)
 
Als je hierop dubbelklikt krijg je het keuzemenu te zien.

![image](https://user-images.githubusercontent.com/44370997/151351248-cd5d2685-581d-469c-864b-488836359789.png)
 
Als je op het pennetje drukt krijg je de instellingen te zien. De code en instellingen voor de database zullen in de projectmap te vinden zijn. 

![image](https://user-images.githubusercontent.com/44370997/151351274-46c6f089-43f7-4539-8769-5f4cc9c7becf.png)


### instellen E-mail
1. Klik het e-mail blokje aan.

![image](https://user-images.githubusercontent.com/44370997/151351307-c59d787f-f630-493b-8313-05a18bff3cb4.png)

2. Vul de gegevens in:

![image](https://user-images.githubusercontent.com/44370997/151351409-84638f67-df5c-44d2-88a1-cfb8d2856fa2.png)

To: Het e-mailadres van de gebruiker.
**Server:** Voor Gmail adressen is deze ```smtp.gmail.com```.
**Port:** Deze staat standaard op 465. Controleer of ```use secure connection``` is aangevinkt. 
**Userid:** Het e-mail van waaruit de mail verzonden wordt.
**Password:** Het e-mailadres van het account.
**TLS option:** Zorg dat deze ook is aangevinkt. 
