/**
 * Created by arnaudfreismuth on 18/01/2017.
 */
abstract public class DronesVolants extends Drones{
    private boolean enVol;

    public DronesVolants(String nom, int vitesse, double consommation, double batterie, double charge, int distanceMax, Point position, Colis colis, boolean enVol) {
        super(nom, vitesse, consommation, batterie, charge, distanceMax, position, colis);
        this.enVol = enVol;
        this.setPosition(null);
    }
}
