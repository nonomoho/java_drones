/**
 * Created by arnaudfreismuth on 18/01/2017.
 */
public class Colis {
    private String nomColis;
    private Point destination;
    private int poids;

    public Colis(String nomColis, Point destination, int poids) {
        this.nomColis = nomColis;
        this.destination = destination;
        this.poids = poids;
    }

    public String getNomColis() {
        return nomColis;
    }

    public void setNomColis(String nomColis) {
        this.nomColis = nomColis;
    }

    public Point getDestination() {
        return destination;
    }

    public void setDestination(Point destination) {
        this.destination = destination;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }
}
