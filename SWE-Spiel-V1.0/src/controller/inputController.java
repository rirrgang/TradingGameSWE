package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class inputController {

    @FXML mainController main;

    @FXML Button reiseButton;
    @FXML Button taetigkeitButton;
    @FXML Button kaufenButton;
    @FXML Button verkaufenButton;
    @FXML Button inventarButton;
    @FXML Button essenButton;
    @FXML Button tagBeendenButton;
    @FXML Button spielBeendenButton;

    public void init(mainController mainController) {
        this.main = mainController;
    }

    public void enableButtons(){
        essenButton.setDisable(false);
        reiseButton.setDisable(false);
        taetigkeitButton.setDisable(false);
        kaufenButton.setDisable(false);
        verkaufenButton.setDisable(false);
        inventarButton.setDisable(false);
        essenButton.setDisable(false);
        tagBeendenButton.setDisable(false);
        spielBeendenButton.setDisable(false);
    }

    public void disableButtons(String text){

        if (text.equals("kaufen")){
            reiseButton.setDisable(true);
            taetigkeitButton.setDisable(true);
            verkaufenButton.setDisable(true);
        }else if(text.equals("verkaufen")){
            reiseButton.setDisable(true);
            taetigkeitButton.setDisable(true);
            kaufenButton.setDisable(true);
        }else if(text.equals("taetigkeit")){
            reiseButton.setDisable(true);
            taetigkeitButton.setDisable(true);
            verkaufenButton.setDisable(true);
            kaufenButton.setDisable(true);
        }else if(text.equals("all")){
            essenButton.setDisable(true);
            reiseButton.setDisable(true);
            taetigkeitButton.setDisable(true);
            kaufenButton.setDisable(true);
            verkaufenButton.setDisable(true);
            inventarButton.setDisable(true);
            essenButton.setDisable(true);
            tagBeendenButton.setDisable(true);
            spielBeendenButton.setDisable(true);
        }
    }

    public void showReisen(){
        main.setContentInVisible();
        main.reisenController.setText();
        main.reisenController.reisen.setVisible(true);
    }

    public void showKaufen(){
        main.setContentInVisible();
        disableButtons("kaufen");
        if (main.spiel.player.getStandort().getTyp() == 'S'){
            main.kaufenStadtController.showWarenDaten();
            main.kaufenStadtController.kaufenStadt.setVisible(true);
        }else if(main.spiel.player.getStandort().getTyp() == 'D'){
            main.kaufenDorfController.showWarenDaten();
            main.kaufenDorfController.kaufenDorf.setVisible(true);
        }

    }

    public void showVerkaufen(){
        main.setContentInVisible();
        disableButtons("verkaufen");
        if (main.spiel.player.getStandort().getTyp() == 'S'){
            main.verkaufenDorfWareController.showWarenDaten();
            main.verkaufenDorfWareController.verkaufenDorfWare.setVisible(true);
        }else if(main.spiel.player.getStandort().getTyp() == 'D'){
            main.verkaufenStadtWareController.showWarenDaten();
            main.verkaufenStadtWareController.verkaufenStadtWare.setVisible(true);
        }

    }
    public void showTaetigkeiten() throws IOException {
        main.setContentInVisible();
        main.taetigkeitenController.taetigkeiten.setVisible(true);
        main.taetigkeitenController.checkTaetigkeit();
    }

    public void showEssen(){
        main.setContentInVisible();
        main.essenController.essen.setVisible(true);
        main.essenController.setSelectText();
    }

    public void showTagBeenden() throws InterruptedException {
        main.setContentInVisible();
        main.tagBeendenController.tagBeenden.setVisible(true);
        main.tagBeendenController.initNextDay();
    }

    public void showInventar(){
        main.setContentInVisible();
        main.inventarController.updateInventar();
        main.inventarController.inventar.setVisible(true);

    }



    public void exit(){
        main.ende("B");
    }

}
