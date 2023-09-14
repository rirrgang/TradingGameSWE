package controller;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class tabController {

    @FXML mainController main;
    @FXML Text currentPositionText;
    @FXML Text currentDayText;
    @FXML Text currentLifeText;
    @FXML Text currentWeightText;
    @FXML Text currentGoldText;
    @FXML ImageView image;


    public void init(mainController mainController) {
        this.main = mainController;
    }

    public void setTabText(){
        setCurrentDayText();
        setCurrentGoldText();
        setCurrentLifeText();
        setCurrentPositionText();
        setCurrentWeightText();
    }

    public void highlight(){
        Image i = new Image("/pictures/close2.png");
        image.setImage(i);
    }

    public void lowlight(){
        Image i = new Image("/pictures/close.png");
        image.setImage(i);
    }

    public void setCurrentPositionText(){ currentPositionText.setText("Du befindest dich momentan in: "+main.spiel.player.getStandort().getName()); }
    public void setCurrentDayText(){ currentDayText.setText("Tag: "+main.spiel.tageszaehler+"/100"); }
    public void setCurrentLifeText(){ currentLifeText.setText("Leben: "+main.spiel.player.getLeben()+"/100"); }
    public void setCurrentWeightText(){ currentWeightText.setText("Tragelast: "+main.spiel.player.tragelast+"/100"); }
    public void setCurrentGoldText(){ currentGoldText.setText("Gold: "+main.spiel.player.getGold()); }

    public Text getCurrentPositionText() { return currentPositionText; }
    public Text getCurrentDayText() { return currentDayText; }
    public Text getCurrentLifeText() { return currentLifeText; }
    public Text getCurrentWeightText() { return currentWeightText; }
    public Text getCurrentGoldText() { return currentGoldText; }

    public void exit(){
        System.exit(0);
    }
}
