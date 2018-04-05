package sample.Functions;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Sceneloader {
    public void loader(String sceneName, double Height, double Width) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../FXML/" + sceneName + ".fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("KKK");
        stage.setMinHeight(647);
        stage.setMinWidth(1018);
        stage.setHeight(Height+47);
        stage.setWidth(Width+18);
        stage.setScene(new Scene(root1));
        stage.show();
    }


}
