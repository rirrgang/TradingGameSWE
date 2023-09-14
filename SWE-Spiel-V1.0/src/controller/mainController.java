package controller;

import code.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class mainController{

    public Spieler player;
    public Spiel spiel = new Spiel();
    public int i = 42;



    @FXML public inputController inputController;
    @FXML public tabController tabController;
    @FXML public kaufenStadtController kaufenStadtController;
    @FXML public verkaufenStadtWareController verkaufenStadtWareController;
    @FXML public checkNameController checkNameController;
    @FXML public reisenController reisenController;
    @FXML public taetigkeitenController taetigkeitenController;
    @FXML public essenController essenController;
    @FXML public tagBeendenController tagBeendenController;
    @FXML public statusController statusController;
    @FXML public inventarController inventarController;
    @FXML public kaufenDorfController kaufenDorfController;
    @FXML public verkaufenDorfWareController verkaufenDorfWareController;

    @FXML AnchorPane content;

    public void initialize(){

        inputController.init(this);
        tabController.init(this);
        kaufenStadtController.init(this);
        verkaufenStadtWareController.init(this);
        checkNameController.init(this);
        reisenController.init(this);
        taetigkeitenController.init(this);
        essenController.init(this);
        tagBeendenController.init(this);
        statusController.init(this);
        inventarController.init(this);
        kaufenDorfController.init(this);
        verkaufenStadtWareController.init(this);
        verkaufenDorfWareController.init(this);

        setContentInVisible();
        inputController.disableButtons("all");
        checkNameController.checkName.setVisible(true);

    }

    public void ende(String text){
        if(text.equals("P")){
            if (spiel.endeAbfragen()){
               setContentInVisible();
               inputController.disableButtons("all");
               statusController.status.setVisible(true);
               statusController.statusText1.setText("Game Over!");
               statusController.neuStart.setVisible(true);
               statusController.statusText2.setText("Herzlichen Glückwunsch "+checkNameController.playerName +
                        " : Du hast "+ Integer.toString(spiel.player.getGold() - 100) +
                        " Gold erwirtschaftet.");
            }
        }else if (text.equals("B")){
            setContentInVisible();
            inputController.disableButtons("all");
            statusController.status.setVisible(true);
            statusController.statusText1.setText("Game Over!");
            statusController.neuStart.setVisible(true);
            statusController.statusText2.setText("Herzlichen Glückwunsch "+checkNameController.playerName +
                    " : Du hast "+ Integer.toString(spiel.player.getGold() - 100) +
                    " Gold erwirtschaftet.");
        }
    }

    public void updateTab(){
        tabController.setTabText();
    }

    public void setContentInVisible() {
        boolean b = false;
        kaufenStadtController.kaufenStadt.setVisible(b);
        checkNameController.checkName.setVisible(b);
        reisenController.reisen.setVisible(b);
        taetigkeitenController.taetigkeiten.setVisible(b);
        essenController.essen.setVisible(b);
        verkaufenStadtWareController.verkaufenStadtWare.setVisible(b);
        verkaufenDorfWareController.verkaufenDorfWare.setVisible(b);
        tagBeendenController.tagBeenden.setVisible(b);
        statusController.status.setVisible(b);
        inventarController.inventar.setVisible(b);
        kaufenDorfController.kaufenDorf.setVisible(b);
    }
}
