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

import java.io.File;
import java.sql.SQLException;
import java.util.List;

public class BearbeitenBearbeiten_VC extends IDHelper implements VC_Standard {

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

    private ObservableList<Karten> data = FXCollections.observableArrayList();

    @FXML
    private void btnFertigOA(javafx.event.ActionEvent event){
        Seitenwechsel sceneload = new Seitenwechsel();
        sceneload.wechsel("BearbeitenAuswaelen",btnFertig, mainAnchor.getHeight(),  mainAnchor.getWidth());
    }

    @FXML
    private void btnHinzufuegenOA(javafx.event.ActionEvent event) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
       DBManager DBHelper = new DBManager();
       DBHelper.Insert2("insert into karten (frage, antwort, karteienfk) values (?, ?, ?)", TFFrage.getText(), TFAntwort.getText(), getKarteienID());
        String frage = TFFrage.getText();
        String antwort = TFAntwort.getText();
        data.add(new Karten(frage, antwort));

        anzeige();

        TFAntwort.setText("");
        TFFrage.setText("");
    }

    public void anzeige(){
        TCFrage.setCellValueFactory(
                new PropertyValueFactory<Karten,String>("tclfrage")
        );
        TCAntwort.setCellValueFactory(
                new PropertyValueFactory<Karten,String>("tclantwort")
        );
        TVFrageAntwort.setItems(data);
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
        try {
            DBManager DBHelper = new DBManager();

            List<String> listfrage = DBHelper.Select02("select * from karten where KarteienFK =" + getKarteienID() +";", "Frage");
            List<String> listantwort = DBHelper.Select02("select * from karten where KarteienFK =" + getKarteienID() +";", "Antwort");
            for (int i = 0 ; listantwort.size() > i; i++) {
                String frage = listfrage.get(i);
                String antwort = listantwort.get(i);
                data.add(new Karten(frage,antwort));
            }
            anzeige();
        } catch (SQLException e) {
            e.printStackTrace();
        }




    }
}
