package sample.Controller;

import javafx.fxml.FXML;
import sample.Functions.DBManager;

import java.sql.SQLException;

public class Controller {

    @FXML
    public void initialize() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {
            DBManager DB = new DBManager();
            DB.connectToMysql();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
