package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class taetigkeitenController {

    @FXML public mainController main;
    @FXML public AnchorPane taetigkeiten;
    @FXML public Text taetigkeitText;
    @FXML public Text taetigkeitText2;
    @FXML public Text taetigkeitText3;
    @FXML public Text taetigkeitText4;
    @FXML public Button acceptButton;
    @FXML public Button backButton;


    boolean bool = true;

    public void init(mainController mainController) {
        main = mainController;
    }

    public void checkTaetigkeit(){

        taetigkeitText.setVisible(true);
        taetigkeitText2.setVisible(true);
        taetigkeitText3.setVisible(true);
        acceptButton.setVisible(true);
        main.inputController.disableButtons("taetigkeit");

        if (main.spiel.player.getStandort().getTaetigkeit().isVerfügbar()==true) {
            System.out.println(main.spiel.player.getStandort());
            taetigkeitText.setText("In diesem Ort kannst du die Tätigkeit '" +
                    main.spiel.player.getStandort().getTaetigkeit().getName() +
                    "' annehmen.");
            taetigkeitText2.setText("Du bekommst für diese Tätigkeit: " +
                    main.spiel.player.getStandort().getTaetigkeit().getLohn() +
                    " Gold") ;
            taetigkeitText3.setText("Möchtest du diese Tätigkeit annehmen?");

            acceptButton.setVisible(true);
        }else{
            acceptButton.setVisible(false);
            taetigkeitText.setText("In diesem Ort gibt es momentan keine Arbeit.");
            taetigkeitText2.setText("Komm morgen wieder und versuche es erneut.");
            taetigkeitText3.setVisible(false);
            taetigkeitText4.setVisible(false);
        }
    }

    public void arbeiten(){
        bool = false;
        main.spiel.arbeiten();
        main.updateTab();
        taetigkeitText.setVisible(false);
        taetigkeitText2.setVisible(false);
        taetigkeitText3.setVisible(false);
        taetigkeitText4.setVisible(true);
        acceptButton.setVisible(false);
        taetigkeitText4.setText("Du hast "+main.spiel.player.getStandort().getTaetigkeit().getLohn()+" Gold erhalten.");
    }

    public void back(){
        if (bool == true){main.inputController.enableButtons();}
        taetigkeiten.setVisible(false);
        main.statusController.updateStatus();
        main.statusController.status.setVisible(true);

    }

}
