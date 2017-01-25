/**
 * Created by tirke on 25/01/2017.
 */
public class WarMachineAdaptor extends Drones {

    private WarMachine warMachine = new WarMachine();


    public WarMachineAdaptor(String nom, int vitesse, double consommation, double batterie, double charge, int distanceMax, Point position, Point destination, Colis colis, Instruction instruction) {
        super(nom, vitesse, consommation, batterie, charge, distanceMax, position, destination, colis, instruction);
    }


    public void attack(String target, Drones drone) {
        this.warMachine.attack(target, drone);
        drone.setBatterie(0);
    }


    @Override
    public void seDeplacer() {
        super.seDeplacer();

    }
}
