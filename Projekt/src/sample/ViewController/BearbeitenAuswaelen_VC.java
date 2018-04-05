package sample.ViewController;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import sample.Functions.Seitenwechsel;
import sample.Interfaces.VC_Standard;

public class BearbeitenAuswaelen_VC implements VC_Standard {

    @FXML
    AnchorPane mainAnchor;

    @FXML
    ImageView backgroundImage;

    @FXML
    Button btnAnzeigen, btnErstellen, btnBearbeiten, btnAbbrechen, btnLoeschen;

    @FXML
    ComboBox CBKarteien;

    @FXML
    Label LbSelect;

    @FXML
    TableView TVFrageAntwort;

    @FXML
    TableColumn TCFrage, TCAntwort;


    @FXML
    private void btnAnzeigenOA(javafx.event.ActionEvent event){

    }

    @FXML
    private void btnErstellenOA(javafx.event.ActionEvent event){
        Seitenwechsel sceneload = new Seitenwechsel();
        sceneload.wechsel("Erstellen", btnAnzeigen, mainAnchor.getHeight(),  mainAnchor.getWidth());
    }

    @FXML
    private void btnBearbeitenOA(javafx.event.ActionEvent event){
        Seitenwechsel sceneload = new Seitenwechsel();
        sceneload.wechsel("BearbeitenBearbeiten", btnAnzeigen, mainAnchor.getHeight(),  mainAnchor.getWidth());
    }

    @FXML
    private void btnAbbrechenOA(javafx.event.ActionEvent event){
        Seitenwechsel sceneload = new Seitenwechsel();
        sceneload.wechsel("Menu", btnAnzeigen, mainAnchor.getHeight(),  mainAnchor.getWidth());
    }

    @FXML
    private void btnLoeschenOA(javafx.event.ActionEvent event){

    }



    @Override
    public void initialize() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.mainAnchor.widthProperty().addListener(((observable, oldValue, newValue) -> {
            this.backgroundImage.setFitWidth((Double) newValue);
            this.btnAnzeigen.setPrefWidth((Double) newValue * 0.093);
            this.btnErstellen.setPrefWidth((Double) newValue * 0.093);
            this.btnBearbeiten.setPrefWidth((Double) newValue * 0.093);
            this.btnAbbrechen.setPrefWidth((Double) newValue * 0.093);
            this.btnLoeschen.setPrefWidth((Double) newValue * 0.093);
            this.CBKarteien.setPrefWidth((Double) newValue * 0.15);
            this.TCFrage.setPrefWidth((Double) newValue * 0.165);
            this.TCAntwort.setPrefWidth((Double) newValue * 0.165);
            System.out.println("width: " + newValue);
        }));
        this.mainAnchor.heightProperty().addListener(((observable, oldValue, newValue) -> {
            this.backgroundImage.setFitHeight((Double) newValue - 32);
            this.btnAnzeigen.setPrefHeight((Double) newValue * 0.0516);
            this.btnAnzeigen.setFont(Font.font ("System", (Double) newValue * 0.025));
            this.btnErstellen.setPrefHeight((Double) newValue * 0.0516);
            this.btnErstellen.setFont(Font.font ("System", (Double) newValue * 0.025));
            this.btnBearbeiten.setPrefHeight((Double) newValue * 0.0516);
            this.btnBearbeiten.setFont(Font.font ("System", (Double) newValue * 0.025));
            this.btnAbbrechen.setPrefHeight((Double) newValue * 0.0516);
            this.btnAbbrechen.setFont(Font.font ("System", (Double) newValue * 0.025));
            this.btnLoeschen.setPrefHeight((Double) newValue * 0.0516);
            this.btnLoeschen.setFont(Font.font ("System", (Double) newValue * 0.025));
            this.CBKarteien.setPrefHeight((Double) newValue * 0.0516);
            this.LbSelect.setFont(Font.font ("System", (Double) newValue * 0.025));
            System.out.println("height: " + newValue);
        }));
    }
}
