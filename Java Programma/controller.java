package sample;

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
    public Button btnTestVerbinding;
    public Button btnOrders;
    public Pane pnOverige;
    public Pane pnSpijkemakerij;
    public Pane pnKantoor;
    public Pane pnAlgemeen;
    public Pane pnGeneral;
    public Pane pnStoringen;
    public Pane pnOrders;
    public PieChart PCStoringen;
    public PieChart PCAlgemeen;
    public PieChart PCSpijkemakerij;
    public PieChart PCKantoor;
    public PieChart PCOverige;
    public Label lblProductiviteit;
    public Label lblProductieVandaag;
    public Label lblProductieWeek;
    public Label lblPercentageWeek;
    public Button btnTerugOrders;
    public Button btnSendDataOrders;
    public TextField txtMachine;
    public TextField txtDraad_d_1;
    public TextField txtAfm_mm;
    public TextField txtKopsoort;
    public TextField txtOrdernummer;
    public TextField txtH_1_mm;
    public TextField txtL_1_mm;
    public TextField txtDraad_d_2;
    public Button btnClearTextfield;
    public Button btnRefresh;
    public Label lblLaatsteFoutmelding;


    public void TestVerbinding(ActionEvent actionEvent)
    {
        initialize();
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
            ResultSet pt = db.get("SELECT avg(productiviteit) AS'percentageProductiviteit' from spijkers where date(timestamp) = CURDATE() && date_format(timestamp, '%H:%i') > '07:30' && date_format(timestamp, '%H:%i') < '16:30';");

            while (pt.next())
            {
                int percentageProductiviteit = pt.getInt("percentageProductiviteit");
                lblProductiviteit.setText(String.valueOf(percentageProductiviteit));
            }
            // is voor aantal geproduceerde spijkers per week
            ResultSet ra = db.get("SELECT SUM(productiesnelheid) AS 'ProductieWeek' FROM spijkers WHERE YEARWEEK(timestamp, 1) = YEARWEEK(NOW(), 1) && machine = 'N-4-7' && date_format(timestamp, '%H:%i') > '07:30' && date_format(timestamp, '%H:%i') < '16:30';\n");

            while (ra.next())
            {
                int productiesnelheid = ra.getInt("ProductieWeek");
                lblProductieWeek.setText(String.valueOf(productiesnelheid));
            }
            // is voor productiviteit in % voor deze week
            ResultSet ps = db.get("SELECT round(avg(productiviteit)) AS'percentageProductiviteitWeek' from spijkers WHERE YEARWEEK(timestamp, 1) = YEARWEEK(NOW(), 1)");

            while (ps.next())
            {
                int percentageProductiviteit = ps.getInt("percentageProductiviteitWeek");
                lblPercentageWeek.setText(String.valueOf(percentageProductiviteit));
            }

            //alles voor algemeen
            ResultSet aa = db.get("SELECT count(geen_draad && geen_orders && onderhoud && overig_kantoor ) AS 'algemeen kantoor' from algemeen where YEARWEEK(timestamp, 1) = YEARWEEK(NOW(), 1)");
            while (aa.next())
            {
                AlgemeenKantoorQuery = aa.getInt("algemeen kantoor");
            }

            ResultSet ab = db.get("SELECT count(bekken && messen && draad && overig_spijkermakerij) AS 'algemeen spijkemakerij' from algemeen where YEARWEEK(timestamp, 1) = YEARWEEK(NOW(), 1)");
            while (ab.next())
            {
                AlgemeenSpijkemakerijQuery = ab.getInt("algemeen spijkemakerij");
            }
            ResultSet ac = db.get("SELECT count(overig_algemeen && stilstand && draad_info && bekken_merk) AS 'algemeen overige' from algemeen where YEARWEEK(timestamp, 1) = YEARWEEK(NOW(), 1)");
            while (ac.next())
            {
                AlgemeenOverigeQuery = ac.getInt("algemeen overige");
            }

            db.disconnect();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        //dit stuk is voor PieChartAlgemeen
        int AlgemeenKantoor = AlgemeenKantoorQuery;
        int AlgemeenSpijkemakerij = AlgemeenSpijkemakerijQuery;
        int AlgemeenOverige = AlgemeenOverigeQuery;
        PCAlgemeen.getData().clear();
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

            ResultSet ad = db.get("SELECT count(draad) AS 'draad vervangen' from algemeen where YEARWEEK(timestamp, 1) = YEARWEEK(NOW(), 1) && draad = 'draad vervangen'");
            while (ad.next())
            {
                SpijkemakerijDraadVervangen = ad.getInt("draad vervangen");
            }

            ResultSet ae = db.get("SELECT count(bekken) AS 'bekken versleten' from algemeen where YEARWEEK(timestamp, 1) = YEARWEEK(NOW(), 1)");
            while (ae.next())
            {
                SpijkemakerijBekkenVersleten = ae.getInt("bekken versleten");
            }
            ResultSet af = db.get("SELECT count(messen) AS 'messen versleten' from algemeen WHERE YEARWEEK(timestamp, 1) = YEARWEEK(NOW(), 1)");
            while (af.next())
            {
                SpijkemakerijMessenStempelVersleten = af.getInt("messen versleten");
            }
            ResultSet ag = db.get("SELECT count(overig_spijkermakerij) AS 'overige spijkemakerij' from algemeen where YEARWEEK(timestamp, 1) = YEARWEEK(NOW(), 1)");
            while (ag.next())
            {
                SpijkemakerijOverige = ag.getInt("overige spijkemakerij");
            }

            db.disconnect();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        PCSpijkemakerij.getData().clear();
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

            ResultSet ad = db.get("SELECT count(geen_orders) AS 'geen orders' from algemeen where YEARWEEK(timestamp, 1) = YEARWEEK(NOW(), 1)");
            while (ad.next())
            {
                KantoorGeenOrders = ad.getInt("geen orders");
            }

            ResultSet ae = db.get("select count(geen_draad) AS 'geen draad' from algemeen where geen_draad ='geen draad' && YEARWEEK(timestamp, 1) = YEARWEEK(NOW(), 1)");
            while (ae.next())
            {
                KantoorGeenDraad = ae.getInt("geen draad");
            }
            ResultSet af = db.get("SELECT count(onderhoud) AS 'onderhoud' from algemeen where YEARWEEK(timestamp, 1) = YEARWEEK(NOW(), 1)");
            while (af.next())
            {
                KantoorMachineReparatie = af.getInt("onderhoud");
            }
            ResultSet ag = db.get("SELECT count(overig_kantoor) AS 'overige kantoor' from algemeen where YEARWEEK(timestamp, 1) = YEARWEEK(NOW(), 1)");
            while (ag.next())
            {
                KantoorOverige = ag.getInt("overige kantoor");
            }

            db.disconnect();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        PCKantoor.getData().clear();
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

            ResultSet ah = db.get("SELECT count(draad_info) AS 'duur van draad' from algemeen where YEARWEEK(timestamp, 1) = YEARWEEK(NOW(), 1)");
            while (ah.next())
            {
                OverigeDuurDraad = ah.getInt("duur van draad");
            }

            ResultSet aj = db.get("SELECT count(bekken) AS 'bekken versleten' FROM algemeen WHERE YEARWEEK(timestamp, 1) = YEARWEEK(NOW(), 1) && bekken = 'bekken versleten'");
            while (aj.next())
            {
                OverigeDuurBekken = aj.getInt("bekken versleten");
            }
            ResultSet ai = db.get("SELECT count(onderhoud) AS 'instellen van machine' from algemeen where YEARWEEK(timestamp, 1) = YEARWEEK(NOW(), 1)");
            while (ai.next())
            {
                OverigeAfstellenMachine = ai.getInt("instellen van machine");
            }

            db.disconnect();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        PCOverige.getData().clear();
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

            ResultSet ak = db.get("SELECT count(status) AS 'foutmeldingen' from algemeen where YEARWEEK(timestamp, 1) = YEARWEEK(NOW(), 1) && status = 'fout'");
            while (ak.next())
            {
                StoringenMachineKapot = ak.getInt("foutmeldingen");
            }

            ResultSet al = db.get("SELECT count(draad) AS 'draadStoring' from algemeen where YEARWEEK(timestamp, 1) = YEARWEEK(NOW(), 1) ");
            while (al.next())
            {
                StoringenDraad = al.getInt("draadStoring");
            }
            ResultSet am = db.get("SELECT count(bekken && messen) AS 'gereedschapStoring' from algemeen where YEARWEEK(timestamp, 1) = YEARWEEK(NOW(), 1)");
            while (am.next())
            {
                StoringenGereedschap = am.getInt("gereedschapStoring");
            }
            ResultSet an = db.get("SELECT count(onderhoud && stilstand) AS 'StoringOmstellen' from algemeen where YEARWEEK(timestamp, 1) = YEARWEEK(NOW(), 1)");
            while (an.next())
            {
                StoringenOmstellen = an.getInt("StoringOmstellen");
            }

            db.disconnect();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        PCStoringen.getData().clear();
        ObservableList<PieChart.Data> PieChartStoringen =
                FXCollections.observableArrayList(
                        new PieChart.Data("machine kapot(" + StoringenMachineKapot + ")", StoringenMachineKapot),
                        new PieChart.Data("Draad(" + StoringenDraad + ")", StoringenDraad),
                        new PieChart.Data("Gereedschap(" + StoringenGereedschap + ")", StoringenGereedschap),
                        new PieChart.Data("omstellen(" + StoringenOmstellen + ")", StoringenOmstellen));
        PCStoringen.getData().addAll(PieChartStoringen);

        //ophalen van laatste foutmelding
        try
        {
            Database db = new Database();
            db.connect();

            ResultSet al = db.get("SELECT id, machine, coalesce(bekken, messen, draad, geen_orders, overig_spijkermakerij, geen_draad, onderhoud, overig_kantoor, stilstand, foutcode_11, overig_algemeen) as 'foutcode', timestamp FROM dev.algemeen WHERE 'foutcode' IS NOT NULL AND status = 'fout' ORDER BY id DESC LIMIT 1;");
            while (al.next())
            {
                String laatsteFoutmelding = al.getString("foutcode");
                 lblLaatsteFoutmelding.setText(laatsteFoutmelding);
            }

            db.disconnect();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }


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

    public void clearTextField(ActionEvent actionEvent)
    {
        txtMachine.clear();
        txtDraad_d_2.clear();
        txtL_1_mm.clear();
        txtKopsoort.clear();
        txtOrdernummer.clear();
        txtH_1_mm.clear();
        txtDraad_d_1.clear();
        txtAfm_mm.clear();
    }

    public void showSpijkemakerij(ActionEvent actionEvent)
    {
        pnKantoor.setVisible(false);
        pnOverige.setVisible(false);
        pnSpijkemakerij.setVisible(true);
        pnAlgemeen.setVisible(false);
        pnStoringen.setVisible(false);
        pnOrders.setVisible(false);


    }

    public void showKantoor(ActionEvent actionEvent)
    {
        pnAlgemeen.setVisible(false);
        pnKantoor.setVisible(true);
        pnSpijkemakerij.setVisible(false);
        pnOverige.setVisible(false);
        pnStoringen.setVisible(false);
        pnOrders.setVisible(false);
    }

    public void showOverige(ActionEvent actionEvent)
    {
        pnAlgemeen.setVisible(false);
        pnKantoor.setVisible(false);
        pnSpijkemakerij.setVisible(false);
        pnOverige.setVisible(true);
        pnStoringen.setVisible(false);
        pnOrders.setVisible(false);
    }

    public void TerugSpijkemakerij(ActionEvent actionEvent)
    {
        pnAlgemeen.setVisible(true);
        pnKantoor.setVisible(false);
        pnSpijkemakerij.setVisible(false);
        pnOverige.setVisible(false);
        pnStoringen.setVisible(false);
        pnOrders.setVisible(false);
    }

    public void TerugKantoor(ActionEvent actionEvent)
    {
        pnAlgemeen.setVisible(true);
        pnKantoor.setVisible(false);
        pnSpijkemakerij.setVisible(false);
        pnOverige.setVisible(false);
        pnStoringen.setVisible(false);
        pnOrders.setVisible(false);
    }

    public void TerugOverige(ActionEvent actionEvent)
    {
        pnAlgemeen.setVisible(true);
        pnKantoor.setVisible(false);
        pnSpijkemakerij.setVisible(false);
        pnOverige.setVisible(false);
        pnStoringen.setVisible(false);
        pnOrders.setVisible(false);

    }


    public void showStoring(ActionEvent actionEvent)
    {
        pnAlgemeen.setVisible(false);
        pnKantoor.setVisible(false);
        pnSpijkemakerij.setVisible(false);
        pnOverige.setVisible(false);
        pnStoringen.setVisible(true);
        pnOrders.setVisible(false);
    }

    public void TerugStoringen(ActionEvent actionEvent)
    {
        pnAlgemeen.setVisible(true);
        pnKantoor.setVisible(false);
        pnSpijkemakerij.setVisible(false);
        pnOverige.setVisible(false);
        pnStoringen.setVisible(false);
        pnOrders.setVisible(false);
    }


    public void showOrders(ActionEvent actionEvent)
    {
        pnAlgemeen.setVisible(false);
        pnKantoor.setVisible(false);
        pnSpijkemakerij.setVisible(false);
        pnOverige.setVisible(false);
        pnStoringen.setVisible(false);
        pnOrders.setVisible(true);
    }

    public void TerugOrders(ActionEvent actionEvent)
    {
        pnAlgemeen.setVisible(true);
        pnKantoor.setVisible(false);
        pnSpijkemakerij.setVisible(false);
        pnOverige.setVisible(false);
        pnStoringen.setVisible(false);
        pnOrders.setVisible(false);
    }


}
