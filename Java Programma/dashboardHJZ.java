<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.chart.PieChart?>
<?import javafx.scene.control.Button?>
<?import javafx.scene.control.ChoiceBox?>
<?import javafx.scene.control.Label?>
<?import javafx.scene.control.TextArea?>
<?import javafx.scene.control.TextField?>
<?import javafx.scene.image.Image?>
<?import javafx.scene.image.ImageView?>
<?import javafx.scene.layout.Pane?>
<?import javafx.scene.text.Font?>

<Pane fx:id="pnGeneral" prefHeight="778.0" prefWidth="1258.0" xmlns="http://javafx.com/javafx/18" xmlns:fx="http://javafx.com/fxml/1" fx:controller="sample.Controller">
   <children>
      <Pane fx:id="pnAlgemeen" layoutX="-1.0" layoutY="-2.0" prefHeight="778.0" prefWidth="1258.0">
         <children>
            <Button fx:id="btnSpijkermakerij" mnemonicParsing="false" onAction="#showSpijkemakerij" prefHeight="63.0" prefWidth="140.0" style="-fx-background-color: blue;" text="Spijkermakerij" textFill="#fafafa" />
            <Button fx:id="btnKantoor" layoutX="140.0" mnemonicParsing="false" onAction="#showKantoor" prefHeight="63.0" prefWidth="140.0" style="-fx-background-color: blue;" text="Kantoor" textFill="WHITE" />
            <Button fx:id="btnOverig" focusTraversable="false" layoutX="280.0" mnemonicParsing="false" onAction="#showOverige" prefHeight="63.0" prefWidth="140.0" style="-fx-background-color: blue;" text="Overige" textFill="WHITE" />
            <Button fx:id="btnStoring" layoutX="420.0" mnemonicParsing="false" onAction="#showStoring" prefHeight="63.0" prefWidth="140.0" style="-fx-background-color: blue;" text="Storingen" textFill="WHITE" />
            <Button fx:id="btnOrders" layoutX="559.0" mnemonicParsing="false" onAction="#showOrders" prefHeight="63.0" prefWidth="140.0" style="-fx-background-color: blue;" text="Orders" textFill="#fafafa" />
            <Button fx:id="btnRefresh" layoutX="1118.0" mnemonicParsing="false" onAction="#TestVerbinding" prefHeight="63.0" prefWidth="140.0" style="-fx-background-color: blue;" text="Refresh" textFill="#fafafa" />
            <Button fx:id="btnExcel" layoutX="699.0" mnemonicParsing="false" onAction="#showExcel" prefHeight="63.0" prefWidth="140.0" style="-fx-background-color: blue;" text="Excel" textFill="#fafafa" />
            <ChoiceBox fx:id="CbTijd" layoutX="14.0" layoutY="106.0" prefHeight="25.0" prefWidth="132.0" />
            <ImageView fx:id="imgHJZ" fitHeight="150.0" fitWidth="200.0" layoutX="52.0" layoutY="662.0" pickOnBounds="true" preserveRatio="true">
               <image>
                  <Image url="@pictures/hjz.png" />
               </image>
            </ImageView>
            <PieChart fx:id="PCAlgemeenDag" layoutY="63.0" legendSide="RIGHT" mouseTransparent="true" prefHeight="408.0" prefWidth="1258.0" title="productie" />
            <PieChart fx:id="PCAlgemeenWeek" layoutY="63.0" legendSide="RIGHT" mouseTransparent="true" prefHeight="408.0" prefWidth="1258.0" title="productie" visible="false" />
            <PieChart fx:id="PCAlgemeenMaand" layoutY="63.0" legendSide="RIGHT" mouseTransparent="true" prefHeight="408.0" prefWidth="1258.0" title="productie" visible="false" />
            <PieChart fx:id="PCAlgemeenJaar" layoutY="63.0" legendSide="RIGHT" mouseTransparent="true" prefHeight="408.0" prefWidth="1258.0" title="productie" visible="false" />
            <Label fx:id="lblAantalGeproduceerdVandaag" layoutX="152.0" layoutY="473.0" prefHeight="30.0" prefWidth="243.0" text="aantal geproduceerd vandaag">
               <font>
                  <Font size="18.0" />
               </font></Label>
            <Label fx:id="lblAantalGeproduceerdDezeWeek" layoutX="153.0" layoutY="474.0" text="aantal geproduceerd deze week" visible="false">
               <font>
                  <Font size="18.0" />
               </font></Label>
            <Label fx:id="lblAantalGeproduceerdMaand" layoutX="155.0" layoutY="472.0" prefHeight="30.0" prefWidth="275.0" text="aantal geproduceerd deze maand" visible="false">
               <font>
                  <Font size="18.0" />
               </font>
            </Label>
            <Label fx:id="lblAantalGeproduceerdJaar" layoutX="155.0" layoutY="472.0" prefHeight="30.0" prefWidth="275.0" text="aantal geproduceerd dit jaar" visible="false">
               <font>
                  <Font size="18.0" />
               </font>
            </Label>
            <Label fx:id="lblProductivieitVandaag" layoutX="826.0" layoutY="474.0" prefHeight="18.0" prefWidth="234.0" text="productiviteit vandaag">
               <font>
                  <Font size="18.0" />
               </font>
            </Label>
            <Label fx:id="lblProductiviteitVanDezeWeek" layoutX="829.0" layoutY="474.0" text="productiviteit van deze week" visible="false">
               <font>
                  <Font size="18.0" />
               </font>
            </Label>
            <Label fx:id="lblProductiviteitVanDezeMaand" layoutX="823.0" layoutY="475.0" text="productiviteit van deze maand" visible="false">
               <font>
                  <Font size="18.0" />
               </font>
            </Label>
            <Label fx:id="lblProductiviteitVanDitJaar" layoutX="822.0" layoutY="475.0" text="productiviteit van dit jaar" visible="false">
               <font>
                  <Font size="18.0" />
               </font>
            </Label>
            <Label fx:id="lblProductieVandaag" layoutX="155.0" layoutY="502.0" prefHeight="18.0" prefWidth="132.0" text="Label">
               <font>
                  <Font size="31.0" />
               </font>
            </Label>
            <Label fx:id="lblProductieWeek" layoutX="155.0" layoutY="502.0" text="Label" visible="false">
               <font>
                  <Font name="Arial Narrow" size="31.0" />
               </font>
            </Label>
            <Label fx:id="lblProductieMaand" layoutX="155.0" layoutY="502.0" text="Label" visible="false">
               <font>
                  <Font size="31.0" />
               </font>
            </Label>
            <Label fx:id="lblProductieJaar" layoutX="155.0" layoutY="502.0" text="Label" visible="false">
               <font>
                  <Font size="31.0" />
               </font>
            </Label>
            <Label fx:id="lblProductiviteit" layoutX="831.0" layoutY="502.0" prefHeight="46.0" prefWidth="121.0" text="Label">
               <font>
                  <Font size="31.0" />
               </font>
            </Label>
            <Label fx:id="lblPercentageWeek" layoutX="831.0" layoutY="497.0" prefHeight="46.0" prefWidth="106.0" text="Label" visible="false">
               <font>
                  <Font size="31.0" />
               </font>
            </Label>
            <Label fx:id="lblPercentageMaand" layoutX="831.0" layoutY="502.0" prefHeight="46.0" prefWidth="106.0" text="Label" visible="false">
               <font>
                  <Font size="31.0" />
               </font>
            </Label>
            <Label fx:id="lblPercentageJaar" layoutX="831.0" layoutY="504.0" prefHeight="46.0" prefWidth="106.0" text="Label" visible="false">
               <font>
                  <Font size="31.0" />
               </font>
            </Label>
            <Label fx:id="txtPercentageTeken1" layoutX="1008.0" layoutY="509.0" text="\%">
               <font>
                  <Font name="Arial Narrow" size="31.0" />
               </font>
            </Label>
            <Label fx:id="lblLaatstFoutmelding" layoutX="484.0" layoutY="472.0" prefHeight="30.0" prefWidth="243.0" text="laatste foutmelding">
               <font>
                  <Font size="18.0" />
               </font>
            </Label>
            <Label fx:id="lblLaatsteFoutmelding" layoutX="484.0" layoutY="502.0" prefHeight="50.0" prefWidth="275.0" text="Label" textAlignment="CENTER">
               <font>
                  <Font name="Arial Narrow" size="31.0" />
               </font>
            </Label>
            <Label fx:id="LblPeriode" layoutX="40.0" layoutY="76.0" prefHeight="30.0" prefWidth="80.0" text="periode;" textAlignment="CENTER" />
            <Label fx:id="lblProductieJaarM" layoutX="312.0" layoutY="504.0" text="Duizend." visible="false">
               <font>
                  <Font size="31.0" />
               </font>
            </Label>
         </children>
      </Pane>
      <Pane fx:id="pnExcel" prefHeight="778.0" prefWidth="1258.0" visible="false">
         <children>
            <ImageView fitHeight="150.0" fitWidth="200.0" layoutX="14.0" layoutY="677.0" pickOnBounds="true" preserveRatio="true">
               <image>
                  <Image url="@pictures/hjz.png" />
               </image>
            </ImageView>
            <Button fx:id="btnTerugExcel" layoutX="14.0" layoutY="364.0" mnemonicParsing="false" onAction="#terugExcel" style="-fx-background-color: blue;" text="Terug" textFill="WHITE" />
            <TextArea fx:id="txtAInhoud" layoutX="93.0" layoutY="41.0" prefHeight="653.0" prefWidth="1113.0" />
            <Button fx:id="btnBekijkExcel" layoutX="1038.0" layoutY="720.0" mnemonicParsing="false" onAction="#bekijkExcel" style="-fx-background-color: blue;" text="Bekijk Excel" textFill="WHITE" />
            <Button fx:id="btnOpslaanInExcel" layoutX="1150.0" layoutY="720.0" mnemonicParsing="false" onAction="#OpslaanInExcel" style="-fx-background-color: blue;" text="Opslaan" textFill="WHITE" />
         </children>
      </Pane>
      <Pane fx:id="pnSpijkemakerij" prefHeight="778.0" prefWidth="1258.0" visible="false">
         <children>
            <Button fx:id="btnTerugSpijkemakerij" layoutX="14.0" layoutY="345.0" mnemonicParsing="false" onAction="#TerugSpijkemakerij" style="-fx-background-color: blue;" text="Terug" textFill="WHITE" />
            <PieChart fx:id="PCSpijkemakerij" layoutX="130.0" legendSide="RIGHT" prefHeight="778.0" prefWidth="1130.0" title="spijkermakerij" />
            <ImageView fitHeight="150.0" fitWidth="200.0" layoutX="46.0" layoutY="660.0" pickOnBounds="true" preserveRatio="true">
               <image>
                  <Image url="@pictures/hjz.png" />
               </image>
            </ImageView>
         </children>
      </Pane>
      <Pane fx:id="pnKantoor" layoutX="-1.0" prefHeight="778.0" prefWidth="1258.0" visible="false">
         <children>
            <PieChart fx:id="PCKantoor" layoutX="139.0" legendSide="RIGHT" prefHeight="778.0" prefWidth="1120.0" title="kantoor" />
            <Button fx:id="btnTerugKantoor" layoutX="14.0" layoutY="344.0" mnemonicParsing="false" onAction="#TerugKantoor" style="-fx-background-color: blue;" text="terug" textFill="WHITE" />
            <ImageView fitHeight="150.0" fitWidth="200.0" layoutX="49.0" layoutY="659.0" pickOnBounds="true" preserveRatio="true">
               <image>
                  <Image url="@pictures/hjz.png" />
               </image>
            </ImageView>
         </children>
      </Pane>
      <Pane fx:id="pnOverige" prefHeight="778.0" prefWidth="1258.0" visible="false">
         <children>
            <PieChart fx:id="PCOverige" layoutX="138.0" legendSide="RIGHT" prefHeight="778.0" prefWidth="1120.0" title="overige" />
            <Button fx:id="btnTerugOverige" layoutX="14.0" layoutY="346.0" mnemonicParsing="false" onAction="#TerugOverige" style="-fx-background-color: blue;" text="Terug" textFill="WHITE" />
            <ImageView fitHeight="150.0" fitWidth="200.0" layoutX="50.0" layoutY="661.0" pickOnBounds="true" preserveRatio="true">
               <image>
                  <Image url="@pictures/hjz.png" />
               </image>
            </ImageView>
         </children>
      </Pane>
      <Pane fx:id="pnStoringen" prefHeight="771.0" prefWidth="1258.0" visible="false">
         <children>
            <PieChart fx:id="PCStoringen" layoutX="135.0" layoutY="-3.0" legendSide="RIGHT" prefHeight="778.0" prefWidth="1120.0" title="storingen" />
            <Button fx:id="btnTerugStoringen" layoutX="14.0" layoutY="345.0" mnemonicParsing="false" onAction="#TerugStoringen" style="-fx-background-color: blue;" text="Terug" textFill="WHITE" />
            <Button fx:id="btnTestVerbinding" layoutX="1120.0" layoutY="719.0" mnemonicParsing="false" onAction="#TestVerbinding" text="test verbinding" />
            <ImageView fitHeight="150.0" fitWidth="200.0" layoutX="43.0" layoutY="645.0" pickOnBounds="true" preserveRatio="true">
               <image>
                  <Image url="@pictures/hjz.png" />
               </image>
            </ImageView>
         </children>
      </Pane>
      <Pane fx:id="pnOrders" layoutX="-1.0" layoutY="1.0" prefHeight="771.0" prefWidth="1258.0" visible="false">
         <children>
            <Button fx:id="btnTerugOrders" layoutX="14.0" layoutY="342.0" mnemonicParsing="false" onAction="#TerugOrders" text="Terug" />
            <Button fx:id="btnSendDataOrders" layoutX="1080.0" layoutY="655.0" mnemonicParsing="false" onAction="#SendData" prefHeight="38.0" prefWidth="94.0" text="Send Data" />
            <Label layoutX="204.0" layoutY="116.0" text="machine" />
            <TextField fx:id="txtMachine" layoutX="294.0" layoutY="116.0" prefHeight="26.0" prefWidth="150.0" />
            <TextField fx:id="txtOrdernummer" layoutX="680.0" layoutY="116.0" prefHeight="26.0" prefWidth="150.0" />
            <TextField fx:id="txtKopsoort" layoutX="294.0" layoutY="186.0" prefHeight="26.0" prefWidth="150.0" />
            <TextField fx:id="txtAfm_mm" layoutX="680.0" layoutY="187.0" prefHeight="26.0" prefWidth="150.0" />
            <TextField fx:id="txtDraad_d_1" layoutX="294.0" layoutY="256.0" prefHeight="26.0" prefWidth="150.0" />
            <TextField fx:id="txtDraad_d_2" layoutX="680.0" layoutY="256.0" prefHeight="26.0" prefWidth="150.0" />
            <TextField fx:id="txtH_1_mm" layoutX="294.0" layoutY="326.0" prefHeight="26.0" prefWidth="156.0" />
            <TextField fx:id="txtL_1_mm" layoutX="680.0" layoutY="326.0" prefHeight="26.0" prefWidth="150.0" />
            <Label layoutX="551.0" layoutY="116.0" text="ordernummer" />
            <Label layoutX="204.0" layoutY="186.0" text="kopsoort" />
            <Label layoutX="551.0" layoutY="186.0" text="afm_mm" />
            <Label layoutX="204.0" layoutY="256.0" text="Draad_d_1" />
            <Label layoutX="551.0" layoutY="334.0" text="L_1_mm" />
            <Label layoutX="551.0" layoutY="256.0" text="Draad_d_2" />
            <Label layoutX="204.0" layoutY="334.0" text="H_1_mm" />
            <ImageView fitHeight="150.0" fitWidth="200.0" layoutX="84.0" layoutY="630.0" pickOnBounds="true" preserveRatio="true">
               <image>
                  <Image url="@pictures/hjz.png" />
               </image>
            </ImageView>
            <Button fx:id="btnClearTextfield" layoutX="954.0" layoutY="655.0" mnemonicParsing="false" onAction="#clearTextField" prefHeight="38.0" prefWidth="112.0" text="clear textfield" />
         </children>
      </Pane>
   </children>
</Pane>
