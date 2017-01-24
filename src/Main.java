import java.util.ArrayList;
import java.util.Random;

/**
 * Created by arnaudfreismuth on 23/01/2017.
 */

public class Main {
    public static void main(String[] args) {

        //Création de colis
        Point p1 = new Point(4, 6);
        Colis c1 = new Colis("colis1", p1, 2);

        DronesTerrestres alpha = new DronesTransportTerrestre("Alpha");
        ArrayList<Drones> listeDroneTransport = new ArrayList<Drones>();
        listeDroneTransport.add(alpha);

        ArrayList<Drones> listeDrones = new ArrayList<Drones>();
        listeDrones.add(alpha);

        ArrayList<Colis> listeColis = new ArrayList<Colis>();
        listeColis.add(c1);

        Base base = new Base(new ArrayList<Drones>(), listeDroneTransport, new ArrayList<Drones>(), listeDrones, listeColis, new ArrayList<Colis>());

        for (int i = 0; i < 200; i++) {
            base.donnerInstructionTransport();
            System.out.println("********" + i);
            System.out.println(alpha.getPosition().getCoordonneeX());
            System.out.println(alpha.getPosition().getCoordonneeY());
        }
        base.donnerInstructionTransport();


        /*alpha.prendreColis();

        for (int i = 0; i < 20 ; i++) {
            System.out.println("******  " + i);
            alpha.accomplirTache(Instruction.SE_DEPLACER);
            System.out.println(alpha.getPosition().getCoordonneeX());
            System.out.println(alpha.getPosition().getCoordonneeY());
        }
*/


    }


}
