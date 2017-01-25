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
        Point p2 = new Point(30, -2);
        Colis c2 = new Colis("colis2", p2, 2);

        ArrayList<Colis> listeColis = new ArrayList<Colis>();
        listeColis.add(c1);
        listeColis.add(c2);

        DronesTerrestres reco1 = new DronesTransportTerrestre("Reco1");
        DronesTerrestres reco2 = new DronesTransportTerrestre("Reco2");
        ArrayList<Drones> listeDroneReconnaissance = new ArrayList<Drones>();
        listeDroneReconnaissance.add(reco1);
        listeDroneReconnaissance.add(reco2);

        DronesTerrestres alpha = new DronesTransportTerrestre("Alpha");
        DronesTerrestres beta = new DronesTransportTerrestre("Beta");
        ArrayList<Drones> listeDroneTransport = new ArrayList<Drones>();
        listeDroneTransport.add(alpha);
        listeDroneTransport.add(beta);

        DronesReparation repartout = new DronesReparation("Repartout1");
        ArrayList<Drones> listeDroneReparation = new ArrayList<Drones>();
        listeDroneReparation.add(repartout);


        ArrayList<Drones> listeDrones = new ArrayList<Drones>();
        listeDrones.add(reco1);
        listeDrones.add(reco2);
        listeDrones.add(alpha);
        listeDrones.add(beta);
        listeDrones.add(repartout);



        Base base = new Base(listeDroneReconnaissance, listeDroneTransport, listeDroneReparation, listeDrones, listeColis, new ArrayList<Colis>());

        for (int i = 0; i < 200; i++) {
            base.donnerInstructionTransport();
            base.donnerInstructionReparation();
            System.out.println("Alpha" + i);
            System.out.println(alpha.getBatterie());
            System.out.println(repartout.getPosition().getCoordonneeX());
            System.out.println(repartout.getPosition().getCoordonneeY());
            //System.out.println(alpha.getPosition().getCoordonneeX());
            //System.out.println(alpha.getPosition().getCoordonneeY());
            //System.out.println("Beta" + i);
            //System.out.println(beta.getPosition().getCoordonneeX());
            //System.out.println(beta.getPosition().getCoordonneeY());
        }


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
