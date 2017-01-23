/**
 * Created by arnaudfreismuth on 18/01/2017.
 */
public class DronesTransportVolant extends DronesVolants{
    public DronesTransportVolant(String nom, int vitesse, double consommation, double batterie, double charge, int distanceMax, Point position, Colis colis, boolean enVol) {
        super(nom, vitesse, consommation, batterie, charge, distanceMax, position, colis, enVol);
    }
}
