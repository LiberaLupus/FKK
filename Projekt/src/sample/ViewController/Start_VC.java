package sample.ViewController;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import sample.Functions.Seitenwechsel;
import sample.Interfaces.VC_Standard;

import javax.swing.*;

public class Start_VC implements VC_Standard{

    @FXML
    AnchorPane mainAnchor;

    @FXML
    ImageView backgroundImage;

    @FXML
    Button btnUeben, btnBearbeiten, btnBeenden;

    @FXML
    Label LbKKK;

    @FXML
    private void btnUebenOA(javafx.event.ActionEvent event){
        Seitenwechsel sceneload = new Seitenwechsel();
        sceneload.wechsel("UebenAuswahl", btnBearbeiten, mainAnchor.getHeight(),  mainAnchor.getWidth());
    }

    @FXML
    private void btnBearbeitenOA(javafx.event.ActionEvent event) {
        Seitenwechsel sceneload = new Seitenwechsel();
        sceneload.wechsel("BearbeitenAuswaelen", btnBearbeiten, mainAnchor.getHeight(),  mainAnchor.getWidth());
    }

    @FXML
    private void btnBeendenOA(javafx.event.ActionEvent event) {
        int eingabe = JOptionPane.showConfirmDialog(null,
                "Möchten Sie KKK beenden?",
                "",
                JOptionPane.YES_NO_OPTION);
        System.out.println(eingabe);
        if (eingabe == 0){
            System.exit(1);
        }else{
            System.out.println(eingabe);
        }
    }


    @Override
    public void initialize() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.mainAnchor.widthProperty().addListener(((observable, oldValue, newValue) -> {
            this.backgroundImage.setFitWidth((Double) newValue);
            this.btnUeben.setPrefWidth((Double) newValue * 0.153);
            this.btnBearbeiten.setPrefWidth((Double) newValue * 0.153);
            this.btnBeenden.setPrefWidth((Double) newValue * 0.153);
            System.out.println("width: " + newValue);
        }));
        this.mainAnchor.heightProperty().addListener(((observable, oldValue, newValue) -> {
            this.backgroundImage.setFitHeight((Double) newValue - 32);
            this.btnUeben.setPrefHeight((Double) newValue * 0.0775);
            this.btnUeben.setFont(Font.font ("System", (Double) newValue * 0.0375));
            this.btnBearbeiten.setPrefHeight((Double) newValue * 0.0775);
            this.btnBearbeiten.setFont(Font.font ("System", (Double) newValue * 0.0375));
            this.btnBeenden.setPrefHeight((Double) newValue * 0.0775);
            this.btnBeenden.setFont(Font.font ("System", (Double) newValue * 0.0375));
            this.LbKKK.setFont(Font.font ("System", (Double) newValue * 0.09));
            System.out.println("height: " + newValue);
        }));
    }
}
