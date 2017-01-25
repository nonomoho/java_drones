/**
 * Created by arnaudfreismuth on 24/01/2017 inspired by Julien Angeloni
 */
public class Instruction {

    private final Type type;

    public Instruction(Type type) {
        this.type = type;
    }

    public enum Type {
        EN_ATTENTE,
        RENTRER_A_LA_BASE,
        LIVRER_COLIS,
        PARTIR_EN_RECONNAISSANCE,
        RECHARGER_DRONE
    }


    public Type getType() {
        return type;
    }
}
