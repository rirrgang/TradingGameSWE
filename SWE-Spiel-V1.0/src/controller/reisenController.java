package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class reisenController {

    @FXML mainController main;
    @FXML AnchorPane reisen;
    @FXML Text ortNameT1;
    @FXML Text ortNameT2;
    @FXML Text ortNameT3;
    @FXML Text ortNameT4;
    @FXML Text ortNameT5;
    @FXML TextField ortEntfT1;
    @FXML TextField ortEntfT2;
    @FXML TextField ortEntfT3;
    @FXML TextField ortEntfT4;
    @FXML TextField ortEntfT5;
    @FXML Button reiseButton1;
    @FXML Button reiseButton2;
    @FXML Button reiseButton3;
    @FXML Button reiseButton4;
    @FXML Button reiseButton5;
    @FXML Button backButton;

    public void init(mainController mainController) {
        main = mainController;
    }

    public void back(){
        reisen.setVisible(false);
        main.statusController.updateStatus();
        main.statusController.status.setVisible(true);
    }

    public void setText(){
        //Orts-Namen
        ortNameT1.setText(main.spiel.orte.get(0).getName());
        ortNameT2.setText(main.spiel.orte.get(1).getName());
        ortNameT3.setText(main.spiel.orte.get(2).getName());
        ortNameT4.setText(main.spiel.orte.get(3).getName());
        ortNameT5.setText(main.spiel.orte.get(4).getName());

        //Entfernungs-Texte
        ortEntfT1.setText(Math.round(main.spiel.getReisedauer(main.spiel.player,main.spiel.orte.get(0))) + " Tag(e)");
        ortEntfT2.setText(Math.round(main.spiel.getReisedauer(main.spiel.player,main.spiel.orte.get(1))) + " Tag(e)");
        ortEntfT3.setText(Math.round(main.spiel.getReisedauer(main.spiel.player,main.spiel.orte.get(2))) + " Tag(e)");
        ortEntfT4.setText(Math.round(main.spiel.getReisedauer(main.spiel.player,main.spiel.orte.get(3))) + " Tag(e)");
        ortEntfT5.setText(Math.round(main.spiel.getReisedauer(main.spiel.player,main.spiel.orte.get(4))) + " Tag(e)");

        reiseButton1.setDisable(false);
        reiseButton2.setDisable(false);
        reiseButton3.setDisable(false);
        reiseButton4.setDisable(false);
        reiseButton5.setDisable(false);

        buttonClickable();

    }

    public void buttonClickable(){
        if(main.spiel.player.getStandort().getName() == main.spiel.orte.get(0).getName()){
            reiseButton1.setDisable(true);
        }else if(main.spiel.player.getStandort().getName() == main.spiel.orte.get(1).getName()) {
            reiseButton2.setDisable(true);
        }else if(main.spiel.player.getStandort().getName() == main.spiel.orte.get(2).getName()) {
            reiseButton3.setDisable(true);
        }else if(main.spiel.player.getStandort().getName() == main.spiel.orte.get(3).getName()) {
            reiseButton4.setDisable(true);
        }else if(main.spiel.player.getStandort().getName() == main.spiel.orte.get(4).getName()) {
            reiseButton5.setDisable(true);
        }
    }

    public void reisen(ActionEvent event){
        Object source = event.getSource();
        int x=0;

        if (source == reiseButton1){
            x = 0;
        }else if(source == reiseButton2){
            x = 1;
        }else if(source == reiseButton3){
            x = 2;
        }else if(source == reiseButton4){
            x = 3;
        }else if(source == reiseButton5){
            x = 4;
        }

        main.spiel.reiseNach(x);
        main.tabController.setTabText();
        setText();

        if(main.spiel.endeAbfragen()){main.ende("P");}
        else{reisen.setVisible(false);
            main.statusController.updateStatus();
            main.spiel.player.interesseAkt();
            main.statusController.status.setVisible(true);}



    }


}
