# Java Programmeren


In dit document heb ik mijn 4 classe van het java programma gezet.
Hierin zal ik bepaalde onderdelen van mijn code uitleggen.

### ophalen van de goede query's vanuit de mySQL database.
in het eerste gedeelte maakt mijn code verbinding met de mySQL server en vraagt ie met de `db.get` de query op (in dit geval) om het aantal geproduceerde spijkers vandaag van 
de machine `n-4-7`
die slaat de code nog op als somsnelheid en deze word in de while opgevraagd als `int productiesnelheid = rs.getInt("somsnelheid");`, door deze query uit te voeren krijgt de code binnen hoeveel keer deze foutmelding is voorgekomen.
deze query's zijn van te voren getest vanuit 'datagrip' om te kijken of ik de goede query eruit haalde.
        
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

### definiëren in welke PieChart mijn query's mogen komen
in dit onderste stuk word mijn query omgezet in een int, en deze word toegevoegd tot de PieChart Algemeen

```java
      int AlgemeenOverige = AlgemeenOverigeQuery;
      
        ObservableList<PieChart.Data> pieChartAlgemeen =
                FXCollections.observableArrayList(
                        new PieChart.Data("Kantoor (" + AlgemeenKantoor + ")", AlgemeenKantoor),
                        new PieChart.Data("Spijkemakerij(" + AlgemeenSpijkemakerij + ")", AlgemeenSpijkemakerij),
                        new PieChart.Data("Overige(" + AlgemeenOverige + ")", AlgemeenOverige));
        PCAlgemeen.getData().addAll(pieChartAlgemeen); 
 ```
 
 ### actie van de knoppen
 de actie die een knop onderneemt word hieronder duidelijk gemaakt door op de knop "spijkemakerij" te drukken zullen het pane van spijkemakerij op `(true)` en de andere pane's die u ziet staan op `(false)` te zetten.
 
 ``` java 
 public void showSpijkemakerij(ActionEvent actionEvent)
    {
        pnKantoor.setVisible(false);
        pnOverige.setVisible(false);
        pnSpijkemakerij.setVisible(true);
        pnAlgemeen.setVisible(false);
        pnStoringen.setVisible(false);
 ```
        

## belangerijk!
voor al mijn storingen vraag ik ze binnen een try & catch op en gerbuik ik deze belangerijke stukken om mijn storingen duidelijk te maken op een java dashboard.


        
