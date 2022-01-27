<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.chart.PieChart?>
<?import javafx.scene.control.Button?>
<?import javafx.scene.control.Label?>
<?import javafx.scene.control.TextField?>
<?import javafx.scene.image.Image?>
<?import javafx.scene.image.ImageView?>
<?import javafx.scene.layout.Pane?>
<?import javafx.scene.text.Font?>

<Pane fx:id="pnGeneral" prefHeight="778.0" prefWidth="1258.0" xmlns="http://javafx.com/javafx/17" xmlns:fx="http://javafx.com/fxml/1" fx:controller="sample.Controller">
   <children>
      <Pane fx:id="pnAlgemeen" layoutY="-3.0" prefHeight="778.0" prefWidth="1258.0">
         <children>
            <Button fx:id="btnSpijkermakerij" mnemonicParsing="false" onAction="#showSpijkemakerij" prefHeight="63.0" prefWidth="140.0" style="-fx-background-color: blue;" text="Spijkermakerij" textFill="#fafafa" />
            <Button fx:id="btnKantoor" layoutX="140.0" mnemonicParsing="false" onAction="#showKantoor" prefHeight="63.0" prefWidth="140.0" style="-fx-background-color: blue;" text="Kantoor" textFill="WHITE" />
            <Button fx:id="btnOverig" focusTraversable="false" layoutX="280.0" mnemonicParsing="false" onAction="#showOverige" prefHeight="63.0" prefWidth="140.0" style="-fx-background-color: blue;" text="Overige" textFill="WHITE" />
            <Button fx:id="btnStoring" layoutX="420.0" mnemonicParsing="false" onAction="#showStoring" prefHeight="63.0" prefWidth="140.0" style="-fx-background-color: blue;" text="Storingen" textFill="WHITE" />
            <PieChart fx:id="PCAlgemeen" layoutY="63.0" legendSide="RIGHT" mouseTransparent="true" prefHeight="408.0" prefWidth="1258.0" title="productie" />
            <Label layoutX="155.0" layoutY="472.0" prefHeight="30.0" prefWidth="243.0" text="aantal geproduceerd vandaag">
               <font>
                  <Font size="18.0" />
               </font></Label>
            <Label layoutX="941.0" layoutY="478.0" text="aantal geproduceerd deze week">
               <font>
                  <Font size="18.0" />
               </font></Label>
            <Label fx:id="lblProductiviteit" layoutX="168.0" layoutY="585.0" prefHeight="25.0" prefWidth="112.0" text="Label">
               <font>
                  <Font name="Arial Narrow" size="54.0" />
               </font>
            </Label>
            <Label layoutX="158.0" layoutY="559.0" prefHeight="18.0" prefWidth="234.0" text="productiviteit vandaag">
               <font>
                  <Font size="18.0" />
               </font></Label>
            <Label layoutX="288.0" layoutY="589.0" text="\%">
               <font>
                  <Font name="Arial Narrow" size="54.0" />
               </font>
            </Label>
            <Label fx:id="lblProductieVandaag" layoutX="168.0" layoutY="502.0" prefHeight="18.0" prefWidth="132.0" text="Label">
               <font>
                  <Font name="Arial Narrow" size="31.0" />
               </font>
            </Label>
            <Label fx:id="lblProductieWeek" layoutX="977.0" layoutY="502.0" text="Label">
               <font>
                  <Font name="Arial Narrow" size="31.0" />
               </font>
            </Label>
            <Label layoutX="949.0" layoutY="550.0" text="productiviteit van deze week">
               <font>
                  <Font size="18.0" />
               </font>
            </Label>
            <Label fx:id="lblPercentageWeek" layoutX="977.0" layoutY="579.0" text="Label">
               <font>
                  <Font size="54.0" />
               </font>
            </Label>
            <Label layoutX="1121.0" layoutY="584.0" text="\%">
               <font>
                  <Font name="Arial Narrow" size="54.0" />
               </font>
            </Label>
            <Button fx:id="btnOrders" layoutX="559.0" mnemonicParsing="false" onAction="#showOrders" prefHeight="63.0" prefWidth="140.0" style="-fx-background-color: blue;" text="Orders" textFill="#fafafa" />
            <ImageView fitHeight="150.0" fitWidth="200.0" layoutX="52.0" layoutY="662.0" pickOnBounds="true" preserveRatio="true">
               <image>
                  <Image url="@pictures/hjz.png" />
               </image>
            </ImageView>
            <Button fx:id="btnRefresh" layoutX="1118.0" mnemonicParsing="false" onAction="#TestVerbinding" prefHeight="63.0" prefWidth="140.0" style="-fx-background-color: blue;" text="Refresh" textFill="#fafafa" />
            <Label layoutX="559.0" layoutY="472.0" prefHeight="30.0" prefWidth="243.0" text="laatste foutmelding">
               <font>
                  <Font size="18.0" />
               </font>
            </Label>
            <Label fx:id="lblLaatsteFoutmelding" layoutX="559.0" layoutY="502.0" prefHeight="50.0" prefWidth="297.0" text="Label">
               <font>
                  <Font name="Arial Narrow" size="31.0" />
               </font>
            </Label>
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
