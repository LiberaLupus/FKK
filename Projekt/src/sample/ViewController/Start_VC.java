package sample.ViewController;

import javafx.fxml.FXML;
import sample.Functions.DBManager;

import java.sql.SQLException;

public class Start_VC {



    @FXML
    public void initialize() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {
            DBManager DB = new DBManager();
            DB.Select("select Name from karteien;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
