/**
 * Created by arnaudfreismuth on 23/01/2017.
 */
public class Main {

    public static void main(String[] args) {
        Point p1 = new Point(2,2);
        Point p2 = new Point(12,5);
        Point p3 = p1.deplacerDrone(p2, 4);
        System.out.println(p3.getCoordonneeX());
        System.out.println(p3.getCoordonneeY());
    }
}
