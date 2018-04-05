package sample.ViewController;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import sample.Functions.Seitenwechsel;
import sample.Interfaces.VC_Standard;

public class Erstellen_VC implements VC_Standard {

    @FXML
    AnchorPane mainAnchor;

    @FXML
    ImageView backgroundImage, IVKartei;

    @FXML
    Button btnAbbrechen, btnWeiter;

    @FXML
    TextField TFKarteiname;

    @FXML
    Label LbKarteiname;

    @FXML
    private void btnAbbrechenOA(javafx.event.ActionEvent event){
        Seitenwechsel sceneload = new Seitenwechsel();
        sceneload.wechsel("BearbeitenAuswaelen",btnAbbrechen, mainAnchor.getHeight(),  mainAnchor.getWidth());
    }

    @FXML
    private void btnWeiterOA(javafx.event.ActionEvent event) {
        Seitenwechsel sceneload = new Seitenwechsel();
        sceneload.wechsel("BearbeitenBearbeiten",btnAbbrechen, mainAnchor.getHeight(),  mainAnchor.getWidth());
    }




    @Override
    public void initialize() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.mainAnchor.widthProperty().addListener(((observable, oldValue, newValue) -> {
            this.backgroundImage.setFitWidth((Double) newValue);
            this.IVKartei.setFitWidth((Double) newValue * 0.147);
            this.btnAbbrechen.setPrefWidth((Double) newValue * 0.093);
            this.btnWeiter.setPrefWidth((Double) newValue * 0.093);
            this.TFKarteiname.setPrefWidth((Double) newValue * 0.175);
            System.out.println("width: " + newValue);
        }));
        this.mainAnchor.heightProperty().addListener(((observable, oldValue, newValue) -> {
            this.backgroundImage.setFitHeight((Double) newValue - 32);
            this.IVKartei.setFitHeight((Double) newValue * 0.142);
            this.btnAbbrechen.setPrefHeight((Double) newValue * 0.0516);
            this.btnAbbrechen.setFont(Font.font ("System", (Double) newValue * 0.025));
            this.btnWeiter.setPrefHeight((Double) newValue * 0.0516);
            this.btnWeiter.setFont(Font.font ("System", (Double) newValue * 0.025));
            this.LbKarteiname.setFont(Font.font ("System", (Double) newValue * 0.025));
            this.TFKarteiname.setPrefHeight((Double) newValue * 0.0516);
            System.out.println("height: " + newValue);
        }));
    }
}
