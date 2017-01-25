/**
 * Created by arnaudfreismuth on 18/01/2017.
 */
public class DronesReparation extends DronesTerrestres {
    private boolean chargePossible;

    public DronesReparation(String nom) {
        super(nom, 5, 0.2, 100, 1, 500, new Point(0, 0), new Point(0, 0), null,  new Instruction(Instruction.Type.EN_ATTENTE));
        this.chargePossible = false;
    }

    public void rechargerDrone(Drones droneACharger) {
        if (this.getPosition() == droneACharger.getPosition()) {
            droneACharger.setBatterie(100);
        }
    }
}
