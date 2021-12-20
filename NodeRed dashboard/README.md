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

6.	Typ de naam van de library die je wil installeren in. Bijvoorbeeld ```mysql``` en klik op de libary die je wilt hebben en klik op ``ìnstall```. 
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
