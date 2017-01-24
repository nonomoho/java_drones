/**
 * Created by arnaudfreismuth on 18/01/2017.
 */
abstract public class Drones {
    private String nom;
    private int vitesse; //en case par secondes
    private double consommation; //% perdu par déplacement
    private double batterie; //en % De 0 à 100
    private double charge; //le poid maximal que peut supporter le drone
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public double getConsommation() {
        return consommation;
    }

    public void setConsommation(double consommation) {
        this.consommation = consommation;
    }

    public double getBatterie() {
        return batterie;
    }

    public void setBatterie(double batterie) {
        this.batterie = batterie;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public int getDistanceMax() {
        return distanceMax;
    }

    public void setDistanceMax(int distanceMax) {
        this.distanceMax = distanceMax;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Colis getColis() {
        return colis;
    }

    public void setColis(Colis colis) {
        this.colis = colis;
    }

    /**
     * @param pDest         c'est le point de destination du drône
     * @param nbDeplacement nombre de case que le drone peut parcourir ce tour
     * @return pointEnCours : La nouvelle position du drone
     */
    public Point deplacerDrone(Point pDest, int nbDeplacement) {
        Point pointEnCours = this.position;
        for (int i = 0; i < nbDeplacement; i++) {
            //On vérifie d'abord si on ne se trouve pas hors de la portée du drone
            // à faire
            pointEnCours = pointEnCours.meilleurPoint(pDest);
        }
        return pointEnCours;
    }

    /**
     * @param colis : le colis à charger sur le drone
     *              On vérifie si le drone a une capacité de charge suffisante pour porter le colis
     */
    public void chargerDrone(Colis colis) {
        //on test si le poid du colis est inférieur à la capacité du drone
        if (colis.getPoids() <= this.getCharge()) {
            this.setColis(colis);
        } else {
            System.out.println("Le colis " + colis.getNomColis() + " est trop lourd pour le drone " + this.getNom());
        }
    }


}
