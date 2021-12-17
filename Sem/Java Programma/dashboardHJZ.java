<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.chart.PieChart?>
<?import javafx.scene.control.Button?>
<?import javafx.scene.control.Label?>
<?import javafx.scene.layout.Pane?>
<?import javafx.scene.text.Font?>

<Pane fx:id="pnGeneral" prefHeight="778.0" prefWidth="1258.0" xmlns="http://javafx.com/javafx/17" xmlns:fx="http://javafx.com/fxml/1" fx:controller="sample.Controller">
   <children>
      <Pane fx:id="pnAlgemeen" layoutY="-14.0" prefHeight="778.0" prefWidth="1258.0">
         <children>
            <Button fx:id="btnSpijkermakerij" mnemonicParsing="false" onAction="#showSpijkemakerij" prefHeight="103.0" prefWidth="140.0" style="-fx-background-color: blue;" text="spijkermakerij" textFill="#fafafa" />
            <Button fx:id="btnKantoor" layoutY="102.0" mnemonicParsing="false" onAction="#showKantoor" prefHeight="103.0" prefWidth="140.0" style="-fx-background-color: blue;" text="kantoor" textFill="WHITE" />
            <Button fx:id="btnOverig" focusTraversable="false" layoutY="202.0" mnemonicParsing="false" onAction="#showOverige" prefHeight="94.0" prefWidth="140.0" style="-fx-background-color: blue;" text="overige" textFill="WHITE" />
            <Button fx:id="btnStoring" layoutY="296.0" mnemonicParsing="false" onAction="#showStoring" prefHeight="103.0" prefWidth="140.0" style="-fx-background-color: blue;" text="storingen" textFill="WHITE" />
            <PieChart fx:id="PCAlgemeen" layoutX="140.0" layoutY="14.0" legendSide="RIGHT" mouseTransparent="true" prefHeight="400.0" prefWidth="1130.0" title="productie" />
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
         </children>
      </Pane>
      <Pane fx:id="pnSpijkemakerij" prefHeight="778.0" prefWidth="1258.0" visible="false">
         <children>
            <Button fx:id="btnTerugSpijkemakerij" layoutX="14.0" layoutY="345.0" mnemonicParsing="false" onAction="#TerugSpijkemakerij" style="-fx-background-color: blue;" text="Terug" textFill="WHITE" />
            <PieChart fx:id="PCSpijkemakerij" layoutX="130.0" legendSide="RIGHT" prefHeight="778.0" prefWidth="1130.0" title="spijkermakerij" />
         </children>
      </Pane>
      <Pane fx:id="pnKantoor" layoutX="-1.0" prefHeight="778.0" prefWidth="1258.0" visible="false">
         <children>
            <PieChart fx:id="PCKantoor" layoutX="139.0" legendSide="RIGHT" prefHeight="778.0" prefWidth="1120.0" title="kantoor" />
            <Button fx:id="btnTerugKantoor" layoutX="14.0" layoutY="344.0" mnemonicParsing="false" onAction="#TerugKantoor" style="-fx-background-color: blue;" text="terug" textFill="WHITE" />
         </children>
      </Pane>
      <Pane fx:id="pnOverige" prefHeight="778.0" prefWidth="1258.0" visible="false">
         <children>
            <PieChart fx:id="PCOverige" layoutX="138.0" legendSide="RIGHT" prefHeight="778.0" prefWidth="1120.0" title="overige" />
            <Button fx:id="btnTerugOverige" layoutX="14.0" layoutY="346.0" mnemonicParsing="false" onAction="#TerugOverige" style="-fx-background-color: blue;" text="Terug" textFill="WHITE" />
         </children>
      </Pane>
      <Pane fx:id="pnStoringen" prefHeight="771.0" prefWidth="1258.0" visible="false">
         <children>
            <PieChart fx:id="PCStoringen" layoutX="135.0" layoutY="-3.0" legendSide="RIGHT" prefHeight="778.0" prefWidth="1120.0" title="storingen" />
            <Button fx:id="btnTerugStoringen" layoutX="14.0" layoutY="345.0" mnemonicParsing="false" onAction="#TerugStoringen" style="-fx-background-color: blue;" text="terug" textFill="WHITE" />
            <Button fx:id="btnTestVerbinding" mnemonicParsing="false" onAction="#TestVerbinding" text="test verbinding" />
         </children>
      </Pane>
   </children>
</Pane>
