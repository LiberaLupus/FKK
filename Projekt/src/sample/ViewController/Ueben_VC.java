package sample.ViewController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import sample.AbstractClasses.IDHelper;
import sample.Functions.DBManager;
import sample.Functions.MessageBox;
import sample.Functions.Seitenwechsel;
import sample.Interfaces.Ueben;
import sample.Interfaces.VC_Standard;

import java.sql.SQLException;
import java.util.List;

public class Ueben_VC extends IDHelper implements VC_Standard, Ueben {

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

    Integer i = 0;

    Integer Falsch = 0;
    Integer Richtig = 0;

    private String frage;
    private String antwort;


    @FXML
    private void btnAbbrechenOA(javafx.event.ActionEvent event){
        Seitenwechsel sceneload = new Seitenwechsel();
        sceneload.wechsel("UebenAuswahl", btnAbbrechen, mainAnchor.getHeight(),  mainAnchor.getWidth());
    }

    @FXML
    private void btnPruefenOA(javafx.event.ActionEvent event) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        DBManager DBHelper = new DBManager();
        int karteifk = getKarteienID();
        if (TFAntwort.getText().equals(antwort)){
            MessageBox MesBox = new MessageBox();
            MesBox.MessageBoxOK("Richtig");
            DBHelper.databaseupdaterichtigfalsch("update karten set richtig = (?) where frage ='" + frage + "' and karteienfk =" + karteifk, Boolean.TRUE);
            ++Richtig;
        }else {
            MessageBox MesBox = new MessageBox();
            MesBox.MessageBoxOK("Falsch. Die richtige Antwort währe \""+ antwort +"\" gewesen.");
            DBHelper.databaseupdaterichtigfalsch("update karten set richtig = (?) where frage ='" + frage + "' and karteienfk =" + karteifk, Boolean.FALSE);
            ++Falsch;
        }
        frageausgabe();
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
            this.TFAntwort.setFont(Font.font ("System", (Double) newValue * 0.0375));
            this.LbFrage.setFont(Font.font ("System", (Double) newValue * 0.0375));
            System.out.println("height: " + newValue);
        }));
        frageausgabe();
    }


    @Override
    public void frageausgabe() {
        try{
            DBManager DBHelper = new DBManager();
            List<String> listfrage = DBHelper.Select02("select * from karten where KarteienFK =" + getKarteienID() +";", "Frage");
            List<String> listantwort = DBHelper.Select02("select * from karten where KarteienFK =" + getKarteienID() +";", "Antwort");
            frage = listfrage.get(i);
            antwort = listantwort.get(i);
            LbFrage.setText(frage);
            i++;
        }catch (Exception Java){
            MessageBox MesBox = new MessageBox();
            MesBox.MessageBoxOK("Richtig: " + Richtig + " | Falsch: " + Falsch);
            Seitenwechsel sceneload = new Seitenwechsel();
            sceneload.wechsel("UebenAuswahl", btnAbbrechen, mainAnchor.getHeight(),  mainAnchor.getWidth());
        }
        TFAntwort.setText("");
    }
}
