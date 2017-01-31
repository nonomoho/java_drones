import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

import java.util.ArrayList;
import java.util.Observable;

public class Controller {
    @FXML
    private ChoiceBox<String> boxListeDrone;

    @FXML
    public void initialize() {

        //Création de colis
        Point p1 = new Point(4, 6);
        Colis c1 = new Colis("colis1", p1, 2);
        Point p2 = new Point(30, -2);
        Colis c2 = new Colis("colis2", p2, 2);

        ArrayList<Colis> listeColis = new ArrayList<Colis>();
        listeColis.add(c1);
        listeColis.add(c2);

        DronesTerrestres reco1 = new DronesTransportTerrestre("Reco1");
        DronesTerrestres reco2 = new DronesTransportTerrestre("Reco2");
        ArrayList<Drones> listeDroneReconnaissance = new ArrayList<Drones>();
        listeDroneReconnaissance.add(reco1);
        listeDroneReconnaissance.add(reco2);

        DronesTerrestres alpha = new DronesTransportTerrestre("Alpha");
        DronesTerrestres beta = new DronesTransportTerrestre("Beta");
        ArrayList<Drones> listeDroneTransport = new ArrayList<Drones>();
        listeDroneTransport.add(alpha);
        listeDroneTransport.add(beta);

        DronesReparation repartout = new DronesReparation("Repartout1");
        ArrayList<Drones> listeDroneReparation = new ArrayList<Drones>();
        listeDroneReparation.add(repartout);


        ArrayList<Drones> listeDrones = new ArrayList<Drones>();
        listeDrones.add(reco1);
        listeDrones.add(reco2);
        listeDrones.add(alpha);
        listeDrones.add(beta);
        listeDrones.add(repartout);


        Base base = new Base(listeDroneReconnaissance, listeDroneTransport, listeDroneReparation, listeDrones, listeColis, new ArrayList<Colis>());

        ObservableList<String> listeNomDrones = FXCollections.observableArrayList();
        for (Drones d : listeDrones) {
            listeNomDrones.add(d.toStringNom());
        }
        boxListeDrone.setItems(listeNomDrones);
    }
}
