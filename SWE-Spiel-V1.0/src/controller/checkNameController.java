package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class checkNameController {

    public String playerName = "";

    @FXML mainController main;

    @FXML AnchorPane checkName;
    @FXML TextField nameTextField;
    @FXML Button startButton;

    public void setPlayerName(){
        if (nameTextField.getText().equals("") ){
            nameTextField.setPromptText("Hier den Namen eingeben.");
        }else{
            startButton.setVisible(true);
            playerName = nameTextField.getText();
            System.out.println("Spielername: "+playerName);
        }
    }

    public void startGame(){
        checkName.setVisible(false);
        System.out.println("Starte Spiel......");
        main.tabController.setTabText();
        main.statusController.updateStatus();
        main.statusController.status.setVisible(true);
        main.inputController.enableButtons();
    }

    public void init(mainController mainController){
        main = mainController;
    }

    public void clear(){
        nameTextField.setText("");
    }

}
