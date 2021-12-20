In dit document heb ik mijn 4 classe van het java programma gezet.
Hierin zal ik bepaalde onderdelen van mijn code uitleggen.

## java
```try
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
        }```
