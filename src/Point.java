/**
 * Created by arnaudfreismuth on 18/01/2017.
 */
public class Point {
    private int coordonneeX;
    private int coordonneeY;

    public Point(int coordonneeX, int coordonneeY) {
        this.coordonneeX = coordonneeX;
        this.coordonneeY = coordonneeY;
    }

    public int getCoordonneeX() {
        return coordonneeX;
    }

    public void setCoordonneeX(int coordonneeX) {
        this.coordonneeX = coordonneeX;
    }

    public int getCoordonneeY() {
        return coordonneeY;
    }

    public void setCoordonneeY(int coordonneeY) {
        this.coordonneeY = coordonneeY;
    }

    /**
     * @param pDest : le point de destinantion (le point où on veut se rendre)
     * @return pRetour : le point le plus proche pour y accéder
     */
    public Point meilleurPoint(Point pDest) {
        //on cree le point à rendre
        Point pRetour = new Point(this.coordonneeX, this.coordonneeY);

        //si on se trouve sur le bon point, on retourne le point
        if (this.coordonneeX == pDest.coordonneeX && this.coordonneeY == pDest.coordonneeY) {
            pRetour = this;
        }

        //si on est sur la meme abscisse mais pas le même ordonnée
        if (this.coordonneeX == pDest.coordonneeX && this.coordonneeY != pDest.coordonneeY) {
            if (pDest.coordonneeY - this.coordonneeY < 0) {
                pRetour.setCoordonneeX(pRetour.coordonneeX);
                pRetour.setCoordonneeY(pRetour.coordonneeY - 1);
            } else {
                pRetour.setCoordonneeX(pRetour.coordonneeX);
                pRetour.setCoordonneeY(pRetour.coordonneeY + 1);
            }
        }

        //si on est sur la meme Ordonnée
        if (this.coordonneeY == pDest.coordonneeY && this.coordonneeX != pDest.coordonneeX) {
            if (pDest.coordonneeX - this.coordonneeX < 0) {
                pRetour.setCoordonneeX(pRetour.coordonneeX - 1);
                pRetour.setCoordonneeY(pRetour.coordonneeY);
            } else {
                pRetour.setCoordonneeX(pRetour.coordonneeX + 1);
                pRetour.setCoordonneeY(pRetour.coordonneeY);
            }
        }

        //si est sur ni l'un ni l'autre
        if (this.coordonneeY != pDest.coordonneeY && this.coordonneeX != pDest.coordonneeX) {
            int diffAbscisse = pDest.coordonneeX - this.coordonneeX;
            int diffOrdonnee = pDest.coordonneeY - this.coordonneeY;
            //Dans ce cas on change la coordonnée X et Y
            if (diffAbscisse < 0 && diffOrdonnee < 0) {
                pRetour.setCoordonneeX(pRetour.coordonneeX - 1);
                pRetour.setCoordonneeY(pRetour.coordonneeY - 1);
            } else if (diffAbscisse < 0 && diffOrdonnee > 0) {
                pRetour.setCoordonneeX(pRetour.coordonneeX - 1);
                pRetour.setCoordonneeY(pRetour.coordonneeY + 1);
            } else if (diffAbscisse > 0 && diffOrdonnee < 0) {
                pRetour.setCoordonneeX(pRetour.coordonneeX + 1);
                pRetour.setCoordonneeY(pRetour.coordonneeY - 1);
            } else if (diffAbscisse > 0 && diffOrdonnee > 0) {
                pRetour.setCoordonneeX(pRetour.coordonneeX + 1);
                pRetour.setCoordonneeY(pRetour.coordonneeY + 1);
            }
        }

        //Ce point est donc le point le plus suivant le plus proche du point cible
        return pRetour;


    }
}
