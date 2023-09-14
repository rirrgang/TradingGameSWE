package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class kaufenDorfController {

    @FXML mainController main;

    @FXML AnchorPane kaufenDorf;

    @FXML Button dorfWareButton1;
    @FXML Button dorfWareButton2;
    @FXML Button dorfWareButton3;
    @FXML Button dorfWareButton4;

    @FXML TextField dorfWareTF1;
    @FXML TextField dorfWareTF2;
    @FXML TextField dorfWareTF3;
    @FXML TextField dorfWareTF4;

    @FXML Text dorfWarePT1;
    @FXML Text dorfWarePT2;
    @FXML Text dorfWarePT3;
    @FXML Text dorfWarePT4;

    @FXML Text dorfWareStatusT1;
    @FXML Text dorfWareStatusT2;
    @FXML Text dorfWareStatusT3;
    @FXML Text dorfWareStatusT4;

    @FXML Text dorfWareGT1;
    @FXML Text dorfWareGT2;
    @FXML Text dorfWareGT3;
    @FXML Text dorfWareGT4;

    @FXML Text dorfWareNT1;
    @FXML Text dorfWareNT2;
    @FXML Text dorfWareNT3;
    @FXML Text dorfWareNT4;

    boolean bool = true;

    int count1=0;
    int count2=0;
    int count3=0;
    int count4=0;

    public void init(mainController mainController) {
        this.main = mainController;
    }

    public void resetCounter(){
        count1 = 0;
        count2 = 0;
        count3 = 0;
        count4 = 0;
    }

    public void showWarenDaten(){
        dorfWareTF1.setText("");
        dorfWareTF2.setText("");
        dorfWareTF3.setText("");
        dorfWareTF4.setText("");

        dorfWareTF1.setPromptText("");
        dorfWareTF2.setPromptText("");
        dorfWareTF3.setPromptText("");
        dorfWareTF4.setPromptText("");

        dorfWareNT1.setText(main.spiel.player.getStandort().getAngebote().get(0).getName());
        dorfWareNT2.setText(main.spiel.player.getStandort().getAngebote().get(1).getName());
        dorfWareNT3.setText(main.spiel.player.getStandort().getAngebote().get(2).getName());
        dorfWareNT4.setText(main.spiel.player.getStandort().getAngebote().get(3).getName());

        dorfWareGT1.setText("Gewicht: "+Double.toString(main.spiel.player.getStandort().getAngebote().get(0).getGewicht()) + " kg");
        dorfWareGT2.setText("Gewicht: "+Double.toString(main.spiel.player.getStandort().getAngebote().get(1).getGewicht()) + " kg");
        dorfWareGT3.setText("Gewicht: "+Double.toString(main.spiel.player.getStandort().getAngebote().get(2).getGewicht()) + " kg");
        dorfWareGT4.setText("Gewicht: "+Double.toString(main.spiel.player.getStandort().getAngebote().get(3).getGewicht()) + " kg");

        dorfWarePT1.setText("Preis "+Integer.toString(main.spiel.player.getStandort().getAngebote().get(0).getEinkaufspreis()) + " Gold");
        dorfWarePT2.setText("Preis "+Integer.toString(main.spiel.player.getStandort().getAngebote().get(1).getEinkaufspreis()) + " Gold");
        dorfWarePT3.setText("Preis "+Integer.toString(main.spiel.player.getStandort().getAngebote().get(2).getEinkaufspreis()) + " Gold");
        dorfWarePT4.setText("Preis "+Integer.toString(main.spiel.player.getStandort().getAngebote().get(3).getEinkaufspreis()) + " Gold");

        dorfWareStatusT1.setText("");
        dorfWareStatusT2.setText("");
        dorfWareStatusT3.setText("");
        dorfWareStatusT4.setText("");

    }

    public void back(){
        kaufenDorf.setVisible(false);
        main.statusController.updateStatus();
        main.statusController.status.setVisible(true);
        if (bool == true){
            main.inputController.enableButtons();
        }
    }

    public void kaufen(ActionEvent event){

        Object source = event.getSource();
        int kaufmenge = 0;
        boolean b;

        //Weizen
        if (source == dorfWareButton1){
            System.out.println("Einkaufspreis: "+main.spiel.player.getStandort().getAngebote().get(0).getEinkaufspreis());
            //System.out.println("Im Button1");
            if (dorfWareTF1.getText().equals("")){ dorfWareTF1.setPromptText("Anzahl eingeben."); return;}
            else {
                try {
                    kaufmenge = Integer.parseInt(dorfWareTF1.getText());
                } catch (Exception e) {
                    dorfWareTF1.setText("");
                    dorfWareTF1.setPromptText("Nur Zahlen eingeben.");
                    return;
                }
            }
            bool = false;
            b = main.spiel.player.kaufen(0,kaufmenge);
            count1+=kaufmenge;
            if (b){
                dorfWareStatusT1.setText("Du hast "+count1+" Weizen gekauft.");
                main.tabController.setTabText();
            }else{
                dorfWareStatusT1.setText("Zu wenig Gold oder keinen Platz im Inventar mehr.");
            }
        }

        //Mais
        if (source == dorfWareButton2){
            //System.out.println("Im Button1");
            if (dorfWareTF2.getText().equals("")){ dorfWareTF2.setPromptText("Anzahl benötigt."); return;}
            else {
                try {
                    kaufmenge = Integer.parseInt(dorfWareTF2.getText());
                } catch (Exception e) {
                    dorfWareTF2.setText("");
                    dorfWareTF2.setPromptText("Nur Zahlen eingeben.");
                    return;
                }
            }
            bool = false;
            b = main.spiel.player.kaufen(1,kaufmenge);
            count2+=kaufmenge;
            if (b){
                dorfWareStatusT2.setText("Du hast "+count2+" Mais gekauft.");
                main.tabController.setTabText();
            }else{
                dorfWareStatusT2.setText("Zu wenig Gold oder keinen Platz im Inventar mehr.");
            }
        }

        //Kartoffeln
        if (source == dorfWareButton3){
            //System.out.println("Im Button1");
            if (dorfWareTF3.getText().equals("")){ dorfWareTF3.setPromptText("Anzahl benötigt."); return;}
            else {
                try {
                    kaufmenge = Integer.parseInt(dorfWareTF3.getText());
                } catch (Exception e) {
                    dorfWareTF3.setText("");
                    dorfWareTF3.setPromptText("Nur Zahlen eingeben.");
                    return;
                }
            }
            bool = false;
            b = main.spiel.player.kaufen(2,kaufmenge);
            count3+=kaufmenge;
            if (b){
                dorfWareStatusT3.setText("Du hast "+count3+" Kartoffel(n) gekauft");
                main.tabController.setTabText();
            }else{
                dorfWareStatusT3.setText("Zu wenig Gold oder keinen Platz im Inventar mehr.");
            }
        }

        //Rüben
        if (source == dorfWareButton4){
            //System.out.println("Im Button1");
            if (dorfWareTF4.getText().equals("")){ dorfWareTF4.setPromptText("Anzahl benötigt."); return;}
            else {
                try {
                    kaufmenge = Integer.parseInt(dorfWareTF4.getText());
                } catch (Exception e) {
                    dorfWareTF4.setText("");
                    dorfWareTF4.setPromptText("Nur Zahlen eingeben.");
                    return;
                }
            }
            bool = false;
            b = main.spiel.player.kaufen(3,kaufmenge);
            count4+=kaufmenge;
            if (b){
                dorfWareStatusT4.setText("Du hast "+count4+" Rübe(n) gekauft.");
                main.tabController.setTabText();
            }else{
                dorfWareStatusT4.setText("Zu wenig Gold oder keinen Platz im Inventar mehr.");
            }
        }
    }



}
