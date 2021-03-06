import java.util.Observable;

/**
 * Created by arnaudfreismuth on 18/01/2017.
 */
abstract public class Drones extends Observable {
    private String nom;
    private int vitesse; //en case par secondes
    private double consommation; //% perdu par déplacement
    private double batterie; //en % De 0 à 100
    private double charge; //le poid maximal que peut supporter le drone
    private int distanceMax; //Par rapport au point central
    private Point position; // La position du drone
    private Point destination; // La destination du drone
    private Colis colis; //null si il n'y en a pas
    private Instruction instruction; //La tâche à accomplir

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
        setChanged();
        notifyObservers(this.position);
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

    public String toString() {
        return nom;
    }

    public void seRecharger() {
        this.setBatterie(100);
    }

    /**
     * Déplace le drone
     */
    public void seDeplacer() {
        //Le lieu où doit aller le drone
        Point pDest = this.getDestination();
        //nbDeplacement correspont à la vitesse (nombre de case par secondes)
        int nbDeplacement = this.getVitesse();

        Point pointEnCours = this.getPosition();
        for (int i = 0; i < nbDeplacement; i++) {
            //on vérifie ensuite si la batterie du drone est suffisante pour effectuer le déplacement
            if (this.getBatterie() - this.getConsommation() >= 0) {
                pointEnCours = pointEnCours.meilleurPoint(pDest);
                //le déplacement est effectué, la batterie diminue
                double etatBatterie = this.getBatterie() - this.getConsommation();
                this.setBatterie(etatBatterie);
            } else {
                this.setBatterie(0);
            }
        }

        //Si il se trouve à l'endroit de destination
        if (pointEnCours.equals(pDest)) {
            //Si le drone doit livrer un colis
            if (this.getInstruction().getType() == Instruction.Type.LIVRER_COLIS) {
                System.out.println("le colis " + this.colis.getNomColis() + " a bien été livré");
                this.setInstruction(new Instruction(Instruction.Type.RENTRER_A_LA_BASE));
            }
            //Si le drone est parti en reco
            if (this.getInstruction().getType() == Instruction.Type.PARTIR_EN_RECONNAISSANCE) {
                System.out.println("La zone (" + this.getDestination().getCoordonneeX() + ";" + this.getDestination().getCoordonneeY() + ") a été visité");
                this.setInstruction(new Instruction(Instruction.Type.RENTRER_A_LA_BASE));
            }
            //Si il se trouve à l'emplacement d'un drône a réparer
            if (this.getInstruction().getType() == Instruction.Type.RETROUVER_DRONE) {
                this.setInstruction(new Instruction(Instruction.Type.RECHARGER_DRONE));
            }
        }

        //Si il se trouve à la base et devait y retourner, on le met en attente
        if (pointEnCours.equals(new Point()) && this.getInstruction().getType() == Instruction.Type.RENTRER_A_LA_BASE) {
            //Une fois à la base, il se recharge automatiquement
            this.seRecharger();
            System.out.println("Je suis à la base et je me recharge");
            this.setInstruction(new Instruction(Instruction.Type.EN_ATTENTE));
        }
        this.setPosition(pointEnCours);
    }
}
