
/**
 * Classe representant les drones WarMachine
 *
 * @author Elian
 */

public class WarMachine {

    /**
     * Current position
     */
    protected String position;
    /**
     * The battery
     */
    protected int power;
    /**
     * The type
     */
    protected String type;
    /**
     * The speed
     */
    protected static int speed = 30;
    /**
     * The transmitting distance
     */
    protected static int transmittingDistance = 100;
    /**
     * The battery consumption
     */
    protected static int consumption = 10;
    /**
     * The battery consumption for the gun
     */
    private static int gunConsumption = 30;


    /**
     * Build a WarMachine located at the position <0;0>
     */
    public WarMachine() {
        this.type = "War Machine";
        this.position = "<0;0>";
        this.power = 100;
    }

    /**
     * Build a WarMachine and set its position
     *
     * @param position the position
     */
    public WarMachine(String position) {
        this.type = "War Machine";
        this.position = "<0;0>";
        this.power = 100;
    }

    /**
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * @return the power
     */
    public int getPower() {
        return power;
    }

    /**
     * @param power the power to set
     */
    public void setPower(int power) {
        this.power = power;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the speed
     */
    public static int getSpeed() {
        return WarMachine.speed;
    }

    /**
     * @param speed the speed to set
     */
    public static void setSpeed(int speed) {
        WarMachine.speed = speed;
    }

    /**
     * @return the transmittingDistance
     */
    public static int getTransmittingDistance() {
        return WarMachine.transmittingDistance;
    }

    /**
     * @param transmittingDistance the transmittingDistance to set
     */
    public static void setTransmittingDistance(int transmittingDistance) {
        WarMachine.transmittingDistance = transmittingDistance;
    }

    /**
     * @return the consumption
     */
    public static int getConsumption() {
        return WarMachine.consumption;
    }

    /**
     * @param consumption the consumption to set
     */
    public static void setConsumption(int consumption) {
        WarMachine.consumption = consumption;
    }


    /**
     * Allow to attack a position
     *
     * @param target the position
     * @param drone  the Object representing the target located at the position
     */
    public void attack(String target, Object o) {
        // The WarMachine goes to the position
        this.go(target);
        if (this.power >= WarMachine.gunConsumption) {
            // The target's battery is discharged
            this.power = this.power - WarMachine.gunConsumption;
        }


    }

    /**
     * Move to a position (useless)
     *
     * @param target the position
     */
    public void go(String target) {
        String[] parts = this.getPosition().split(";");

        int longitude = Integer.parseInt(parts[0].substring(1, parts[0].length()));
        int latitude = Integer.parseInt(parts[1].substring(0, parts[1].length() - 1));
        // If we can go to the position
        if (Math.sqrt(Math.pow(longitude, 2) + Math.pow(latitude, 2)) < WarMachine.getTransmittingDistance()) {
            if (this.power >= getConsumption()) {
                // The WarMachine goes to the position
                this.setPower(this.getPower() - WarMachine.getConsumption());
                this.setPosition(target);

            }
        }
    }
}
