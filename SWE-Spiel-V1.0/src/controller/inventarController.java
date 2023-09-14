package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class inventarController {

    @FXML mainController main;
    @FXML AnchorPane inventar;
    @FXML Text dorfWareGT1;
    @FXML Text dorfWareGT2;
    @FXML Text dorfWareGT3;
    @FXML Text dorfWareGT4;
    @FXML Text stadtWareGT1;
    @FXML Text stadtWareGT2;
    @FXML Text stadtWareGT3;
    @FXML Text stadtWareGT4;
    @FXML Text stadtWareGT5;
    @FXML Text stadtWareGT6;
    @FXML TextField dorfWareTF1;
    @FXML TextField dorfWareTF2;
    @FXML TextField dorfWareTF3;
    @FXML TextField dorfWareTF4;
    @FXML TextField stadtWareTF1;
    @FXML TextField stadtWareTF2;
    @FXML TextField stadtWareTF3;
    @FXML TextField stadtWareTF4;
    @FXML TextField stadtWareTF5;
    @FXML TextField stadtWareTF6;

    public void init(mainController mainController){
        main=mainController;
    }

    public void back(){
        inventar.setVisible(false);
        main.statusController.updateStatus();
        main.statusController.status.setVisible(true);

    }

    public void updateInventar(){
        //Gewicht-Anzeige der Dorf-Waren
        dorfWareGT1.setText("Gewicht: "+Double.toString(main.spiel.angeboteDorf.get(0).getGewicht()*main.spiel.player.getInventar().get(6).getMenge())+" kg");
        dorfWareGT2.setText("Gewicht: "+Double.toString(main.spiel.angeboteDorf.get(1).getGewicht()*main.spiel.player.getInventar().get(7).getMenge())+" kg");
        dorfWareGT3.setText("Gewicht: "+Double.toString(main.spiel.angeboteDorf.get(2).getGewicht()*main.spiel.player.getInventar().get(8).getMenge())+" kg");
        dorfWareGT4.setText("Gewicht: "+Double.toString(main.spiel.angeboteDorf.get(3).getGewicht()*main.spiel.player.getInventar().get(9).getMenge())+" kg");
        //Anzahl der einzelnen Items (Dorf-Ware)
        dorfWareTF1.setText(Integer.toString(main.spiel.player.getInventar().get(6).getMenge()));
        dorfWareTF2.setText(Integer.toString(main.spiel.player.getInventar().get(7).getMenge()));
        dorfWareTF3.setText(Integer.toString(main.spiel.player.getInventar().get(8).getMenge()));
        dorfWareTF4.setText(Integer.toString(main.spiel.player.getInventar().get(9).getMenge()));

        //Gewicht-Anzeige der Stadt-Waren

        stadtWareGT1.setText("Gewicht: "+ main.spiel.angeboteStadt.get(0).getGewicht() * main.spiel.player.getInventar().get(0).getMenge()+" kg");
        stadtWareGT2.setText("Gewicht: "+ main.spiel.angeboteStadt.get(1).getGewicht()*main.spiel.player.getInventar().get(1).getMenge()+" kg");
        stadtWareGT3.setText("Gewicht: "+ main.spiel.angeboteStadt.get(2).getGewicht()*main.spiel.player.getInventar().get(2).getMenge()+" kg");
        stadtWareGT4.setText("Gewicht: "+ main.spiel.angeboteStadt.get(3).getGewicht()*main.spiel.player.getInventar().get(3).getMenge()+" kg");
        stadtWareGT5.setText("Gewicht: "+ main.spiel.angeboteStadt.get(4).getGewicht()*main.spiel.player.getInventar().get(4).getMenge()+" kg");
        stadtWareGT6.setText("Gewicht: "+ main.spiel.angeboteStadt.get(5).getGewicht()*main.spiel.player.getInventar().get(5).getMenge()+" kg");

        //Anzahl der einzelnen Items (Stadt-Ware)
        stadtWareTF1.setText(Integer.toString(main.spiel.player.getInventar().get(0).getMenge()));
        stadtWareTF2.setText(Integer.toString(main.spiel.player.getInventar().get(1).getMenge()));
        stadtWareTF3.setText(Integer.toString(main.spiel.player.getInventar().get(2).getMenge()));
        stadtWareTF4.setText(Integer.toString(main.spiel.player.getInventar().get(3).getMenge()));
        stadtWareTF5.setText(Integer.toString(main.spiel.player.getInventar().get(4).getMenge()));
        stadtWareTF6.setText(Integer.toString(main.spiel.player.getInventar().get(5).getMenge()));
    }
}
