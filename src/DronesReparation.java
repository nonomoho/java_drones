/**
 * Created by arnaudfreismuth on 18/01/2017.
 */
public class DronesReparation extends DronesTerrestres {
    public DronesReparation(String nom, int vitesse, double consommation, double batterie, double charge, int distanceMax, Point position, Colis colis) {
        super(nom, vitesse, consommation, batterie, charge, distanceMax, position, colis);
    }

    public void rechargerDrone(Drones droneACharger) {
        if (this.getPosition() == droneACharger.getPosition()) {
            droneACharger.setBatterie(100);
        }
    }
}
