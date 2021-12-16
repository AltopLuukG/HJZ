package sample;

import com.sun.org.apache.bcel.internal.generic.Select;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.sql.ResultSet;

public class Controller
{
    public Button btnSpijkermakerij;
    public Button btnKantoor;
    public Button btnOverig;
    public Button btnTerugSpijkemakerij;
    public Button btnTerugKantoor;
    public Button btnTerugOverige;
    public Button btnStoring;
    public Button btnTerugStoringen;
    public Pane pnOverige;
    public Pane pnSpijkemakerij;
    public Pane pnKantoor;
    public Pane pnAlgemeen;
    public Pane pnGeneral;
    public Pane pnStoringen;
    public PieChart PCStoringen;
    public PieChart PCAlgemeen;
    public PieChart PCSpijkemakerij;
    public PieChart PCKantoor;
    public PieChart PCOverige;
    public Button btnTestVerbinding;
    public Label lblProductiviteit;
    public Label lblProductieVandaag;
    public Label lblProductieWeek;
    public Label lblPercentageWeek;


    public void TestVerbinding(ActionEvent actionEvent)
    {
        try
        {
            Database db = new Database();
            db.connect();
            System.out.println("Ik heb verbinding");
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void initialize()
    {

        //ophalen van SQL Query & definitie ervan
        int AlgemeenKantoorQuery = 0;
        int AlgemeenSpijkemakerijQuery = 0;
        int AlgemeenOverigeQuery = 0;
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
            // is voor productiviteit in %
            ResultSet pt = db.get("SELECT round(avg(productiviteit)) AS'percentageProductiviteit' from spijkers where date(timestamp) = curdate()");

            while (pt.next())
            {
                int percentageProductiviteit = pt.getInt("percentageProductiviteit");
                lblProductiviteit.setText(String.valueOf(percentageProductiviteit));
            }
            // is voor aantal geproduceerde spijkers per week
            ResultSet ra = db.get("SELECT SUM(productiesnelheid) AS 'ProductieWeek' FROM spijkers WHERE date(timestamp) between date_sub(now(),INTERVAL 1 WEEK) and now() && machine = 'N-4-7'");

            while (ra.next())
            {
                int productiesnelheid = ra.getInt("ProductieWeek");
                lblProductieWeek.setText(String.valueOf(productiesnelheid));
            }
            // is voor productiviteit in % voor deze week
            ResultSet ps = db.get("SELECT round(avg(productiviteit)) AS'percentageProductiviteitWeek' from spijkers where date(timestamp) between date_sub(now(),INTERVAL 1 WEEK) and now()");

            while (ps.next())
            {
                int percentageProductiviteit = ps.getInt("percentageProductiviteitWeek");
                lblPercentageWeek.setText(String.valueOf(percentageProductiviteit));
            }

            //alles voor algemeen
            ResultSet aa = db.get("SELECT count(geen_draad && geen_orders && onderhoud && overig_kantoor ) AS 'algemeen kantoor' from algemeen where Date(timestamp) = curdate()");
            while (aa.next())
            {
                AlgemeenKantoorQuery = aa.getInt("algemeen kantoor");
            }

            ResultSet ab = db.get("SELECT count(bekken && messen && draad && overig_spijkermakerij) AS 'algemeen spijkemakerij' from algemeen where Date(timestamp) = curdate()");
            while (ab.next())
            {
                AlgemeenSpijkemakerijQuery = ab.getInt("algemeen spijkemakerij");
            }
            ResultSet ac = db.get("SELECT count(overig_algemeen && stilstand && draad_info && bekken_merk) AS 'algemeen overige' from algemeen where Date(timestamp) = curdate()");
            while (ac.next())
            {
                AlgemeenOverigeQuery = ac.getInt("algemeen overige");
            }

            db.disconnect();
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        //dit stuk is voor PieChartAlgemeen
        int AlgemeenKantoor = AlgemeenKantoorQuery;
        int AlgemeenSpijkemakerij = AlgemeenSpijkemakerijQuery;
        int AlgemeenOverige = AlgemeenOverigeQuery;
        ObservableList<PieChart.Data> pieChartAlgemeen =
                FXCollections.observableArrayList(
                        new PieChart.Data("Kantoor (" + AlgemeenKantoor + ")", AlgemeenKantoor),
                        new PieChart.Data("Spijkemakerij(" + AlgemeenSpijkemakerij + ")", AlgemeenSpijkemakerij),
                        new PieChart.Data("Overige(" + AlgemeenOverige + ")", AlgemeenOverige));
        PCAlgemeen.getData().addAll(pieChartAlgemeen);

        //dit stuk is voor PieChartSpijkemakerij
        int SpijkemakerijDraadVervangen = 0;
        int SpijkemakerijBekkenVersleten = 0;
        int SpijkemakerijMessenStempelVersleten = 0;
        int SpijkemakerijOverige = 0;
        try
        {
            Database db = new Database();
            db.connect();

            ResultSet ad = db.get("SELECT count(geen_draad) AS 'draad vervangen' from algemeen where date(timestamp) between date_sub(now(),INTERVAL 1 WEEK) and now()\n");
            while (ad.next())
            {
                SpijkemakerijDraadVervangen = ad.getInt("draad vervangen");
            }

            ResultSet ae = db.get("SELECT count(bekken) AS 'bekken versleten' from algemeen where date(timestamp) between date_sub(now(),INTERVAL 1 WEEK) and now()");
            while (ae.next())
            {
                SpijkemakerijBekkenVersleten = ae.getInt("bekken versleten");
            }
            ResultSet af = db.get("SELECT count(messen) AS 'messen versleten' from algemeen where date(timestamp) between date_sub(now(),INTERVAL 1 WEEK) and now()");
            while (af.next())
            {
                SpijkemakerijMessenStempelVersleten = af.getInt("messen versleten");
            }
            ResultSet ag = db.get("SELECT count(overig_spijkermakerij) AS 'overige spijkemakerij' from algemeen where date(timestamp) between date_sub(now(),INTERVAL 1 WEEK) and now()\n");
            while (ag.next())
            {
                SpijkemakerijOverige = ag.getInt("overige spijkemakerij");
            }

            db.disconnect();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        ObservableList<PieChart.Data> pieChartSpijkermakerij =
                FXCollections.observableArrayList(
                        new PieChart.Data("Draad Vervangen(" + SpijkemakerijDraadVervangen + ")", SpijkemakerijDraadVervangen),
                        new PieChart.Data("Bekken versleten(" + SpijkemakerijBekkenVersleten + ")", SpijkemakerijBekkenVersleten),
                        new PieChart.Data("Messen/stempel versleten(" + SpijkemakerijMessenStempelVersleten + ")", SpijkemakerijMessenStempelVersleten),
                        new PieChart.Data("overige(" + SpijkemakerijOverige + ")", SpijkemakerijOverige));
        PCSpijkemakerij.getData().addAll(pieChartSpijkermakerij);

        //dit is voor PieChartKantoor
        int KantoorGeenOrders = 0;
        int KantoorGeenDraad = 0;
        int KantoorMachineReparatie = 0;
        int KantoorOverige = 0;
        try
        {
            Database db = new Database();
            db.connect();

            ResultSet ad = db.get("SELECT count(geen_orders) AS 'geen orders' from algemeen where date(timestamp) between date_sub(now(),INTERVAL 1 WEEK) and now()");
            while (ad.next())
            {
                KantoorGeenOrders = ad.getInt("geen orders");
            }

            ResultSet ae = db.get("SELECT count(geen_draad) AS 'geen draad' from algemeen where date(timestamp) between date_sub(now(),INTERVAL 1 WEEK) and now()");
            while (ae.next())
            {
                KantoorGeenDraad = ae.getInt("geen draad");
            }
            ResultSet af = db.get("SELECT count(onderhoud) AS 'onderhoud' from algemeen where date(timestamp) between date_sub(now(),INTERVAL 1 WEEK) and now()");
            while (af.next())
            {
                KantoorMachineReparatie = af.getInt("onderhoud");
            }
            ResultSet ag = db.get("SELECT count(overig_kantoor) AS 'overige kantoor' from algemeen where date(timestamp) between date_sub(now(),INTERVAL 1 WEEK) and now()");
            while (ag.next())
            {
                KantoorOverige = ag.getInt("overige kantoor");
            }

            db.disconnect();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        ObservableList<PieChart.Data> pieChartKantoor =
                FXCollections.observableArrayList(
                        new PieChart.Data("Geen orders(" + KantoorGeenOrders + ")", KantoorGeenOrders),
                        new PieChart.Data("Geen Draad(" + KantoorGeenDraad + ")", KantoorGeenDraad),
                        new PieChart.Data("Machine reparatie(" + KantoorMachineReparatie + ")", KantoorMachineReparatie),
                        new PieChart.Data("overige(" + KantoorOverige + ")", KantoorOverige));
        PCKantoor.getData().addAll(pieChartKantoor);

        //dit is voor PieChartOverige
        int OverigeDuurDraad = 0;
        int OverigeDuurBekken = 0;
        int OverigeAfstellenMachine = 0;
        try
        {
            Database db = new Database();
            db.connect();

            ResultSet ah = db.get("SELECT count(draad_info) AS 'duur van draad' from algemeen where date(timestamp) between date_sub(now(),INTERVAL 1 WEEK) and now()");
            while (ah.next())
            {
                OverigeDuurDraad = ah.getInt("duur van draad");
            }

            ResultSet aj = db.get("SELECT count(bekken) AS 'bekken versleten' FROM algemeen WHERE date(timestamp) = curdate() && bekken = 'bekken versleten'");
            while (aj.next())
            {
                OverigeDuurBekken = aj.getInt("bekken versleten");
            }
            ResultSet ai = db.get("SELECT count(onderhoud) AS 'instellen van machine' from algemeen where date(timestamp) between date_sub(now(),INTERVAL 1 WEEK) and now()");
            while (ai.next())
            {
                OverigeAfstellenMachine = ai.getInt("instellen van machine");
            }

            db.disconnect();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        ObservableList<PieChart.Data> pieChartOverige =
                FXCollections.observableArrayList(
                        new PieChart.Data("duur draad(" + OverigeDuurDraad + ")", OverigeDuurDraad),
                        new PieChart.Data("duur bekken(" + OverigeDuurBekken + ")", OverigeDuurBekken),
                        new PieChart.Data("afstellen machine(" + OverigeAfstellenMachine + ")", OverigeAfstellenMachine));
        PCOverige.getData().addAll(pieChartOverige);

        //dit is voor PieCHartStoringen
        int StoringenMachineKapot = 0;
        int StoringenDraad = 0;
        int StoringenGereedschap = 0;
        int StoringenOmstellen = 0;
        try
        {
            Database db = new Database();
            db.connect();

            ResultSet ak = db.get("SELECT count(status) AS 'foutmeldingen' from algemeen where date(timestamp) between date_sub(now(),INTERVAL 1 WEEK) and now() && status = 'fout'");
            while (ak.next())
            {
                StoringenMachineKapot = ak.getInt("foutmeldingen");
            }

            ResultSet al = db.get("SELECT count(draad) AS 'draadStoring' from algemeen where date(timestamp) between date_sub(now(),INTERVAL 1 WEEK) and now() ");
            while (al.next())
            {
                StoringenDraad = al.getInt("draadStoring");
            }
            ResultSet am = db.get("SELECT count(bekken && messen) AS 'gereedschapStoring' from algemeen where date(timestamp) between date_sub(now(),INTERVAL 1 WEEK) and now()");
            while (am.next())
            {
                StoringenGereedschap = am.getInt("gereedschapStoring");
            }
            ResultSet an = db.get("SELECT count(onderhoud && stilstand) AS 'StoringOmstellen' from algemeen where date(timestamp) between date_sub(now(),INTERVAL 1 WEEK) and now()");
            while (an.next())
            {
                StoringenOmstellen = an.getInt("StoringOmstellen");
            }

            db.disconnect();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        ObservableList<PieChart.Data> PieChartStoringen =
                FXCollections.observableArrayList(
                        new PieChart.Data("machine kapot(" + StoringenMachineKapot + ")", StoringenMachineKapot),
                        new PieChart.Data("Draad(" + StoringenDraad + ")", StoringenDraad),
                        new PieChart.Data("Gereedschap(" + StoringenGereedschap + ")", StoringenGereedschap),
                        new PieChart.Data("omstellen(" + StoringenOmstellen + ")", StoringenOmstellen));
        PCStoringen.getData().addAll(PieChartStoringen);


    }

    public void showAantal(ActionEvent actionEvent)
    {
        //laat productiesnelheid zien van vandaag


    }

    public void showSpijkemakerij(ActionEvent actionEvent)
    {
        pnKantoor.setVisible(false);
        pnOverige.setVisible(false);
        pnSpijkemakerij.setVisible(true);
        pnAlgemeen.setVisible(false);
        pnStoringen.setVisible(false);


    }

    public void showKantoor(ActionEvent actionEvent)
    {
        pnAlgemeen.setVisible(false);
        pnKantoor.setVisible(true);
        pnSpijkemakerij.setVisible(false);
        pnOverige.setVisible(false);
        pnStoringen.setVisible(false);
    }

    public void showOverige(ActionEvent actionEvent)
    {
        pnAlgemeen.setVisible(false);
        pnKantoor.setVisible(false);
        pnSpijkemakerij.setVisible(false);
        pnOverige.setVisible(true);
        pnStoringen.setVisible(false);

    }

    public void TerugSpijkemakerij(ActionEvent actionEvent)
    {
        pnAlgemeen.setVisible(true);
        pnKantoor.setVisible(false);
        pnSpijkemakerij.setVisible(false);
        pnOverige.setVisible(false);
        pnStoringen.setVisible(false);

    }

    public void TerugKantoor(ActionEvent actionEvent)
    {
        pnAlgemeen.setVisible(true);
        pnKantoor.setVisible(false);
        pnSpijkemakerij.setVisible(false);
        pnOverige.setVisible(false);
        pnStoringen.setVisible(false);

    }

    public void TerugOverige(ActionEvent actionEvent)
    {
        pnAlgemeen.setVisible(true);
        pnKantoor.setVisible(false);
        pnSpijkemakerij.setVisible(false);
        pnOverige.setVisible(false);
        pnStoringen.setVisible(false);
    }


    public void showStoring(ActionEvent actionEvent)
    {
        pnAlgemeen.setVisible(false);
        pnKantoor.setVisible(false);
        pnSpijkemakerij.setVisible(false);
        pnOverige.setVisible(false);
        pnStoringen.setVisible(true);
    }

    public void TerugStoringen(ActionEvent actionEvent)
    {
        pnAlgemeen.setVisible(true);
        pnKantoor.setVisible(false);
        pnSpijkemakerij.setVisible(false);
        pnOverige.setVisible(false);
        pnStoringen.setVisible(false);
    }


}

