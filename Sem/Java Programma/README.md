#Java Programmeren


In dit document heb ik mijn 4 classe van het java programma gezet.
Hierin zal ik bepaalde onderdelen van mijn code uitleggen.


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

## belangerijk!
voor al mijn storingen vraag ik ze binnen een try & catch op en gerbuik ik deze belangerijke stukken om mijn storingen duidelijk te maken op een java dashboard.


        
