package sample.ViewController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import sample.AbstractClasses.IDHelper;
import sample.Functions.DBManager;
import sample.Functions.Karten;
import sample.Functions.Seitenwechsel;
import sample.Interfaces.VC_Standard;

import java.sql.SQLException;
import java.util.List;

public class BearbeitenAuswaelen_VC extends IDHelper implements VC_Standard {

    @FXML
    AnchorPane mainAnchor;

    @FXML
    ImageView backgroundImage;

    @FXML
    Button btnErstellen, btnBearbeiten, btnAbbrechen, btnLoeschen;

    @FXML
    ComboBox CBKarteien;

    @FXML
    Label LbSelect;

    @FXML
    TableView TVFrageAntwort;

    @FXML
    TableColumn TCFrage, TCAntwort;

    private ObservableList<Karten> data = FXCollections.observableArrayList();


    @FXML
    private void Anzeigen() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        setKarteienID(String.valueOf(CBKarteien.getValue()));
        ObservableList<Karten> data = FXCollections.observableArrayList();
        TVFrageAntwort.getItems().clear();
        TVFrageAntwort.getSelectionModel().clearSelection();
        DBManager DBHelper = new DBManager();
        List<String> listfrage = DBHelper.Select02("select * from karten where KarteienFK =" + getKarteienID() +";", "Frage");
        List<String> listantwort = DBHelper.Select02("select * from karten where KarteienFK =" + getKarteienID() +";", "Antwort");
        for (int i = 0 ; listantwort.size() > i; i++) {
            String frage = listfrage.get(i);
            String antwort = listantwort.get(i);
            data.add(new Karten(frage,antwort));
        }

        TCFrage.setCellValueFactory(
                new PropertyValueFactory<Karten,String>("tclfrage")
        );
        TCAntwort.setCellValueFactory(
                new PropertyValueFactory<Karten,String>("tclantwort")
        );
        TVFrageAntwort.setItems(data);
    }

    @FXML
    private void btnErstellenOA(javafx.event.ActionEvent event){
        Seitenwechsel sceneload = new Seitenwechsel();
        sceneload.wechsel("Erstellen", btnErstellen, mainAnchor.getHeight(),  mainAnchor.getWidth());
    }

    @FXML
    private void btnBearbeitenOA(javafx.event.ActionEvent event){
        Seitenwechsel sceneload = new Seitenwechsel();
        sceneload.wechsel("BearbeitenBearbeiten", btnErstellen, mainAnchor.getHeight(),  mainAnchor.getWidth());
    }

    @FXML
    private void btnAbbrechenOA(javafx.event.ActionEvent event){
        Seitenwechsel sceneload = new Seitenwechsel();
        sceneload.wechsel("Menu", btnErstellen, mainAnchor.getHeight(),  mainAnchor.getWidth());
    }

    @FXML
    private void btnLoeschenOA(javafx.event.ActionEvent event){
        try {
            DBManager DBHelper = new DBManager();
            DBHelper.Delete("delete from karteien where id = "+ getKarteienID() +";");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        Seitenwechsel sceneload = new Seitenwechsel();
        sceneload.wechsel("BearbeitenAuswaelen", btnErstellen, mainAnchor.getHeight(),  mainAnchor.getWidth());

    }



    @Override
    public void initialize() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.mainAnchor.widthProperty().addListener(((observable, oldValue, newValue) -> {
            this.backgroundImage.setFitWidth((Double) newValue);
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

        btnBearbeiten.disableProperty().setValue(true);
        btnLoeschen.disableProperty().setValue(true);

        this.CBKarteien.valueProperty().addListener(((observable, oldValue, newValue) -> {
            try {
                Anzeigen();
                btnBearbeiten.disableProperty().setValue(false);
                btnLoeschen.disableProperty().setValue(false);
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

        CBKarteien.setTooltip(new Tooltip("Wähle eine Kartei aus."));
        try {
            comboboxanzeige();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void comboboxanzeige() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        DBManager DBHelper = new DBManager();
        CBKarteien.getItems().removeAll();
        List<String> kaname = DBHelper.Select02("select * from karteien","Name");
        for (String element : kaname) {
            CBKarteien.getItems().add(element);
        }
    }
}
