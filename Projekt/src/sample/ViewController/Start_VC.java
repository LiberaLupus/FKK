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
import javafx.stage.Window;
import sample.AbstractClasses.Test;
import sample.Functions.DBManager;

import java.sql.SQLException;

public class Start_VC extends Test{

    @FXML
    AnchorPane mainAnchor;

    @FXML
    ImageView backgroundImage;

    @FXML
    Button btnUeben, btnBearbeiten, btnBeenden;

    @FXML
    Label LbKKK;

    @FXML
    public void initialize() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {
            DBManager DB = new DBManager();
            DB.Select("select Name from karteien;");

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
                this.btnBeenden.setPrefHeight((Double) newValue * 0.0775);
                this.LbKKK.setFont(Font.font ("System", (Double) newValue * 0.09));
                System.out.println("height: " + newValue);
            }));


        } catch (SQLException e) {
            e.printStackTrace();
        }
            sagen();
    }
}
