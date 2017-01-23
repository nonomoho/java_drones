/**
 * Created by arnaudfreismuth on 18/01/2017.
 */
abstract public class Drones {
    private String nom;
    private int vitesse; //en case par secondes
    private double consommation; //% perdu par déplacement
    private double batterie; //en % De 0 à 100
    private double charge;
    private int distanceMax;
    private Point position;
    private Colis colis; //null si il n'y en a pas

    public Drones(String nom, int vitesse, double consommation, double batterie, double charge, int distanceMax, Point position, Colis colis) {
        this.nom = nom;
        this.vitesse = vitesse;
        this.consommation = consommation;
        this.batterie = batterie;
        this.charge = charge;
        this.distanceMax = distanceMax;
        this.position = position;
        this.colis = colis;
    }
}
