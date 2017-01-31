import java.util.Arrays;

public class WarMachineAdaptor extends Drones {

    private WarMachine warMachine = new WarMachine();


    public WarMachineAdaptor(String nom, double charge, Point destination, Colis colis, Instruction instruction) {
        super(nom, WarMachine.speed, WarMachine.consumption, 100, charge, WarMachine.transmittingDistance, new Point(0, 0), destination, colis, instruction);
    }


    public void attack(String target, Drones drone) {
        this.warMachine.attack(target, drone);
        this.setDestination(stringToPoint(target));
        this.seDeplacer();
        drone.setBatterie(0);
    }


    @Override
    public void seDeplacer() {
        super.seDeplacer();
    }

    @Override
    public void setBatterie(double batterie) {
        super.setBatterie(batterie);
        warMachine.setPower((int) batterie);
    }

    @Override
    public Point getPosition() {
        return stringToPoint(warMachine.getPosition());
    }

    @Override
    public void setPosition(Point position) {
        super.setPosition(position);
        warMachine.setPosition("<" + position.getCoordonneeX() + ";" + position.getCoordonneeY() + ">");
    }

    private Point stringToPoint(String position) {
        String[] rawPosition = position.split(";");
        int[] positionCoords = Arrays.stream(rawPosition).mapToInt(Integer::parseInt).toArray();
        return new Point(positionCoords[0], positionCoords[1]);
    }
}
