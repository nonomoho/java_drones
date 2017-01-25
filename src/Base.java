/**
 * Created by arnaudfreismuth on 24/01/2017.
 */

import java.util.ArrayList;
import java.util.Random;

public class Base {

    private ArrayList<Drones> listeDroneReconnaissance;
    private ArrayList<Drones> listeDroneTransport;
    private ArrayList<Drones> listeDroneReparation;
    private ArrayList<Drones> listeDrone;
    private ArrayList<Colis> listeColisALivrer;
    private ArrayList<Colis> listeColisLivre;

    public Base(ArrayList<Drones> listeDroneReconnaissance, ArrayList<Drones> listeDroneTransport, ArrayList<Drones> listeDroneReparation, ArrayList<Drones> listeDrone, ArrayList<Colis> listeColisALivrer, ArrayList<Colis> listeColisLivre) {
        this.listeDroneReconnaissance = listeDroneReconnaissance;
        this.listeDroneTransport = listeDroneTransport;
        this.listeDroneReparation = listeDroneReparation;
        this.listeDrone = listeDrone;
        this.listeColisALivrer = listeColisALivrer;
        this.listeColisLivre = listeColisLivre;
    }

    public ArrayList<Drones> getListeDroneReconnaissance() {
        return listeDroneReconnaissance;
    }

    public void setListeDroneReconnaissance(ArrayList<Drones> listeDroneReconnaissance) {
        this.listeDroneReconnaissance = listeDroneReconnaissance;
    }

    public ArrayList<Drones> getListeDroneTransport() {
        return listeDroneTransport;
    }

    public void setListeDroneTransport(ArrayList<Drones> listeDroneTransport) {
        this.listeDroneTransport = listeDroneTransport;
    }

    public ArrayList<Drones> getListeDroneReparation() {
        return listeDroneReparation;
    }

    public void setListeDroneReparation(ArrayList<Drones> listeDroneReparation) {
        this.listeDroneReparation = listeDroneReparation;
    }

    public ArrayList<Drones> getListeDrone() {
        return listeDrone;
    }

    public void setListeDrone(ArrayList<Drones> listeDrone) {
        this.listeDrone = listeDrone;
    }

    public ArrayList<Colis> getListeColisALivrer() {
        return listeColisALivrer;
    }

    public void setListeColisALivrer(ArrayList<Colis> listeColisALivrer) {
        this.listeColisALivrer = listeColisALivrer;
    }

    public ArrayList<Colis> getListeColisLivre() {
        return listeColisLivre;
    }

    public void setListeColisLivre(ArrayList<Colis> listeColisLivre) {
        this.listeColisLivre = listeColisLivre;
    }

    public void donnerInstructionReconnaissance() {
        //On parcourt chaque Drone de reconnaissance et on lui donne une instruction en fonction de son état
        for (Drones drone : this.listeDrone) {
            switch (drone.getInstruction().getType()) {
                case EN_ATTENTE: //il est en attente (i.e. à la base sans rien à faire

                    break;
            }
        }
    }

    public void donnerInstructionTransport() {
        //On parcourt chaque Drone de transport et on lui donne une instruction en fonction de son état
        for (Drones drone : this.listeDroneTransport) {
            //System.out.println(drone.getInstruction());
            switch (drone.getInstruction().getType()) {
                case EN_ATTENTE: //il est en attente (i.e. à la base sans rien à faire)
                    boolean chargeEffectuee = false;
                    if (!this.listeColisALivrer.isEmpty()) { // On va essayer de lui trouver un colis à livrer
                        int index = 0;
                        while (!chargeEffectuee && index <= this.listeColisALivrer.size()) {
                            if (this.listeColisALivrer.get(index).getPoids() <= drone.getCharge()) {
                                drone.setColis(this.listeColisALivrer.get(index)); //on lui donne un colis
                                listeColisALivrer.remove(index);
                                chargeEffectuee = true;
                                drone.setInstruction(new Instruction(Instruction.Type.LIVRER_COLIS));
                            }
                            index += 1;
                        }
                    }
                    if (!chargeEffectuee) { //Aucun colis ne lui correspond, il va partir en reco (un point aléatoire)
                        Random random = new Random();
                        int max = drone.getDistanceMax();
                        int xAleatoire = random.nextInt(2 * max + 1) - max;
                        int yAleatoire = random.nextInt(2 * max + 1) - max;
                        drone.setDestination(new Point(xAleatoire, yAleatoire));
                        drone.setInstruction(new Instruction(Instruction.Type.PARTIR_EN_RECONNAISSANCE));
                    }
                    break;

                case RENTRER_A_LA_BASE:
                    if (drone.getColis() != null) { //Il ne peut pas rentrer avec un coli, c'est à dire qu'il vient de le livrer
                        listeColisLivre.add(drone.getColis()); // On l'ajoute donc à la liste des colis livrés
                        drone.setColis(null); //On lui hôte le colis
                    }
                    drone.setDestination(new Point()); //Sa destination est la maison
                    drone.seDeplacer();
                    break;

                case LIVRER_COLIS:
                    drone.setDestination(drone.getColis().getDestination());
                    drone.seDeplacer();
                    break;

                case PARTIR_EN_RECONNAISSANCE:
                    drone.seDeplacer();
            }
        }
    }

    public void donnerInstructionReparation() {
        //On parcourt chaque Drone de réparation et on lui donne une instruction en fonction de son état
        for (Drones drone : this.listeDroneReparation) {
            switch (drone.getInstruction().getType()) {
                case EN_ATTENTE: //il est en attente (i.e. à la base sans rien à faire)
                    //On regarde si un drone est à plat
                    boolean enAttente = false;
                    int parcoursTransport = 0;
                    int parcoursReco = 0;

                    while (!enAttente && (!(parcoursTransport >= listeDroneTransport.size()) || !(parcoursReco >= listeDroneReconnaissance.size()))) {
                        Drones dTransport = listeDroneTransport.get(parcoursTransport);
                        if (dTransport.getBatterie() == 0) {
                            drone.setDestination(dTransport.getPosition());
                            drone.setInstruction(new Instruction(Instruction.Type.RETROUVER_DRONE));
                            enAttente = true;
                        }
                        Drones dReco = listeDroneReconnaissance.get(parcoursReco);
                        if (dReco.getBatterie() == 0) {
                            drone.setDestination(dReco.getPosition());
                            drone.setInstruction(new Instruction(Instruction.Type.RETROUVER_DRONE));
                            enAttente = true;
                        }
                        parcoursTransport += 1;
                        parcoursReco += 1;
                    }
                    break;
                case RETROUVER_DRONE: //il est en route vers un drone HS
                    drone.seDeplacer();
                    break;
                case RECHARGER_DRONE:
                    for (Drones d : this.listeDroneReparation) {
                        if (d.getPosition().equals(drone.getPosition()) && !(d.getNom().equals(drone.getNom()))){//On a trouver le drone à charger
                            d.setBatterie(100);
                            System.out.println("on a chargé le drone " + d.getNom());
                            d.setInstruction(new Instruction(Instruction.Type.RENTRER_A_LA_BASE));
                        }
                    }
                    break;
            }
        }
    }

}
