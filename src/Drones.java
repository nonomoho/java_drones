/**
 * Created by arnaudfreismuth on 18/01/2017.
 */
abstract public class Drones {
    private String nom;
    private int vitesse; //en case par secondes
    private double consommation; //% perdu par déplacement
    private double batterie; //en % De 0 à 100
    private double charge; //le poid maximal que peut supporter le drone
    private int distanceMax; //Par rapport au point central
    private Point position; // La position du drone
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
     * @return pointEnCours : La nouvelle position du drone
     */
    public void deplacerDrone() {
        //Si le drone porte un colis, on réccupère le point de livraison. Sinon il rentre à la base (0,0)
        Point pDest;
        if (this.colis != null) {
            pDest = this.colis.getDestination();
        } else {
            pDest = new Point(0, 0);
        }

        //nbDeplacement correspont à la vitesse (nombre de case par secondes)
        int nbDeplacement = this.vitesse;

        Point pointEnCours = this.position;
        for (int i = 0; i < nbDeplacement; i++) {
            //Si on se trouve à l'endroit de destination du colis, on le livre
            if(this.colis != null){
                if (this.position.getCoordonneeX() == this.colis.getDestination().getCoordonneeX() && this.position.getCoordonneeY() == this.colis.getDestination().getCoordonneeY()){
                    System.out.println("le colis " + this.colis.getNomColis() + " a été livré");
                    this.colis = null;
                }
            }
            //On vérifie d'abord si on ne se trouve pas hors de la portée du drone
            // à faire

            //on vérifie ensuite si la batterie du drone est suffisante pour effectuer le déplacement
            if (this.getBatterie() - this.getConsommation() >= 0) {
                pointEnCours = pointEnCours.meilleurPoint(pDest);
                //le déplacement est effectué, la batterie diminue
                double etatBatterie = this.getBatterie() - this.getConsommation();
                this.setBatterie(etatBatterie);
            }
        }
        this.position = pointEnCours;
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
