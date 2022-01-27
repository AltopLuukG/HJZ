# Java Programmeren


In dit document heb ik mijn 4 klassen van het java programma gezet.
Hierin zal ik bepaalde onderdelen van mijn code uitleggen.

### Ophalen van de goede query's vanuit de mySQL database.
In het eerste gedeelte maakt mijn code verbinding met de MySQL server. Daarna wordt er met de `db.get` functie de query uitgevoerd die het aantal geproduceerde spijkers vandaag van machine `n-4-7` ophaalt.

Deze data wordt in de code opgeslagen als somsnelheid en deze wordt in de while-loop opgevraagd als `int productiesnelheid = rs.getInt("somsnelheid");`, door deze query uit te voeren krijgt de code binnen hoeveel keer deze foutmelding is voorgekomen.
deze query's zijn van te voren getest vanuit 'datagrip' om te kijken of ik de goede informatie heb opgehaald.
        
```java
        try
        {
            Database db = new Database();
            db.connect();
            // is voor aantal geproduceerde spijkers vandaag
            ResultSet rs = db.get("SELECT SUM(productiesnelheid) AS 'somsnelheid' FROM spijkers WHERE date(timestamp) = CURDATE() && machine = 'N-4-7'");
            
            while (rs.next())
            {
                int productiesnelheid = rs.getInt("somsnelheid");
                lblProductieVandaag.setText(String.valueOf(productiesnelheid));
            }
            
            db.disconnect();
        }
catch (Exception e)
        {
            System.out.println(e.getMessage());
        } 
```

### Definiëren in welke PieChart mijn query's mogen komen
In dit onderste stuk wordt mijn query omgezet in een int, en deze word toegevoegd tot de PieChart Algemeen.

```java
      int AlgemeenOverige = AlgemeenOverigeQuery;
      
        ObservableList<PieChart.Data> pieChartAlgemeen =
                FXCollections.observableArrayList(
                        new PieChart.Data("Kantoor (" + AlgemeenKantoor + ")", AlgemeenKantoor),
                        new PieChart.Data("Spijkemakerij(" + AlgemeenSpijkemakerij + ")", AlgemeenSpijkemakerij),
                        new PieChart.Data("Overige(" + AlgemeenOverige + ")", AlgemeenOverige));
        PCAlgemeen.getData().addAll(pieChartAlgemeen); 
 ```
 
### Acties van de knoppen
De actie die een knop onderneemt wordt hieronder duidelijk gemaakt door op de knop "spijkemakerij" te drukken zullen het pane van spijkemakerij op `(true)` en de andere pane's die u ziet staan op `(false)` te zetten.
 
 ``` java 
 public void showSpijkemakerij(ActionEvent actionEvent)
    {
        pnKantoor.setVisible(false);
        pnOverige.setVisible(false);
        pnSpijkemakerij.setVisible(true);
        pnAlgemeen.setVisible(false);
        pnStoringen.setVisible(false);
 ```
        
## Belangrijk!
Voor al mijn storingen vraag ik ze binnen een try & catch op en gebruik ik deze belangrijke stukken om mijn storingen duidelijk te maken op een Java-dashboard.


## verbeterfase en wat ik hier voor heb gedaan.
voor in de verbeterfase heb ik een begin gemaakt aan het automatiseren van de orders. 
in het programma staat een tabblat nu waarin de desbetreffende klant de orders kan invoegen en deze worden opgeslagen in de database.

```java 
 public void SendData(ActionEvent actionEvent)
    {
        // hieronder word het stuk waardoor de klant de data kan versturen naar de database
        String Machine = txtMachine.getText();
        String Ordernummer = txtOrdernummer.getText();
        String Kopsoort = txtKopsoort.getText();
        String Afm_mm = txtAfm_mm.getText();
        String Draad_d_1 = txtDraad_d_1.getText();
        String Draad_d_2 = txtDraad_d_2.getText();
        String H_1_mm = txtH_1_mm.getText();
        String L_1_mm = txtL_1_mm.getText();

        int Ordernummer1 = Integer.parseInt(Ordernummer);
        double Afm_mm1 = Double.parseDouble(Afm_mm);
        double Draad_d_11 = Double.parseDouble(Draad_d_1);
        double Draad_2_11 = Double.parseDouble(Draad_d_2);
        double H_1_mm1 = Double.parseDouble(H_1_mm);
        double L_1_mm1 = Double.parseDouble(L_1_mm);

        try

        {
            Database db = new Database();
            db.connect();

            db.query("insert into orders(machine, ordernummer, kopsoort, draad_d_1, afm_mm, d_2_mm, h_1_mm, l_1) values ('" + Machine + "', '" + Ordernummer1 + "', '" + Kopsoort + "', '" + Draad_d_11 + "', '" + Afm_mm1 + "', '" + Draad_2_11 + "', '" + H_1_mm1 + "', '" + L_1_mm1 + "' )");


            db.disconnect();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
  ```
  
