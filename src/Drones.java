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
    private Point destination; // La destination du drone
    private Colis colis; //null si il n'y en a pas
    private Instruction instruction; //numéro de la tâche à accomplir

    public Drones(String nom, int vitesse, double consommation, double batterie, double charge, int distanceMax, Point position, Point destination, Colis colis, Instruction instruction) {
        this.nom = nom;
        this.vitesse = vitesse;
        this.consommation = consommation;
        this.batterie = batterie;
        this.charge = charge;
        this.distanceMax = distanceMax;
        this.position = position;
        this.destination = destination;
        this.colis = colis;
        this.instruction = instruction;
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

    public Point getDestination() {
        return destination;
    }

    public void setDestination(Point destination) {
        this.destination = destination;
    }

    public Instruction getInstruction() {
        return instruction;
    }

    public void setInstruction(Instruction instruction) {
        this.instruction = instruction;
    }

    /**
     * Déplace le drone
     */
    public void seDeplacer() {
        //Le lieu où doit aller le drone
        Point pDest = this.getDestination();
        //nbDeplacement correspont à la vitesse (nombre de case par secondes)
        int nbDeplacement = this.vitesse;

        Point pointEnCours = this.position;
        for (int i = 0; i < nbDeplacement; i++) {
            //on vérifie ensuite si la batterie du drone est suffisante pour effectuer le déplacement
            if (this.getBatterie() - this.getConsommation() >= 0) {
                pointEnCours = pointEnCours.meilleurPoint(pDest);
                //le déplacement est effectué, la batterie diminue
                double etatBatterie = this.getBatterie() - this.getConsommation();
                this.setBatterie(etatBatterie);
            }
        }

        //Si il se trouve à l'endroit de destination
        if (pointEnCours.equals(pDest)) {
            if (this.getInstruction().getType() == Instruction.Type.LIVRER_COLIS) {
                System.out.println("le colis " + this.colis.getNomColis() + " a bien été livré");
            }
            this.setInstruction(new Instruction(Instruction.Type.RENTRER_A_LA_BASE));
        }

        //Si il se trouve à la base et devait y retourner, on le met en attente
        if (pointEnCours.equals(new Point()) && this.getInstruction().getType() == Instruction.Type.RENTRER_A_LA_BASE) {
            this.setInstruction(new Instruction(Instruction.Type.EN_ATTENTE));
        }
        this.position = pointEnCours;
    }
}
