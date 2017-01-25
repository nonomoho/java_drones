/**
 * Created by arnaudfreismuth on 18/01/2017.
 */
abstract public class DronesTerrestres extends Drones{

    public DronesTerrestres(String nom, int vitesse, double consommation, double batterie, double charge, int distanceMax, Point position, Point destination, Colis colis, Instruction instruction) {
        super(nom, vitesse, consommation, batterie, charge, distanceMax, position, destination, colis, instruction);
    }
}
