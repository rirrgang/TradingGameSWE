package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class verkaufenDorfWareController {

    @FXML mainController main;
    @FXML AnchorPane verkaufenDorfWare;

    @FXML Text dorfWareNT1;
    @FXML Text dorfWareNT2;
    @FXML Text dorfWareNT3;
    @FXML Text dorfWareNT4;

    @FXML Text dorfWareAIT1;
    @FXML Text dorfWareAIT2;
    @FXML Text dorfWareAIT3;
    @FXML Text dorfWareAIT4;

    @FXML Text dorfWareVPT1;
    @FXML Text dorfWareVPT2;
    @FXML Text dorfWareVPT3;
    @FXML Text dorfWareVPT4;

    @FXML Text dorfWareStatusT1;
    @FXML Text dorfWareStatusT2;
    @FXML Text dorfWareStatusT3;
    @FXML Text dorfWareStatusT4;

    @FXML TextField dorfWareTF1;
    @FXML TextField dorfWareTF2;
    @FXML TextField dorfWareTF3;
    @FXML TextField dorfWareTF4;

    @FXML Button dorfWareButton1;
    @FXML Button dorfWareButton2;
    @FXML Button dorfWareButton3;
    @FXML Button dorfWareButton4;

    public boolean bool = true;
    int count1;
    int count2;
    int count3;
    int count4;

    public void init(mainController mainController){
        main = mainController;
    }

    public void resetCounter(){
        count1 = 0;
        count2 = 0;
        count3 = 0;
        count4 = 0;
    }

    public void back(){
        if (bool == true){
            main.inputController.enableButtons();
        }
        verkaufenDorfWare.setVisible(false);
        main.statusController.updateStatus();
        main.statusController.status.setVisible(true);
    }

    public void showWarenDaten() {

        dorfWareTF1.setText("");
        dorfWareTF2.setText("");
        dorfWareTF3.setText("");
        dorfWareTF4.setText("");

        dorfWareTF1.setPromptText("");
        dorfWareTF2.setPromptText("");
        dorfWareTF3.setPromptText("");
        dorfWareTF4.setPromptText("");

        dorfWareNT1.setText(main.spiel.player.getInventar().get(6).getName());
        dorfWareNT2.setText(main.spiel.player.getInventar().get(7).getName());
        dorfWareNT3.setText(main.spiel.player.getInventar().get(8).getName());
        dorfWareNT4.setText(main.spiel.player.getInventar().get(9).getName());

        dorfWareVPT1.setText("Preis: "+ main.spiel.player.getInventar().get(6).getVerkaufspreis() + " Gold");
        dorfWareVPT2.setText("Preis: "+ main.spiel.player.getInventar().get(7).getVerkaufspreis() + " Gold");
        dorfWareVPT3.setText("Preis: "+ main.spiel.player.getInventar().get(8).getVerkaufspreis() + " Gold");
        dorfWareVPT4.setText("Preis: "+ main.spiel.player.getInventar().get(9).getVerkaufspreis() + " Gold");

        dorfWareAIT1.setText("Anzahl: " + main.spiel.player.getInventar().get(6).getMenge());
        dorfWareAIT2.setText("Anzahl: " + main.spiel.player.getInventar().get(7).getMenge());
        dorfWareAIT3.setText("Anzahl: " + main.spiel.player.getInventar().get(8).getMenge());
        dorfWareAIT4.setText("Anzahl: " + main.spiel.player.getInventar().get(9).getMenge());

        //Statustext
        dorfWareStatusT1.setText("");
        dorfWareStatusT2.setText("");
        dorfWareStatusT3.setText("");
        dorfWareStatusT4.setText("");

    }

    public void verkaufen(ActionEvent event){

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
            b = main.spiel.player.verkaufen(6,kaufmenge);
            count1+=kaufmenge;
            if (b){
                dorfWareStatusT1.setText("Du hast "+count1+" Weizen verkauft.");
                main.tabController.setTabText();
            }else{
                dorfWareStatusT1.setText("Zu wenig Waren im Inventar.");
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
            b = main.spiel.player.verkaufen(7,kaufmenge);
            count2+=kaufmenge;
            if (b){
                dorfWareStatusT2.setText("Du hast "+count2+" Mais verkauft.");
                main.tabController.setTabText();
            }else{
                dorfWareStatusT2.setText("Zu wenig Waren im Inventar.");
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
            b = main.spiel.player.verkaufen(8,kaufmenge);
            count3+=kaufmenge;
            if (b){
                dorfWareStatusT3.setText("Du hast "+count3+" Kartoffel(n) verkauft.");
                main.tabController.setTabText();
            }else{
                dorfWareStatusT3.setText("Zu wenig Waren im Inventar.");
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
            b = main.spiel.player.verkaufen(9,kaufmenge);
            count4+=kaufmenge;
            if (b){
                dorfWareStatusT4.setText("Du hast "+count4+" Rübe(n) verekauft.");
                main.tabController.setTabText();
            }else{
                dorfWareStatusT4.setText("Zu wenig Waren im Inventar.");
            }
        }
    }



}
