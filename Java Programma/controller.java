package sample;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.util.Scanner;

//<editor-fold desc="public Gedefinieerd">
public class Controller {

    public Button btnSpijkermakerij;
    public Button btnKantoor;
    public Button btnOverig;
    public Button btnTerugSpijkemakerij;
    public Button btnTerugKantoor;
    public Button btnTerugOverige;
    public Button btnStoring;
    public Button btnClearTextfield;
    public Button btnRefresh;
    public Button btnTerugStoringen;
    public Button btnTestVerbinding;
    public Button btnOrders;
    public Button btnTerugOrders;
    public Button btnSendDataOrders;
    public Button btnTerugExcel;
    public Button btnBekijkExcel;
    public Button btnOpslaanInExcel;
    public Pane pnOverige;
    public Pane pnSpijkemakerij;
    public Pane pnKantoor;
    public Pane pnAlgemeen;
    public Pane pnGeneral;
    public Pane pnStoringen;
    public Pane pnOrders;
    public Pane pnExcel;
    public PieChart PCStoringen;
    public PieChart PCSpijkemakerij;
    public PieChart PCKantoor;
    public PieChart PCOverige;
    public PieChart PCAlgemeenDag;
    public PieChart PCAlgemeenWeek;
    public PieChart PCAlgemeenMaand;
    public PieChart PCAlgemeenJaar;
    public Label lblProductiviteit;
    public Label lblProductieVandaag;
    public Label lblProductieWeek;
    public Label lblPercentageWeek;
    public Label lblLaatstFoutmelding;
    public Label lblProductiviteitVanDezeWeek;
    public Label lblProductivieitVandaag;
    public Label lblAantalGeproduceerdVandaag;
    public Label lblAantalGeproduceerdDezeWeek;
    public Label lblLaatsteFoutmelding;
    public Label txtPercentageTeken1;
    public Label lblAantalGeproduceerdMaand;
    public Label lblAantalGeproduceerdJaar;
    public Label lblProductiviteitVanDezeMaand;
    public Label LblPeriode;
    public Label lblProductiviteitVanDitJaar;
    public Label lblProductieMaand;
    public Label lblProductieJaar;
    public Label lblPercentageMaand;
    public Label lblPercentageJaar;
    public TextField txtMachine;
    public TextField txtDraad_d_1;
    public TextField txtAfm_mm;
    public TextField txtKopsoort;
    public TextField txtOrdernummer;
    public TextField txtH_1_mm;
    public TextField txtL_1_mm;
    public TextField txtDraad_d_2;
    public ChoiceBox CbTijd;
    public TextArea txtAInhoud;
    public Label lblProductieJaarM;
    public String filepath = ("E:\\programmeren\\java\\HJZDraadindustrie\\src\\sample\\Assets\\HJZDraadindustrieDoetinchem.csv");
    public Component frame;


    //</editor-fold>

    //<editor-fold desc="test verbinden">
    public void TestVerbinding() {
        initialize();
        try {
            Database db = new Database();
            db.connect();
            System.out.println("Ik heb verbinding");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    //</editor-fold>

    public void initialize() {

        //<editor-fold desc="aanroepen van de ChoiceboxActions class">
        Observable Choicebox1 =
                FXCollections.observableArrayList("dag", "week", "maand", "jaar");
        CbTijd.setItems((ObservableList) Choicebox1);
        // listining for selection changes
        CbTijd.getSelectionModel().selectedItemProperty().addListener((V, oldValue, newValue) ->
        {
            if ("dag".equals(newValue)) {
                PCAlgemeenDag.setVisible(true);
                PCAlgemeenWeek.setVisible(false);
                PCAlgemeenMaand.setVisible(false);
                PCAlgemeenJaar.setVisible(false);
                lblAantalGeproduceerdVandaag.setVisible(true);
                lblProductieVandaag.setVisible(true);
                lblProductivieitVandaag.setVisible(true);
                lblProductiviteit.setVisible(true);
                lblAantalGeproduceerdDezeWeek.setVisible(false);
                lblProductieWeek.setVisible(false);
                lblProductiviteitVanDezeWeek.setVisible(false);
                lblPercentageWeek.setVisible(false);
                txtPercentageTeken1.setVisible(true);
                lblLaatsteFoutmelding.setVisible(true);
                lblLaatstFoutmelding.setVisible(true);
                lblProductieMaand.setVisible(false);
                lblPercentageMaand.setVisible(false);
                lblAantalGeproduceerdMaand.setVisible(false);
                lblProductiviteitVanDezeMaand.setVisible(false);
                lblProductiviteitVanDitJaar.setVisible(false);
                lblAantalGeproduceerdJaar.setVisible(false);
                lblPercentageJaar.setVisible(false);
                lblProductieJaar.setVisible(false);
                lblProductieJaarM.setVisible(false);

            }

            if ("week".equals(newValue)) {
                PCAlgemeenDag.setVisible(false);
                PCAlgemeenWeek.setVisible(true);
                PCAlgemeenMaand.setVisible(false);
                PCAlgemeenJaar.setVisible(false);
                lblAantalGeproduceerdVandaag.setVisible(false);
                lblProductieVandaag.setVisible(false);
                lblProductivieitVandaag.setVisible(false);
                lblProductiviteit.setVisible(false);
                lblLaatstFoutmelding.setVisible(false);
                lblAantalGeproduceerdDezeWeek.setVisible(true);
                lblProductieWeek.setVisible(true);
                lblProductiviteitVanDezeWeek.setVisible(true);
                lblPercentageWeek.setVisible(true);
                txtPercentageTeken1.setVisible(true);
                lblLaatsteFoutmelding.setVisible(false);
                lblProductieMaand.setVisible(false);
                lblPercentageMaand.setVisible(false);
                lblAantalGeproduceerdMaand.setVisible(false);
                lblProductiviteitVanDezeMaand.setVisible(false);
                lblProductieJaar.setVisible(false);
                lblPercentageJaar.setVisible(false);
                lblAantalGeproduceerdJaar.setVisible(false);
                lblProductiviteitVanDitJaar.setVisible(false);
                lblProductieJaarM.setVisible(false);

            }

            if ("maand".equals(newValue)) {
                PCAlgemeenDag.setVisible(false);
                PCAlgemeenWeek.setVisible(false);
                PCAlgemeenMaand.setVisible(true);
                PCAlgemeenJaar.setVisible(false);
                lblAantalGeproduceerdVandaag.setVisible(false);
                lblProductieVandaag.setVisible(false);
                lblProductivieitVandaag.setVisible(false);
                lblProductiviteit.setVisible(false);
                lblAantalGeproduceerdDezeWeek.setVisible(false);
                lblProductieWeek.setVisible(false);
                lblProductiviteitVanDezeWeek.setVisible(false);
                lblPercentageWeek.setVisible(false);
                txtPercentageTeken1.setVisible(true);
                lblLaatsteFoutmelding.setVisible(false);
                lblLaatstFoutmelding.setVisible(false);
                lblProductieMaand.setVisible(true);
                lblPercentageMaand.setVisible(true);
                lblAantalGeproduceerdMaand.setVisible(true);
                lblProductiviteitVanDezeMaand.setVisible(true);
                lblProductiviteitVanDitJaar.setVisible(false);
                lblAantalGeproduceerdJaar.setVisible(false);
                lblPercentageJaar.setVisible(false);
                lblProductieJaar.setVisible(false);
                lblProductieJaarM.setVisible(false);

            }

            if ("jaar".equals(newValue)) {
                PCAlgemeenDag.setVisible(false);
                PCAlgemeenWeek.setVisible(false);
                PCAlgemeenMaand.setVisible(false);
                PCAlgemeenJaar.setVisible(true);
                lblAantalGeproduceerdVandaag.setVisible(false);
                lblProductieVandaag.setVisible(false);
                lblProductivieitVandaag.setVisible(false);
                lblProductiviteit.setVisible(false);
                lblAantalGeproduceerdDezeWeek.setVisible(false);
                lblProductieWeek.setVisible(false);
                lblProductiviteitVanDezeWeek.setVisible(false);
                lblPercentageWeek.setVisible(false);
                txtPercentageTeken1.setVisible(true);
                lblLaatsteFoutmelding.setVisible(false);
                lblLaatstFoutmelding.setVisible(false);
                lblProductieMaand.setVisible(false);
                lblPercentageMaand.setVisible(false);
                lblAantalGeproduceerdMaand.setVisible(false);
                lblProductiviteitVanDezeMaand.setVisible(false);
                lblProductiviteitVanDitJaar.setVisible(true);
                lblAantalGeproduceerdJaar.setVisible(true);
                lblPercentageJaar.setVisible(true);
                lblProductieJaar.setVisible(true);
                lblProductieJaarM.setVisible(true);


            }

        });
        //</editor-fold>


        //<editor-fold desc="Algemeen">
        //ophalen van SQL Query & definitie ervan
        // dit is gedeelte voor piechartDag
        int AlgemeenKantoorDagQuery = 0;
        int AlgemeenSpijkemakerijDagQuery = 0;
        int AlgemeenOverigeDagQuery = 0;
        //Dit gedeelte is voor PieChartWeek
        int AlgemeenFoutenKantoorWeek = 0;
        int AlgemeenFoutenSpijkemakerijWeek = 0;
        int AlgemeenFoutenOverigeWeek = 0;
        //Dit gedeelte is voor PieChartMaand
        var AlgemeenFoutenKantoorMaand = 0;
        var AlgemeenFoutenSpijkemakerijMaand = 0;
        var AlgemeenFoutenOverigeMaand = 0;
        //Dit gedeelte is voor PieChartJaar
        var AlgemeenFoutenKantoorJaar = 0;
        var AlgemeenFoutenSpijkemakerijJaar = 0;
        var AlgemeenFoutenOverigeJaar = 0;

        try {
            Database db = new Database();
            db.connect();
            // is voor aantal geproduceerde spijkers vandaag
            ResultSet rs = db.get("SELECT SUM(productiesnelheid) AS 'somsnelheid' FROM spijkers WHERE date(timestamp) = CURDATE() && machine = 'N-4-7'");

            while (rs.next()) {
                int productiesnelheid = rs.getInt("somsnelheid");
                lblProductieVandaag.setText(String.valueOf(productiesnelheid));
            }
            // is voor productiviteit in %
            ResultSet pt = db.get("SELECT avg(productiviteit) AS'percentageProductiviteit' from spijkers where date(timestamp) = CURDATE() && date_format(timestamp, '%H:%i') > '07:30' && date_format(timestamp, '%H:%i') < '16:30';");

            while (pt.next()) {
                int percentageProductiviteit = pt.getInt("percentageProductiviteit");
                lblProductiviteit.setText(String.valueOf(percentageProductiviteit));
            }

            //alles voor vandaag
            ResultSet aa = db.get("SELECT count(geen_draad && geen_orders && onderhoud && overig_kantoor ) AS 'algemeen kantoor' from algemeen where timestamp = curdate() && status = 'fout' && persoon = 'tablet'");
            while (aa.next()) {
                AlgemeenKantoorDagQuery = aa.getInt("algemeen kantoor");
            }

            ResultSet ab = db.get("SELECT count(bekken && messen && draad && overig_spijkermakerij) AS 'algemeen spijkemakerij' from algemeen where timestamp = curdate() && status = 'fout' && persoon = 'tablet'");
            while (ab.next()) {
                AlgemeenSpijkemakerijDagQuery = ab.getInt("algemeen spijkemakerij");
            }
            ResultSet ac = db.get("SELECT count(overig_algemeen && stilstand && draad_info && bekken_merk) AS 'algemeen overige' from algemeen where timestamp = curdate() && status = 'fout' && persoon = 'tablet'");
            while (ac.next()) {
                AlgemeenOverigeDagQuery = ac.getInt("algemeen overige");
            }
            //SQL Query voor deze week

            /// alles voor produceren vandaag en productiviteit.
            ResultSet ra = db.get("SELECT SUM(productiesnelheid) AS 'ProductieWeek' FROM spijkers WHERE YEARWEEK(timestamp, 1) = YEARWEEK(NOW(), 1) && machine = 'N-4-7' && date_format(timestamp, '%H:%i') > '07:30' && date_format(timestamp, '%H:%i') < '16:30';\n");
            while (ra.next()) {
                int productiesnelheid = ra.getInt("ProductieWeek");
                lblProductieWeek.setText(String.valueOf(productiesnelheid));
            }

            ResultSet cab = db.get("SELECT round(avg(productiviteit)) AS'percentageProductiviteitWeek' from spijkers WHERE YEARWEEK(timestamp, 1) = YEARWEEK(NOW(), 1)");
            while (cab.next()) {
                int percentageProductiviteitWeek = cab.getInt("percentageProductiviteitWeek");
                lblPercentageWeek.setText(String.valueOf(percentageProductiviteitWeek));
            }
            /// alles voor de piechartWeek
            ResultSet cac = db.get("SELECT count(geen_draad && geen_orders && onderhoud && overig_kantoor ) AS 'algemeenkantoor' from algemeen where YEARWEEK(timestamp, 1) = YEARWEEK(NOW(), 1)");
            while (cac.next()) {
                AlgemeenFoutenKantoorWeek = cac.getInt("algemeenkantoor");
            }

            ResultSet cad = db.get("SELECT count(bekken && messen && draad && overig_spijkermakerij ) AS 'algemeen spijkemakerij' from algemeen where YEARWEEK(timestamp, 1) = YEARWEEK(NOW(), 1)");
            while (cad.next()) {
                AlgemeenFoutenSpijkemakerijWeek = cad.getInt("algemeen spijkemakerij");
            }

            ResultSet cae = db.get("SELECT count(geen_orders && geen_draad && onderhoud && overig_algemeen ) AS 'algemeen overige' from algemeen where YEARWEEK(timestamp, 1) = YEARWEEK(NOW(), 1)");
            while (cae.next()) {
                AlgemeenFoutenOverigeWeek = cae.getInt("algemeen overige");
            }


            //SQL Query voor deze maand
            /// alles voor produceren vandaag en productiviteit.
            ResultSet ca = db.get("SELECT round(avg(productiviteit)) AS'percentageProductiviteitMaand' from spijkers WHERE month(curdate())");
            while (ca.next()) {
                int percentageProductiviteitMaand = ca.getInt("percentageProductiviteitMaand");
                lblPercentageMaand.setText(String.valueOf(percentageProductiviteitMaand));
            }

            ResultSet cb = db.get("SELECT SUM(productiesnelheid) AS 'AantallenVanDezeMaand' FROM spijkers WHERE month(curdate())");
            while (cb.next()) {
                int AantallenVanDezeMaand = cb.getInt("AantallenVanDezeMaand");
                lblProductieMaand.setText(String.valueOf(AantallenVanDezeMaand));
            }

            /// alles voor de piechartMaand
            ResultSet cc = db.get("SELECT count(geen_draad && geen_orders && onderhoud && overig_kantoor) AS 'algemeen kantoor Maand' from algemeen where month(curdate())");
            while (cc.next()) {
                AlgemeenFoutenKantoorMaand = cc.getInt("algemeen kantoor Maand");
            }

            ResultSet cd = db.get("SELECT count(bekken && messen && draad && overig_spijkermakerij) AS 'algemeen spijkemakerij Maand' from algemeen where month(curdate())");
            while (cd.next()) {
                AlgemeenFoutenSpijkemakerijMaand = cd.getInt("algemeen spijkemakerij Maand");
            }

            ResultSet ce = db.get("SELECT count(geen_orders && geen_draad && onderhoud && overig_algemeen ) AS 'algemeen overige Maand' from algemeen where month(curdate())");
            while (ce.next()) {
                AlgemeenFoutenOverigeMaand = ce.getInt("algemeen overige Maand");
            }

            //SQL Query voor deze jaar
            /// alles voor produceren vandaag en productiviteit.
            ResultSet ga = db.get("SELECT round(avg(productiviteit)) AS'percentageProductiviteitJaar' from spijkers WHERE year(curdate())");
            while (ga.next()) {
                int percentageProductiviteitJaar = ga.getInt("percentageProductiviteitJaar");
                lblPercentageJaar.setText(String.valueOf(percentageProductiviteitJaar));
            }

            ResultSet gb = db.get("SELECT round(SUM(productiesnelheid)/1000000) AS 'AantallenVanDitjaar' FROM spijkers WHERE year(curdate())");
            while (gb.next()) {
                int aantallenVanDitjaar = gb.getInt("AantallenVanDitjaar");
                lblProductieJaar.setText(String.valueOf(aantallenVanDitjaar));
            }

            /// alles voor de piechartJaar
            ResultSet gc = db.get("SELECT count(geen_draad && geen_orders && onderhoud && overig_kantoor) AS 'algemeen kantoor Jaar' from algemeen where month(curdate())");
            while (gc.next()) {
                AlgemeenFoutenKantoorJaar = gc.getInt("algemeen kantoor Jaar");
            }

            ResultSet gd = db.get("SELECT count(bekken && messen && draad && overig_spijkermakerij) AS 'algemeen spijkemakerij Jaar' from algemeen where month(curdate())");
            while (gd.next()) {
                AlgemeenFoutenSpijkemakerijJaar = gd.getInt("algemeen spijkemakerij Jaar");
            }

            ResultSet ge = db.get("SELECT count(geen_orders && geen_draad && onderhoud && overig_algemeen ) AS 'algemeen overige Jaar' from algemeen where month(curdate())");
            while (ge.next()) {
                AlgemeenFoutenOverigeJaar = ge.getInt("algemeen overige Jaar");
            }

            db.disconnect();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //dit stuk is voor PieChartAlgemeen
        int AlgemeenKantoorDag = AlgemeenKantoorDagQuery;
        int AlgemeenSpijkemakerijDag = AlgemeenSpijkemakerijDagQuery;
        int AlgemeenOverigeDag = AlgemeenOverigeDagQuery;
        PCAlgemeenDag.getData().clear();
        ObservableList<PieChart.Data> pieChartAlgemeen =
                FXCollections.observableArrayList(
                        new PieChart.Data("Kantoor (" + AlgemeenKantoorDag + ")", AlgemeenKantoorDag),
                        new PieChart.Data("Spijkemakerij(" + AlgemeenSpijkemakerijDag + ")", AlgemeenSpijkemakerijDag),
                        new PieChart.Data("Overige(" + AlgemeenOverigeDag + ")", AlgemeenOverigeDag));
        PCAlgemeenDag.getData().addAll(pieChartAlgemeen);

        PCAlgemeenWeek.getData().clear();
        ObservableList<PieChart.Data> pieChartAlgemeenWeek =
                FXCollections.observableArrayList(
                        new PieChart.Data("Kantoor (" + AlgemeenFoutenKantoorWeek + ")", AlgemeenFoutenKantoorWeek),
                        new PieChart.Data("Spijkemakerij(" + AlgemeenFoutenSpijkemakerijWeek + ")", AlgemeenFoutenSpijkemakerijWeek),
                        new PieChart.Data("Overige(" + AlgemeenFoutenOverigeWeek + ")", AlgemeenFoutenOverigeWeek));
        PCAlgemeenWeek.getData().addAll(pieChartAlgemeenWeek);


        PCAlgemeenMaand.getData().clear();
        ObservableList<PieChart.Data> pieChartAlgemeenMaand =
                FXCollections.observableArrayList(
                        new PieChart.Data("Kantoor (" + AlgemeenFoutenKantoorMaand + ")", AlgemeenFoutenKantoorMaand),
                        new PieChart.Data("Spijkemakerij(" + AlgemeenFoutenSpijkemakerijMaand + ")", AlgemeenFoutenSpijkemakerijMaand),
                        new PieChart.Data("Overige(" + AlgemeenFoutenOverigeMaand + ")", AlgemeenFoutenOverigeMaand));
        PCAlgemeenMaand.getData().addAll(pieChartAlgemeenMaand);

        PCAlgemeenJaar.getData().clear();
        ObservableList<PieChart.Data> pieChartAlgemeenJaar =
                FXCollections.observableArrayList(
                        new PieChart.Data("Kantoor (" + AlgemeenFoutenKantoorJaar + ")", AlgemeenFoutenKantoorJaar),
                        new PieChart.Data("Spijkemakerij(" + AlgemeenFoutenSpijkemakerijJaar + ")", AlgemeenFoutenSpijkemakerijJaar),
                        new PieChart.Data("Overige(" + AlgemeenFoutenOverigeJaar + ")", AlgemeenFoutenOverigeJaar));
        PCAlgemeenJaar.getData().addAll(pieChartAlgemeenJaar);


        //</editor-fold>


        //<editor-fold desc="Spijkemakerij">
        //dit stuk is voor PieChartSpijkemakerij
        int SpijkemakerijDraadVervangen = 0;
        int SpijkemakerijBekkenVersleten = 0;
        int SpijkemakerijMessenStempelVersleten = 0;
        int SpijkemakerijOverige = 0;
        try {
            Database db = new Database();
            db.connect();

            ResultSet ad = db.get("SELECT count(draad) AS 'draad vervangen' from algemeen where YEARWEEK(timestamp, 1) = YEARWEEK(NOW(), 1) && draad = 'draad vervangen'");
            while (ad.next()) {
                SpijkemakerijDraadVervangen = ad.getInt("draad vervangen");
            }

            ResultSet ae = db.get("SELECT count(bekken) AS 'bekken versleten' from algemeen where YEARWEEK(timestamp, 1) = YEARWEEK(NOW(), 1)");
            while (ae.next()) {
                SpijkemakerijBekkenVersleten = ae.getInt("bekken versleten");
            }
            ResultSet af = db.get("SELECT count(messen) AS 'messen versleten' from algemeen WHERE YEARWEEK(timestamp, 1) = YEARWEEK(NOW(), 1)");
            while (af.next()) {
                SpijkemakerijMessenStempelVersleten = af.getInt("messen versleten");
            }
            ResultSet ag = db.get("SELECT count(overig_spijkermakerij) AS 'overige spijkemakerij' from algemeen where YEARWEEK(timestamp, 1) = YEARWEEK(NOW(), 1)");
            while (ag.next()) {
                SpijkemakerijOverige = ag.getInt("overige spijkemakerij");
            }

            db.disconnect();
        } catch (Exception e) {
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
        //</editor-fold>

        //<editor-fold desc="Kantoor">
        //dit is voor PieChartKantoor
        int KantoorGeenOrders = 0;
        int KantoorGeenDraad = 0;
        int KantoorMachineReparatie = 0;
        int KantoorOverige = 0;
        try {
            Database db = new Database();
            db.connect();

            ResultSet ad = db.get("SELECT count(geen_orders) AS 'geen orders' from algemeen where YEARWEEK(timestamp, 1) = YEARWEEK(NOW(), 1)");
            while (ad.next()) {
                KantoorGeenOrders = ad.getInt("geen orders");
            }

            ResultSet ae = db.get("select count(geen_draad) AS 'geen draad' from algemeen where geen_draad ='geen draad' && YEARWEEK(timestamp, 1) = YEARWEEK(NOW(), 1)");
            while (ae.next()) {
                KantoorGeenDraad = ae.getInt("geen draad");
            }
            ResultSet af = db.get("SELECT count(onderhoud) AS 'onderhoud' from algemeen where YEARWEEK(timestamp, 1) = YEARWEEK(NOW(), 1)");
            while (af.next()) {
                KantoorMachineReparatie = af.getInt("onderhoud");
            }
            ResultSet ag = db.get("SELECT count(overig_kantoor) AS 'overige kantoor' from algemeen where YEARWEEK(timestamp, 1) = YEARWEEK(NOW(), 1)");
            while (ag.next()) {
                KantoorOverige = ag.getInt("overige kantoor");
            }

            db.disconnect();
        } catch (Exception e) {
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
        //</editor-fold>

        //<editor-fold desc="Overige">
        //dit is voor PieChartOverige
        int OverigeDuurDraad = 0;
        int OverigeDuurBekken = 0;
        int OverigeAfstellenMachine = 0;
        try {
            Database db = new Database();
            db.connect();

            ResultSet ah = db.get("SELECT count(draad_info) AS 'duur van draad' from algemeen where YEARWEEK(timestamp, 1) = YEARWEEK(NOW(), 1)");
            while (ah.next()) {
                OverigeDuurDraad = ah.getInt("duur van draad");
            }

            ResultSet aj = db.get("SELECT count(bekken) AS 'bekken versleten' FROM algemeen WHERE YEARWEEK(timestamp, 1) = YEARWEEK(NOW(), 1) && bekken = 'bekken versleten'");
            while (aj.next()) {
                OverigeDuurBekken = aj.getInt("bekken versleten");
            }
            ResultSet ai = db.get("SELECT count(onderhoud) AS 'instellen van machine' from algemeen where YEARWEEK(timestamp, 1) = YEARWEEK(NOW(), 1)");
            while (ai.next()) {
                OverigeAfstellenMachine = ai.getInt("instellen van machine");
            }

            db.disconnect();
        } catch (Exception e) {
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
        try {
            Database db = new Database();
            db.connect();

            ResultSet ak = db.get("SELECT count(status) AS 'foutmeldingen' from algemeen where YEARWEEK(timestamp, 1) = YEARWEEK(NOW(), 1) && status = 'fout'");
            while (ak.next()) {
                StoringenMachineKapot = ak.getInt("foutmeldingen");
            }

            ResultSet al = db.get("SELECT count(draad) AS 'draadStoring' from algemeen where YEARWEEK(timestamp, 1) = YEARWEEK(NOW(), 1) ");
            while (al.next()) {
                StoringenDraad = al.getInt("draadStoring");
            }
            ResultSet am = db.get("SELECT count(bekken && messen) AS 'gereedschapStoring' from algemeen where YEARWEEK(timestamp, 1) = YEARWEEK(NOW(), 1)");
            while (am.next()) {
                StoringenGereedschap = am.getInt("gereedschapStoring");
            }
            ResultSet an = db.get("SELECT count(onderhoud && stilstand) AS 'StoringOmstellen' from algemeen where YEARWEEK(timestamp, 1) = YEARWEEK(NOW(), 1)");
            while (an.next()) {
                StoringenOmstellen = an.getInt("StoringOmstellen");
            }

            db.disconnect();
        } catch (Exception e) {
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
        //</editor-fold>

        //<editor-fold desc="LaatsteFoutmelding">
        //ophalen van laatste foutmelding
        try {
            Database db = new Database();
            db.connect();

            ResultSet al = db.get("SELECT id, machine, persoon, status, coalesce(bekken, messen, draad, geen_orders, overig_spijkermakerij, geen_draad, onderhoud, overig_kantoor, stilstand, foutcode_11, overig_algemeen, status) as 'foutcode', timestamp FROM dev.algemeen WHERE 'foutcode' IS NOT NULL && persoon = 'tablet' && status = 'fout'    ORDER BY id DESC LIMIT 1;");
            while (al.next()) {
                String laatsteFoutmelding = al.getString("foutcode");
                lblLaatsteFoutmelding.setText(laatsteFoutmelding);
            }

            db.disconnect();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //</editor-fold>


    }

    public void bekijkExcel() {
        txtAInhoud.clear();
        try
        {
            //see csv file
            Desktop.getDesktop().open(new File(filepath));

            //Bestand ophalen
            Scanner data = new Scanner(new File(filepath));
            //Met voor een soort teken is het gescheiden

            data.useDelimiter(";");

            while (data.hasNext())
            {
                // De waarde uit de huidige 'cel'
                String value = data.next();
                //println of in textarea zetten nu.
                System.out.println(value);
                txtAInhoud.appendText(value + "\n");
            }
            data.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void OpslaanInExcel() {
        // alles voor excel sheet

        String Weekdag = "";
        String Weeknaam = "";
        String Productiviteit = "";
        String aantalKerenStilstandSpijkemakerij = "";
        String aantalKerenStilstandKantoor = "";
        String aantalKerenStilstandOverige = "";
        String aantalgeproduceerd = "";

        try {
            Database db = new Database();
            db.connect();

            ResultSet gh = db.get("select dayname(curdate()) as 'dagnaam'");
            while (gh.next()) {
                Weekdag = gh.getString("dagnaam");
            }

            ResultSet ga = db.get("select weekofyear(curdate()) as 'WeekNummer'");
            while (ga.next()) {
                Weeknaam = ga.getString("WeekNummer");
            }

            ResultSet gb = db.get("select round(avg(productiviteit),2) as 'gemiddelde deze week' from spijkers  where weekofyear(curdate())");
            while (gb.next()) {
                Productiviteit = gb.getString("gemiddelde deze week");
            }

            ResultSet gc = db.get("SELECT count(draad && bekken && messen && overig_spijkermakerij ) AS 'aantalKerenStilstandSpijkemakerijQuery' from algemeen where weekofyear(curdate())");
            while (gc.next()) {
                aantalKerenStilstandSpijkemakerij = gc.getString("aantalKerenStilstandSpijkemakerijQuery");
            }

            ResultSet gd = db.get("SELECT count(geen_orders && geen_draad && onderhoud && overig_kantoor ) AS 'aantalKerenStilstandKantoorQuery' from algemeen where weekofyear(curdate())");
            while (gd.next()) {
                aantalKerenStilstandKantoor = gd.getString("aantalKerenStilstandKantoorQuery");
            }

            ResultSet ge = db.get("SELECT count(stilstand && draad_info && bekken && overig_algemeen ) AS 'aantalKerenStilstandOverigeQuery' from algemeen where weekofyear(curdate())");
            while (ge.next()) {
                aantalKerenStilstandOverige = ge.getString("aantalKerenStilstandOverigeQuery");
            }

            ResultSet gf = db.get("SELECT count(stilstand && draad_info && bekken && overig_algemeen ) AS 'aantalGeproduceerd' from algemeen where weekofyear(curdate())");
            while (gf.next()) {
                aantalgeproduceerd = gf.getString("aantalGeproduceerd");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if(Weekdag.equals("Friday")) {
            //write in csv file
            try {
                FileWriter writer = new FileWriter(filepath, true);
                writer.append(Weeknaam).append(";").append(Productiviteit).append(";").append(aantalKerenStilstandSpijkemakerij).append(";").append(aantalKerenStilstandKantoor).append(";").append(aantalKerenStilstandOverige).append(";").append(aantalgeproduceerd).append("\n");
                writer.flush();
                writer.close();
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        else
        {
            JOptionPane.showMessageDialog(frame, "het is vandaag geen vrijdag");
        }

    }


    public void SendData() {
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

        try {
            Database db = new Database();
            db.connect();

            db.query("insert into orders(machine, ordernummer, kopsoort, draad_d_1, afm_mm, d_2_mm, h_1_mm, l_1) values ('" + Machine + "', '" + Ordernummer1 + "', '" + Kopsoort + "', '" + Draad_d_11 + "', '" + Afm_mm1 + "', '" + Draad_2_11 + "', '" + H_1_mm1 + "', '" + L_1_mm1 + "' )");


            db.disconnect();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void clearTextField() {
        txtMachine.clear();
        txtDraad_d_2.clear();
        txtL_1_mm.clear();
        txtKopsoort.clear();
        txtOrdernummer.clear();
        txtH_1_mm.clear();
        txtDraad_d_1.clear();
        txtAfm_mm.clear();
    }

    public void showSpijkemakerij() {
        pnKantoor.setVisible(false);
        pnOverige.setVisible(false);
        pnSpijkemakerij.setVisible(true);
        pnAlgemeen.setVisible(false);
        pnStoringen.setVisible(false);
        pnOrders.setVisible(false);
        pnExcel.setVisible(false);


    }

    public void showKantoor() {
        pnAlgemeen.setVisible(false);
        pnKantoor.setVisible(true);
        pnSpijkemakerij.setVisible(false);
        pnOverige.setVisible(false);
        pnStoringen.setVisible(false);
        pnOrders.setVisible(false);
        pnExcel.setVisible(false);
    }

    public void showOverige() {
        pnAlgemeen.setVisible(false);
        pnKantoor.setVisible(false);
        pnSpijkemakerij.setVisible(false);
        pnOverige.setVisible(true);
        pnStoringen.setVisible(false);
        pnOrders.setVisible(false);
        pnExcel.setVisible(false);
    }

    public void TerugSpijkemakerij() {
        pnAlgemeen.setVisible(true);
        pnKantoor.setVisible(false);
        pnSpijkemakerij.setVisible(false);
        pnOverige.setVisible(false);
        pnStoringen.setVisible(false);
        pnOrders.setVisible(false);
        pnExcel.setVisible(false);
    }

    public void TerugKantoor() {
        pnAlgemeen.setVisible(true);
        pnKantoor.setVisible(false);
        pnSpijkemakerij.setVisible(false);
        pnOverige.setVisible(false);
        pnStoringen.setVisible(false);
        pnOrders.setVisible(false);
        pnExcel.setVisible(false);
    }

    public void TerugOverige() {
        pnAlgemeen.setVisible(true);
        pnKantoor.setVisible(false);
        pnSpijkemakerij.setVisible(false);
        pnOverige.setVisible(false);
        pnStoringen.setVisible(false);
        pnOrders.setVisible(false);
        pnExcel.setVisible(false);

    }

    public void showStoring() {
        pnAlgemeen.setVisible(false);
        pnKantoor.setVisible(false);
        pnSpijkemakerij.setVisible(false);
        pnOverige.setVisible(false);
        pnStoringen.setVisible(true);
        pnOrders.setVisible(false);
        pnExcel.setVisible(false);
    }

    public void TerugStoringen() {
        pnAlgemeen.setVisible(true);
        pnKantoor.setVisible(false);
        pnSpijkemakerij.setVisible(false);
        pnOverige.setVisible(false);
        pnStoringen.setVisible(false);
        pnOrders.setVisible(false);
        pnExcel.setVisible(false);
    }

    public void showOrders() {
        pnAlgemeen.setVisible(false);
        pnKantoor.setVisible(false);
        pnSpijkemakerij.setVisible(false);
        pnOverige.setVisible(false);
        pnStoringen.setVisible(false);
        pnOrders.setVisible(true);
        pnExcel.setVisible(false);
    }

    public void TerugOrders() {
        pnAlgemeen.setVisible(true);
        pnKantoor.setVisible(false);
        pnSpijkemakerij.setVisible(false);
        pnOverige.setVisible(false);
        pnStoringen.setVisible(false);
        pnOrders.setVisible(false);
        pnExcel.setVisible(false);
    }

    public void showExcel() {
        pnAlgemeen.setVisible(false);
        pnKantoor.setVisible(false);
        pnSpijkemakerij.setVisible(false);
        pnOverige.setVisible(false);
        pnStoringen.setVisible(false);
        pnOrders.setVisible(false);
        pnExcel.setVisible(true);
    }

    public void terugExcel() {
        pnAlgemeen.setVisible(true);
        pnKantoor.setVisible(false);
        pnSpijkemakerij.setVisible(false);
        pnOverige.setVisible(false);
        pnStoringen.setVisible(false);
        pnOrders.setVisible(false);
        pnExcel.setVisible(false);
    }
}
