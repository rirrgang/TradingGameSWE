package controller;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.util.concurrent.TimeUnit;

public class tagBeendenController {

    @FXML mainController main;
    @FXML AnchorPane tagBeenden;
    @FXML Text text1;

    public void init(mainController mainController){ main = mainController; }

    public void initNextDay() {

        main.kaufenStadtController.bool=true;
        main.kaufenDorfController.bool=true;
        main.verkaufenStadtWareController.bool=true;
        main.verkaufenDorfWareController.bool=true;
        main.spiel.tagWechseln();
        main.tabController.setTabText();
        main.spiel.player.interesseAkt();
        main.verkaufenStadtWareController.resetCounter();
        main.verkaufenDorfWareController.resetCounter();
        main.kaufenStadtController.resetCounter();
        main.kaufenDorfController.resetCounter();
        main.inputController.disableButtons("all");

        if (main.spiel.endeAbfragen()){main.ende("P");}else{

        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        main.tagBeendenController.tagBeenden.setVisible(false);
                        main.statusController.status.setVisible(true);
                        main.inputController.enableButtons();
                    }
                },
                1250
            );

        }



    }
}
