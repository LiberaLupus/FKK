package sample.ViewController;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import sample.Functions.Seitenwechsel;
import sample.Interfaces.VC_Standard;

public class BearbeitenBearbeiten_VC implements VC_Standard {

    @FXML
    AnchorPane mainAnchor;

    @FXML
    ImageView backgroundImage;

    @FXML
    Button btnFertig, btnHinzufuegen;

    @FXML
    TextField TFFrage, TFAntwort;

    @FXML
    Label LbFrage, LbAntwort;

    @FXML
    TableView TVFrageAntwort;

    @FXML
    TableColumn TCFrage, TCAntwort;

    @FXML
    private void btnFertigOA(javafx.event.ActionEvent event){
        Seitenwechsel sceneload = new Seitenwechsel();
        sceneload.wechsel("BearbeitenAuswaelen",btnFertig, mainAnchor.getHeight(),  mainAnchor.getWidth());
    }

    @FXML
    private void btnHinzufuegenOA(javafx.event.ActionEvent event) {

    }

    @Override
    public void initialize() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.mainAnchor.widthProperty().addListener(((observable, oldValue, newValue) -> {
            this.backgroundImage.setFitWidth((Double) newValue);
            this.btnFertig.setPrefWidth((Double) newValue * 0.093);
            this.btnHinzufuegen.setPrefWidth((Double) newValue * 0.093);
            this.TCFrage.setPrefWidth((Double) newValue * 0.165);
            this.TCAntwort.setPrefWidth((Double) newValue * 0.165);
            this.TVFrageAntwort.setPrefWidth(((Double) newValue * 0.165)*2);
            this.TFFrage.setPrefWidth((Double) newValue * 0.175);
            this.TFAntwort.setPrefWidth((Double) newValue * 0.175);
            System.out.println("width: " + newValue);
        }));
        this.mainAnchor.heightProperty().addListener(((observable, oldValue, newValue) -> {
            this.backgroundImage.setFitHeight((Double) newValue - 32);
            this.btnFertig.setPrefHeight((Double) newValue * 0.0516);
            this.btnFertig.setFont(Font.font ("System", (Double) newValue * 0.025));
            this.btnHinzufuegen.setPrefHeight((Double) newValue * 0.0516);
            this.btnHinzufuegen.setFont(Font.font ("System", (Double) newValue * 0.025));
            this.LbFrage.setFont(Font.font ("System", (Double) newValue * 0.025));
            this.LbAntwort.setFont(Font.font ("System", (Double) newValue * 0.025));
            this.TFFrage.setPrefHeight((Double) newValue * 0.0516);
            this.TFAntwort.setPrefHeight((Double) newValue * 0.0516);
            System.out.println("height: " + newValue);
        }));

    }
}
