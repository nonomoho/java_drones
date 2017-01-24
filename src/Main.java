/**
 * Created by legrosgay on 23/01/2017.
 */
public class Main {

    public static void main(String[] args) {
        Point p1 = new Point(2, 2);
        Point p2 = new Point(12, 5);
        Colis c1 = new Colis("colis1", p2, 30);

        DronesReconnaissanceTerrestre alpha = new DronesReconnaissanceTerrestre("Alpha", 3, 1, 100, 100, 20, p1, c1);

        alpha.chargerDrone(c1);

        Point p3 = alpha.deplacerDrone(c1.getDestination(), alpha.getVitesse());
        System.out.println(p3.getCoordonneeX());
        System.out.println(p3.getCoordonneeY());
        System.out.println("My name is Arnaud and im so gay");
    }
}
