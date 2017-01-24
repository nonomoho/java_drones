
/**
 * Created by arnaudfreismuth on 23/01/2017.
 */

public class Main {
    public static void main(String[] args) {

        //Création de points de destinantion
        Point p1 = new Point(10, 20);
        Colis c1 = new Colis("colis1", p1, 30);

        DronesReparation alpha = new DronesReparation("Alpha");
        alpha.setColis(c1);

        for (int i = 0; i < 20 ; i++) {
            System.out.println("******  " + i);
            alpha.deplacerDrone();
            System.out.println(alpha.getPosition().getCoordonneeX());
            System.out.println(alpha.getPosition().getCoordonneeY());
        }



    }


}
