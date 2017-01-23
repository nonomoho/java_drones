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
}
