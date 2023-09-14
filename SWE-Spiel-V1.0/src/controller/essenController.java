package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class essenController {

    @FXML mainController main;
    @FXML AnchorPane essen;
    @FXML Button essenButton;
    @FXML Button essenInvButton;
    @FXML Button essenGoButton;
    @FXML Text essenNameText;
    @FXML Text essenMengeText;
    @FXML TextField essenTextField;
    @FXML HBox selectHBox;

    public int type;
    public int anzahl;

    public void init(mainController mainController){
        main = mainController;
    }

    public void back(){
        essen.setVisible(false);
        main.statusController.updateStatus();
        main.statusController.status.setVisible(true);
    }

    public void setSelectText(){
        selectHBox.setVisible(false);
    }

    public void selectFood(ActionEvent event){

        Object source = event.getSource();

        if (source == essenInvButton){
            selectHBox.setVisible(true);
            essenNameText.setText(main.spiel.player.getInventar().get(0).getName());
            essenMengeText.setText("Menge: "+main.spiel.player.getInventar().get(0).getMenge());
            type = 0;

        }else if(source == essenGoButton){
            selectHBox.setVisible(true);
            essenNameText.setText(main.spiel.player.getStandort().getEssen().getName());
            essenMengeText.setText("Preis: "+main.spiel.player.getStandort().getEssen().getPreis());
            type = 1;
        }
    }

    public void essen(){
        //Aus dem Inventar Essen
        if (type == 0){
            if (essenTextField.getText().equals("")){
                essenTextField.setPromptText("Bitte einen Wert eingeben.");
            }else{

                if (main.spiel.player.getInventar().get(0).getMenge() == 0){
                    essenTextField.setText("");
                    essenTextField.setPromptText("Kein Essen mehr im Inventar.");
                }else{

                anzahl = Integer.parseInt(essenTextField.getText());
                main.spiel.player.essenInventar(anzahl);
                main.tabController.setTabText();
                essenMengeText.setText("Menge: "+main.spiel.player.getInventar().get(0).getMenge());
                }
            }
        //Lokal Essen
        }else{
            if (essenTextField.getText().equals("")){
                essenTextField.setPromptText("Bitte einen Wert eingeben.");
            }else{
                anzahl = Integer.parseInt(essenTextField.getText());
                main.spiel.player.essenLokal(anzahl);
                main.tabController.setTabText();
            }
        }if(main.spiel.endeAbfragen()){main.ende("P");}
    }
}
