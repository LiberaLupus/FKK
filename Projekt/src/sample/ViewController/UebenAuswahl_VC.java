package sample.ViewController;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import sample.AbstractClasses.IDHelper;
import sample.Functions.DBManager;
import sample.Functions.Seitenwechsel;
import sample.Interfaces.VC_Standard;

import java.sql.SQLException;
import java.util.List;

public class UebenAuswahl_VC extends IDHelper implements VC_Standard {

    @FXML
    AnchorPane mainAnchor;

    @FXML
    ImageView backgroundImage;

    @FXML
    Button btnZurueck, btnStart;

    @FXML
    ComboBox CBKartei;

    @FXML
    Label LbSelect;


    @FXML
    private void btnZurueckAO(javafx.event.ActionEvent event){
        Seitenwechsel sceneload = new Seitenwechsel();
        sceneload.wechsel("Menu", btnZurueck, mainAnchor.getHeight(),  mainAnchor.getWidth());
    }

    @FXML
    private void btnStartOA(javafx.event.ActionEvent event) {
        Seitenwechsel sceneload = new Seitenwechsel();
        sceneload.wechsel("Ueben", btnZurueck, mainAnchor.getHeight(),  mainAnchor.getWidth());
    }






    @Override
    public void initialize() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        this.mainAnchor.widthProperty().addListener(((observable, oldValue, newValue) -> {
            this.backgroundImage.setFitWidth((Double) newValue);
            this.btnZurueck.setPrefWidth((Double) newValue * 0.11);
            this.btnStart.setPrefWidth((Double) newValue * 0.11);
            this.CBKartei.setPrefWidth((Double) newValue * 0.25);
            System.out.println("width: " + newValue);
        }));
        this.mainAnchor.heightProperty().addListener(((observable, oldValue, newValue) -> {
            this.backgroundImage.setFitHeight((Double) newValue - 32);
            this.btnZurueck.setPrefHeight((Double) newValue * 0.0775);
            this.btnZurueck.setFont(Font.font ("System", (Double) newValue * 0.0375));
            this.btnStart.setPrefHeight((Double) newValue * 0.0775);
            this.btnStart.setFont(Font.font ("System", (Double) newValue * 0.0375));
            this.CBKartei.setPrefHeight((Double) newValue * 0.0775);
            this.LbSelect.setFont(Font.font ("System", (Double) newValue * 0.0375));
            System.out.println("height: " + newValue);
        }));

        btnStart.disableProperty().setValue(true);

        this.CBKartei.valueProperty().addListener(((observable, oldValue, newValue) -> {
            try {
                setKarteienID(String.valueOf(CBKartei.getValue()));
                btnStart.disableProperty().setValue(false);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }));

        CBKartei.setTooltip(new Tooltip("Wähle eine Kartei aus."));
        try {
            comboboxanzeige();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void comboboxanzeige() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        DBManager DBHelper = new DBManager();
        CBKartei.getItems().removeAll();
        List<String> kaname = DBHelper.Select02("select * from karteien","Name");
        for (String element : kaname) {
            CBKartei.getItems().add(element);
        }
    }
}
