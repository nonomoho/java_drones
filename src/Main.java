import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by arnaudfreismuth on 23/01/2017.
 */

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("fxdrone.fxml"));
        primaryStage.setTitle("Drone - Arnaud Freismuth");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
//        Drones d = new DronesTransportTerrestre("coucou");
//        ObersverClass o = new ObersverClass();
//        d.addObserver(o);
//        d.setPosition(new Point(0,2));
        launch(args);
    }
}
