in dit document heb ik mijn 4 classe van het java programma gezet.
hierin zal ik bepaalde onderdelen van mijn code uitleggen.


in de initialize word op het moment dat het programma opstart meteen met de database verbinding gemaakt om bepaalde gegevens op te vragen.
hieronder een voorbeeld van het ophalen van de aantallen die vandaag worden gemaakt op machine n-4-7.

***java
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
***java

