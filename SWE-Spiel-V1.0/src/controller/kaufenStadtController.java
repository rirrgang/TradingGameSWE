package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class kaufenStadtController {

    @FXML mainController main;

    @FXML AnchorPane kaufenStadt;

    @FXML Button stadtWareButton1;
    @FXML Button stadtWareButton2;
    @FXML Button stadtWareButton3;
    @FXML Button stadtWareButton4;
    @FXML Button stadtWareButton5;
    @FXML Button stadtWareButton6;

    @FXML TextField stadtWareTF1;
    @FXML TextField stadtWareTF2;
    @FXML TextField stadtWareTF3;
    @FXML TextField stadtWareTF4;
    @FXML TextField stadtWareTF5;
    @FXML TextField stadtWareTF6;

    @FXML Text stadtWarePT1;
    @FXML Text stadtWarePT2;
    @FXML Text stadtWarePT3;
    @FXML Text stadtWarePT4;
    @FXML Text stadtWarePT5;
    @FXML Text stadtWarePT6;

    @FXML Text stadtWareStatusT1;
    @FXML Text stadtWareStatusT2;
    @FXML Text stadtWareStatusT3;
    @FXML Text stadtWareStatusT4;
    @FXML Text stadtWareStatusT5;
    @FXML Text stadtWareStatusT6;

    @FXML Text stadtWareGT1;
    @FXML Text stadtWareGT2;
    @FXML Text stadtWareGT3;
    @FXML Text stadtWareGT4;
    @FXML Text stadtWareGT5;
    @FXML Text stadtWareGT6;

    @FXML Text stadtWareNT1;
    @FXML Text stadtWareNT2;
    @FXML Text stadtWareNT3;
    @FXML Text stadtWareNT4;
    @FXML Text stadtWareNT5;
    @FXML Text stadtWareNT6;

    boolean bool = true;
    int count1 = 0;
    int count2 = 0;
    int count3 = 0;
    int count4 = 0;
    int count5 = 0;
    int count6 = 0;


    public void init(mainController mainController) {
        this.main = mainController;
    }

    public void resetCounter(){
        count1 = 0;
        count2 = 0;
        count3 = 0;
        count4 = 0;
        count5 = 0;
        count6 = 0;
    }

    public void showWarenDaten(){
        stadtWareTF1.setText("");
        stadtWareTF2.setText("");
        stadtWareTF3.setText("");
        stadtWareTF4.setText("");
        stadtWareTF5.setText("");
        stadtWareTF6.setText("");

        stadtWareTF1.setPromptText("");
        stadtWareTF2.setPromptText("");
        stadtWareTF3.setPromptText("");
        stadtWareTF4.setPromptText("");
        stadtWareTF5.setPromptText("");
        stadtWareTF6.setPromptText("");

        stadtWareNT1.setText(main.spiel.player.getStandort().getAngebote().get(0).getName());
        stadtWareNT2.setText(main.spiel.player.getStandort().getAngebote().get(1).getName());
        stadtWareNT3.setText(main.spiel.player.getStandort().getAngebote().get(2).getName());
        stadtWareNT4.setText(main.spiel.player.getStandort().getAngebote().get(3).getName());
        stadtWareNT5.setText(main.spiel.player.getStandort().getAngebote().get(4).getName());
        stadtWareNT6.setText(main.spiel.player.getStandort().getAngebote().get(5).getName());

        stadtWareGT1.setText("Gewicht: "+Double.toString(main.spiel.player.getStandort().getAngebote().get(0).getGewicht()) + " kg");
        stadtWareGT2.setText("Gewicht: "+Double.toString(main.spiel.player.getStandort().getAngebote().get(1).getGewicht()) + " kg");
        stadtWareGT3.setText("Gewicht: "+Double.toString(main.spiel.player.getStandort().getAngebote().get(2).getGewicht()) + " kg");
        stadtWareGT4.setText("Gewicht: "+Double.toString(main.spiel.player.getStandort().getAngebote().get(3).getGewicht()) + " kg");
        stadtWareGT5.setText("Gewicht: "+Double.toString(main.spiel.player.getStandort().getAngebote().get(4).getGewicht()) + " kg");
        stadtWareGT6.setText("Gewicht: "+Double.toString(main.spiel.player.getStandort().getAngebote().get(5).getGewicht()) + " kg");

        stadtWarePT1.setText("Preis "+Integer.toString(main.spiel.player.getStandort().getAngebote().get(0).getEinkaufspreis()) + " Gold");
        stadtWarePT2.setText("Preis "+Integer.toString(main.spiel.player.getStandort().getAngebote().get(1).getEinkaufspreis()) + " Gold");
        stadtWarePT3.setText("Preis "+Integer.toString(main.spiel.player.getStandort().getAngebote().get(2).getEinkaufspreis()) + " Gold");
        stadtWarePT4.setText("Preis "+Integer.toString(main.spiel.player.getStandort().getAngebote().get(3).getEinkaufspreis()) + " Gold");
        stadtWarePT5.setText("Preis "+Integer.toString(main.spiel.player.getStandort().getAngebote().get(4).getEinkaufspreis()) + " Gold");
        stadtWarePT6.setText("Preis "+Integer.toString(main.spiel.player.getStandort().getAngebote().get(5).getEinkaufspreis()) + " Gold");

        stadtWareStatusT1.setText("");
        stadtWareStatusT2.setText("");
        stadtWareStatusT3.setText("");
        stadtWareStatusT4.setText("");
        stadtWareStatusT5.setText("");
        stadtWareStatusT6.setText("");

    }

    public void back(){
        kaufenStadt.setVisible(false);
        main.statusController.updateStatus();
        main.statusController.status.setVisible(true);
        if (bool == true){
            main.inputController.enableButtons();
        }
    }

    public void kaufen(ActionEvent event){

        Object source = event.getSource();
        System.out.println(source);
        int kaufmenge = 0;
        boolean b;

        //Bohnen mit Speck
        if (source == stadtWareButton1){
            System.out.println("Einkaufspreis: "+main.spiel.player.getStandort().getAngebote().get(0).getEinkaufspreis());
            //System.out.println("Im Button1");
            if (stadtWareTF1.getText().equals("")){ stadtWareTF1.setPromptText("Anzahl eingeben."); return;}
            else {
                try {
                    kaufmenge = Integer.parseInt(stadtWareTF1.getText());
                } catch (Exception e) {
                    stadtWareTF1.setText("");
                    stadtWareTF1.setPromptText("Nur Zahlen eingeben.");
                    return;
                }
            }
            bool = false;
            b = main.spiel.player.kaufen(0,kaufmenge);
            count1+=kaufmenge;
            if (b){
                stadtWareStatusT1.setText("Du hast heute "+count1+" Bohnen mit Speck gekauft.");
                main.tabController.setTabText();
            }else{
                stadtWareStatusT1.setText("Zu wenig Gold oder keinen Platz im Inventar mehr.");
            }
        }

        //Töpfe
        if (source == stadtWareButton2){
            //System.out.println("Im Button1");
            if (stadtWareTF2.getText().equals("")){ stadtWareTF2.setPromptText("Anzahl benötigt."); return;}
            else {
                try {
                    kaufmenge = Integer.parseInt(stadtWareTF2.getText());
                } catch (Exception e) {
                    stadtWareTF2.setText("");
                    stadtWareTF2.setPromptText("Nur Zahlen eingeben.");
                    return;
                }
            }
            bool = false;
            b = main.spiel.player.kaufen(1,kaufmenge);
            count2+=kaufmenge;
            if (b){
                stadtWareStatusT2.setText("Du hast heute "+count2+" Töpfe gekauft.");
                main.tabController.setTabText();
            }else{
                stadtWareStatusT2.setText("Zu wenig Gold oder keinen Platz im Inventar mehr.");
            }
        }

        //Geschirr
        if (source == stadtWareButton3){
            //System.out.println("Im Button1");
            if (stadtWareTF3.getText().equals("")){ stadtWareTF3.setPromptText("Anzahl benötigt."); return;}
            else {
                try {
                    kaufmenge = Integer.parseInt(stadtWareTF3.getText());
                } catch (Exception e) {
                    stadtWareTF3.setText("");
                    stadtWareTF3.setPromptText("Nur Zahlen eingeben.");
                    return;
                }
            }
            bool = false;
            b = main.spiel.player.kaufen(2,kaufmenge);
            count3+=kaufmenge;
            if (b){
                stadtWareStatusT3.setText("Du hast heute "+count3+" Geschirr gekauft.");
                main.tabController.setTabText();
            }else{
                stadtWareStatusT3.setText("Zu wenig Gold oder keinen Platz im Inventar mehr.");
            }
        }

        //Hacke
        if (source == stadtWareButton4){
            //System.out.println("Im Button1");
            if (stadtWareTF4.getText().equals("")){ stadtWareTF4.setPromptText("Anzahl benötigt."); return;}
            else {
                try {
                    kaufmenge = Integer.parseInt(stadtWareTF4.getText());
                } catch (Exception e) {
                    stadtWareTF4.setText("");
                    stadtWareTF4.setPromptText("Nur Zahlen eingeben.");
                    return;
                }
            }
            bool = false;
            b = main.spiel.player.kaufen(3,kaufmenge);
            count4+=kaufmenge;
            if (b){
                stadtWareStatusT4.setText("Du hast heute "+count4+" Hacke(n) gekauft.");
                main.tabController.setTabText();
            }else{
                stadtWareStatusT4.setText("Zu wenig Gold oder keinen Platz im Inventar mehr.");
            }
        }

        //Hammer
        if (source == stadtWareButton5){
            //System.out.println("Im Button1");
            if (stadtWareTF5.getText().equals("")){ stadtWareTF5.setPromptText("Anzahl benötigt."); return;}
            else {
                try {
                    kaufmenge = Integer.parseInt(stadtWareTF5.getText());
                } catch (Exception e) {
                    stadtWareTF5.setText("");
                    stadtWareTF5.setPromptText("Nur Zahlen eingeben.");
                    return;
                }
            }
            bool = false;
            b = main.spiel.player.kaufen(4,kaufmenge);
            count5+=kaufmenge;
            if (b){
                stadtWareStatusT5.setText("Du hast heute "+count5+" Hammer gekauft.");
                main.tabController.setTabText();
            }else{
                stadtWareStatusT5.setText("Zu wenig Gold oder keinen Platz im Inventar mehr.");
            }
        }

        //Säge
        if (source == stadtWareButton6){
            //System.out.println("Im Button1");
            if (stadtWareTF6.getText().equals("")){ stadtWareTF6.setPromptText("Anzahl benötigt."); return;}
            else {
                try {
                    kaufmenge = Integer.parseInt(stadtWareTF6.getText());
                } catch (Exception e) {
                    stadtWareTF6.setText("");
                    stadtWareTF6.setPromptText("Nur Zahlen eingeben.");
                    return;
                }
            }
            bool = false;
            b = main.spiel.player.kaufen(5,kaufmenge);
            count6+=kaufmenge;
            if (b){
                stadtWareStatusT6.setText("Du hast heute "+count6+" Säge(n) gekauft.");
                main.tabController.setTabText();
            }else{
                stadtWareStatusT6.setText("Zu wenig Gold oder keinen Platz im Inventar mehr.");
            }
        }

    }

}
