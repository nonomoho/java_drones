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

    public static void afficherInfoDrone(Drones d) {
        System.out.println("##########");
        System.out.println(d.getNom());
        System.out.println("état de la batterie : " + d.getBatterie());
        System.out.println("position x : " + d.getPosition().getCoordonneeX());
        System.out.println("position y : " + d.getPosition().getCoordonneeY());

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("fxdrone.fxml"));
        primaryStage.setTitle("Drone Arnaud Freismuth");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {

//        for (int i = 0; i < 200; i++) {
//
//
//            base.donnerInstructionTransport();
//            base.donnerInstructionReparation();
//            System.out.println(i);
//            afficherInfoDrone(alpha);
//            afficherInfoDrone(beta);
//            afficherInfoDrone(repartout);
//        }

        launch(args);



        /*alpha.prendreColis();

        for (int i = 0; i < 20 ; i++) {
            System.out.println("******  " + i);
            alpha.accomplirTache(Instruction.SE_DEPLACER);
            System.out.println(alpha.getPosition().getCoordonneeX());
            System.out.println(alpha.getPosition().getCoordonneeY());
        }
*/
    }
}
