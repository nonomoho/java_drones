/**
 * Created by arnaudfreismuth on 23/01/2017.
 */
public class Main {

    public static void main(String[] args) {
        Point p1 = new Point(4,5);
        System.out.println("tutu");
        Point p2 = new Point(5,5);
        Point p3 = p1.meilleurPoint(p2);
        System.out.println(p3.getCoordonneeX());
        System.out.println(p3.getCoordonneeY());
    }
}
