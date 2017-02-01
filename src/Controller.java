import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ChoiceBox;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Controller implements Observer {
    @FXML
    private ChoiceBox<Drones> boxListeDrone;

    private Base laBasePrincipale;
    @FXML
    private ScatterChart<?, ?> myChart;


    public static void afficherInfoDrone(Drones d) {
        System.out.println("##########");
        System.out.println(d.getNom());
        System.out.println("état de la batterie : " + d.getBatterie());
        System.out.println("position x : " + d.getPosition().getCoordonneeX());
        System.out.println("position y : " + d.getPosition().getCoordonneeY());

    }

    public void lancerSimulation() throws InterruptedException {


        laBasePrincipale.donnerInstructionTransport();
        laBasePrincipale.donnerInstructionReparation();
        afficherInfoDrone(laBasePrincipale.getListeDrone().get(3));

        XYChart.Series series = new XYChart.Series();
        for (Drones d : laBasePrincipale.getListeDrone()) {
            int x = d.getPosition().getCoordonneeX();
            int y = d.getPosition().getCoordonneeY();
            series.getData().add(new XYChart.Data(x, y));

        }

        myChart.getData().clear();
        myChart.getData().add(series);

    }

    public void getValueChoixBox() {
        System.out.println(boxListeDrone.getValue().getNom());
    }

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
        DronesTerrestres gamma = new DronesTransportTerrestre("Gamma");
        DronesTerrestres delta = new DronesTransportTerrestre("Delta");
        ArrayList<Drones> listeDroneTransport = new ArrayList<Drones>();
        listeDroneTransport.add(alpha);
        listeDroneTransport.add(beta);
        listeDroneTransport.add(gamma);
        listeDroneTransport.add(delta);

        DronesReparation repartout = new DronesReparation("Repartout1");
        DronesReparation repartout2 = new DronesReparation("Repartout2");
        ArrayList<Drones> listeDroneReparation = new ArrayList<Drones>();
        listeDroneReparation.add(repartout);
        listeDroneReparation.add(repartout2);


        ArrayList<Drones> listeDrones = new ArrayList<Drones>();
        listeDrones.add(reco1);
        listeDrones.add(reco2);
        listeDrones.add(alpha);
        listeDrones.add(beta);
        listeDrones.add(gamma);
        listeDrones.add(delta);
        listeDrones.add(repartout);
        listeDrones.add(repartout2);


        laBasePrincipale = new Base(listeDroneReconnaissance, listeDroneTransport, listeDroneReparation, listeDrones, listeColis, new ArrayList<Colis>());

        ObservableList<Drones> listeNomDrones = FXCollections.observableArrayList();
        for (Drones d : listeDrones) {
            listeNomDrones.add(d);
        }
        boxListeDrone.setItems(listeNomDrones);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("changement");
    }
}
