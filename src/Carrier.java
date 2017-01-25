public class Carrier {


    protected double[] l = {0.0, 0.0};
    protected int p = 100;
    protected String n = "Carrier";
    protected int s = 3;
    protected static int t = 20;
    protected static int c = 3;
    protected Object a = null;

    public Carrier() {

    }

    public void pickUp(double[] p, Object d) {
        this.a = d;
        this.go(p);
    }

    public void go(double[] p) {
        if ((this.p != 0) && (Math.sqrt(Math.pow(p[0], 2) + Math.pow(p[1], 2)) < t)) {
            this.p = this.p - Carrier.c;
            l = p;
        }
    }


}
