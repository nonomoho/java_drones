/**
 * Created by arnaudfreismuth on 23/01/2017.
 */
public class Main {

    public static void main(String[] args) {
        Point p1 = new Point(1, 0);
        Point p2 = new Point(-2, -3);
        Colis c1 = new Colis("colis1", p2, 30);

        DronesReparation alpha = new DronesReparation("Alpha");
        alpha.setPosition(p1);
        alpha.chargerDrone(c1);

        Point p3 = alpha.deplacerDrone(c1.getDestination(), alpha.getVitesse());
        System.out.println(p3.getCoordonneeX());
        System.out.println(p3.getCoordonneeY());
    }
}
