package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class verkaufenStadtWareController {

    @FXML mainController main;

    @FXML AnchorPane verkaufenStadtWare;

    @FXML Button stadtWareButton1;
    @FXML Button stadtWareButton2;
    @FXML Button stadtWareButton3;
    @FXML Button stadtWareButton4;
    @FXML Button stadtWareButton5;

    @FXML TextField stadtWareTF1;
    @FXML TextField stadtWareTF2;
    @FXML TextField stadtWareTF3;
    @FXML TextField stadtWareTF4;
    @FXML TextField stadtWareTF5;

    @FXML Text stadtWareVPT1;
    @FXML Text stadtWareVPT2;
    @FXML Text stadtWareVPT3;
    @FXML Text stadtWareVPT4;
    @FXML Text stadtWareVPT5;

    @FXML Text stadtWareAIT1;
    @FXML Text stadtWareAIT2;
    @FXML Text stadtWareAIT3;
    @FXML Text stadtWareAIT4;
    @FXML Text stadtWareAIT5;

    @FXML Text stadtWareStatusT1;
    @FXML Text stadtWareStatusT2;
    @FXML Text stadtWareStatusT3;
    @FXML Text stadtWareStatusT4;
    @FXML Text stadtWareStatusT5;

    @FXML Text stadtWareNT1;
    @FXML Text stadtWareNT2;
    @FXML Text stadtWareNT3;
    @FXML Text stadtWareNT4;
    @FXML Text stadtWareNT5;

    @FXML Text stadtWareIT1;
    @FXML Text stadtWareIT2;
    @FXML Text stadtWareIT3;
    @FXML Text stadtWareIT4;
    @FXML Text stadtWareIT5;

    boolean bool = true;

    int count1=0;
    int count2=0;
    int count3=0;
    int count4=0;
    int count5=0;

    public void init(mainController mainController) {
        this.main = mainController;
    }

    public void resetCounter(){
        count1=0;
        count2=0;
        count3=0;
        count4=0;
        count5=0;
    }

    public String interesseText(int i){
        switch(i){
            case 0: return "kein";
            case 1: return "normal";
            case 2: return "groß";
            default:return"default";
        }
    }

    public void showWarenDaten(){

        //Name der möglichen zu verkaufenden Ware
        stadtWareTF1.setText("");
        stadtWareTF2.setText("");
        stadtWareTF3.setText("");
        stadtWareTF4.setText("");
        stadtWareTF5.setText("");

        stadtWareTF1.setText("");
        stadtWareTF2.setText("");
        stadtWareTF3.setText("");
        stadtWareTF4.setText("");
        stadtWareTF5.setText("");

        stadtWareNT1.setText(main.spiel.player.getInventar().get(1).getName());
        stadtWareNT2.setText(main.spiel.player.getInventar().get(2).getName());
        stadtWareNT3.setText(main.spiel.player.getInventar().get(3).getName());
        stadtWareNT4.setText(main.spiel.player.getInventar().get(4).getName());
        stadtWareNT5.setText(main.spiel.player.getInventar().get(5).getName());

        //Interesse-Grad der verkaufbaren Ware
        stadtWareIT1.setText("Interesse: " + interesseText(main.spiel.player.getInventar().get(1).getInteresse()));
        stadtWareIT2.setText("Interesse: " + interesseText(main.spiel.player.getInventar().get(2).getInteresse()));
        stadtWareIT3.setText("Interesse: " + interesseText(main.spiel.player.getInventar().get(3).getInteresse()));
        stadtWareIT4.setText("Interesse: " + interesseText(main.spiel.player.getInventar().get(4).getInteresse()));
        stadtWareIT5.setText("Interesse: " + interesseText(main.spiel.player.getInventar().get(5).getInteresse()));

        //Verkaufspreis
        stadtWareVPT1.setText("Preis "+Integer.toString(main.spiel.player.getInventar().get(1).getVerkaufspreis() * main.spiel.player.getInventar().get(1).getInteresse()) + " Gold");
        stadtWareVPT2.setText("Preis "+Integer.toString(main.spiel.player.getInventar().get(2).getVerkaufspreis() * main.spiel.player.getInventar().get(2).getInteresse()) + " Gold");
        stadtWareVPT3.setText("Preis "+Integer.toString(main.spiel.player.getInventar().get(3).getVerkaufspreis() * main.spiel.player.getInventar().get(3).getInteresse()) + " Gold");
        stadtWareVPT4.setText("Preis "+Integer.toString(main.spiel.player.getInventar().get(4).getVerkaufspreis() * main.spiel.player.getInventar().get(4).getInteresse()) + " Gold");
        stadtWareVPT5.setText("Preis "+Integer.toString(main.spiel.player.getInventar().get(5).getVerkaufspreis() * main.spiel.player.getInventar().get(5).getInteresse()) + " Gold");

        //Anzahl der Waren im Spieler-Inventar
        stadtWareAIT1.setText("Anzahl: " + main.spiel.player.getInventar().get(1).getMenge());
        stadtWareAIT2.setText("Anzahl: " + main.spiel.player.getInventar().get(2).getMenge());
        stadtWareAIT3.setText("Anzahl: " + main.spiel.player.getInventar().get(3).getMenge());
        stadtWareAIT4.setText("Anzahl: " + main.spiel.player.getInventar().get(4).getMenge());
        stadtWareAIT5.setText("Anzahl: " + main.spiel.player.getInventar().get(5).getMenge());

        //Statustext
        stadtWareStatusT1.setText("");
        stadtWareStatusT2.setText("");
        stadtWareStatusT3.setText("");
        stadtWareStatusT4.setText("");
        stadtWareStatusT5.setText("");
    }

    public void aktWareAnz() {
        stadtWareAIT1.setText("Anzahl: " + main.spiel.player.getInventar().get(1).getMenge());
        stadtWareAIT2.setText("Anzahl: " + main.spiel.player.getInventar().get(2).getMenge());
        stadtWareAIT3.setText("Anzahl: " + main.spiel.player.getInventar().get(3).getMenge());
        stadtWareAIT4.setText("Anzahl: " + main.spiel.player.getInventar().get(4).getMenge());
        stadtWareAIT5.setText("Anzahl: " + main.spiel.player.getInventar().get(5).getMenge());
    }

    public void back(){
        verkaufenStadtWare.setVisible(false);
        main.statusController.updateStatus();
        main.statusController.status.setVisible(true);
        if (bool == true){
            main.inputController.enableButtons();
        }
    }

    public void verkaufen(ActionEvent event){

        Object source = event.getSource();
        System.out.println(source);
        int kaufmenge = 0;
        boolean b;

        //Töpfe
        if (source == stadtWareButton1){
            //System.out.println("Im Button1");
            if (stadtWareTF1.getText().equals("")){ stadtWareTF1.setPromptText("Anzahl benötigt."); return;}
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
            b = main.spiel.player.verkaufen(1, Integer.parseInt(stadtWareTF1.getText()));
            count1 += kaufmenge;
            aktWareAnz();
            if (b){
                stadtWareStatusT1.setText("Du hast heute "+count1+" Töpfe verkauft.");
                main.tabController.setTabText();
            }else{
                stadtWareStatusT1.setText("Zu wenig Waren im Inventar.");
            }
        }

        //Geschirr
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
            b = main.spiel.player.verkaufen(2,kaufmenge);
            count2 += kaufmenge;
            aktWareAnz();
            if (b){
                stadtWareStatusT2.setText("Du hast heute "+count2+" Geschirr verkauft.");
                main.tabController.setTabText();
            }else{
                stadtWareStatusT2.setText("Zu wenig Waren im Inventar.");
            }
        }

        //Hacke
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
            b = main.spiel.player.verkaufen(3,kaufmenge);
            count3 += kaufmenge;
            aktWareAnz();
            if (b){
                stadtWareStatusT3.setText("Du hast heute "+count3+" Hacke(n) verkauft");
                main.tabController.setTabText();
            }else{
                stadtWareStatusT3.setText("Zu wenig Waren im Inventar.");
            }
        }

        //Hammer
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
            b = main.spiel.player.verkaufen(4,kaufmenge);
            count4 += kaufmenge;
            aktWareAnz();
            if (b){
                stadtWareStatusT4.setText("Du hast heute "+count4+" Hammer verkauft");
                main.tabController.setTabText();
            }else{
                stadtWareStatusT4.setText("Zu wenig Waren im Inventar.");
            }
        }

        //Säge
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
            b = main.spiel.player.verkaufen(5,kaufmenge);
            count5 += kaufmenge;
            aktWareAnz();
            if (b){
                stadtWareStatusT5.setText("Du hast heute "+count5+" Säge(n) verkauft.");
                main.tabController.setTabText();
            }else{
                stadtWareStatusT5.setText("Zu wenig Waren im Inventar.");
            }
        }

    }
}


