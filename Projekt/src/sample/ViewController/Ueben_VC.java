package sample.ViewController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import sample.Functions.Seitenwechsel;
import sample.Interfaces.VC_Standard;

public class Ueben_VC implements VC_Standard {

    @FXML
    AnchorPane mainAnchor;

    @FXML
    ImageView backgroundImage, IVFrage, IVAntwort;

    @FXML
    Button btnAbbrechen, btnPruefen;

    @FXML
    Label LbFrage;

    @FXML
    TextField TFAntwort;

    @FXML
    private void btnAbbrechenOA(javafx.event.ActionEvent event){
        Seitenwechsel sceneload = new Seitenwechsel();
        sceneload.wechsel("UebenAuswahl", btnAbbrechen, mainAnchor.getHeight(),  mainAnchor.getWidth());
    }

    @FXML
    private void btnPruefenOA(javafx.event.ActionEvent event) {
        Seitenwechsel sceneload = new Seitenwechsel();
        sceneload.wechsel("UebenAuswahl", btnAbbrechen, mainAnchor.getHeight(),  mainAnchor.getWidth());
    }



    @Override
    public void initialize() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.mainAnchor.widthProperty().addListener(((observable, oldValue, newValue) -> {
            this.backgroundImage.setFitWidth((Double) newValue);
            this.IVFrage.setFitWidth((Double) newValue * 0.3);
            this.IVAntwort.setFitWidth((Double) newValue * 0.3);
            this.btnAbbrechen.setPrefWidth((Double) newValue * 0.155);
            this.btnPruefen.setPrefWidth((Double) newValue * 0.106);
            this.TFAntwort.setPrefWidth((Double) newValue * 0.2);
            System.out.println("width: " + newValue);
        }));
        this.mainAnchor.heightProperty().addListener(((observable, oldValue, newValue) -> {
            this.backgroundImage.setFitHeight((Double) newValue - 32);
            this.IVFrage.setFitHeight((Double) newValue * 0.375);
            this.IVAntwort.setFitHeight((Double) newValue * 0.375);
            this.btnAbbrechen.setPrefHeight((Double) newValue * 0.0775);
            this.btnAbbrechen.setFont(Font.font ("System", (Double) newValue * 0.0375));
            this.btnPruefen.setPrefHeight((Double) newValue * 0.0775);
            this.btnPruefen.setFont(Font.font ("System", (Double) newValue * 0.0375));
            this.TFAntwort.setPrefHeight((Double) newValue * 0.0775);
            this.LbFrage.setFont(Font.font ("System", (Double) newValue * 0.0375));
            System.out.println("height: " + newValue);
        }));
    }
}
