package sample.Functions;

import javafx.scene.control.Button;

public class Seitenwechsel extends BaseController {

    public void wechsel(String scene, Button buttonname, double Height, double Width){
        try {
            closeStage(buttonname);
            Sceneloader myloader = new Sceneloader();
            myloader.loader(scene, Height, Width);
        } catch (Exception java) {
            System.out.println(scene + ".fxml wurde nicht gefunden");
        }
    }
}
