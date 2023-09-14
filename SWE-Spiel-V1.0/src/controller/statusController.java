package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class statusController {

    @FXML mainController main;
    @FXML AnchorPane status;
    @FXML Text statusText1;
    @FXML Text statusText2;
    @FXML ImageView image;
    @FXML Button neuStart;

    public void init(mainController mainController) {
        main=mainController;
    }

    public void neuStart(){
        main.spiel.tageszaehler = 0;
        main.spiel.player.gold = 100;
        main.spiel.player.tragelast = 0;
        main.spiel.player.leben = 100;
        main.spiel.player.setStandort(main.spiel.orte.get(0));
        main.spiel.player.setInventar(main.spiel.invent);
        main.inventarController.updateInventar();
        main.setContentInVisible();
        main.checkNameController.checkName.setVisible(true);
        main.checkNameController.startButton.setVisible(false);
        updateStatus();
        neuStart.setVisible(false);
        main.updateTab();
    }

    public void updateStatus(){
        if (main.spiel.player.getStandort().getTyp() == 'S') {
            statusText1.setText("Du befindest dich momentan in " + main.spiel.player.getStandort().getName() + " (Stadt).");
            statusText2.setText("Was möchtest du tun?");
            Image i = new Image("/pictures/background7.jpg");
            image.setImage(i);
        }else{
            statusText1.setText("Du befindest dich momentan in " + main.spiel.player.getStandort().getName() + " (Dorf).");
            statusText2.setText("Was möchtest du tun?");
            Image i = new Image("/pictures/background6.jpg");
            image.setImage(i);
        }
    }
}
