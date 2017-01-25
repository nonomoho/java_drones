/**
 * Created by arnaudfreismuth on 18/01/2017.
 */
public class DronesReconnaissanceVolant extends DronesVolants {
    public DronesReconnaissanceVolant(String nom) {
        super(nom, 5, 0.8, 100, 1.5, 200, new Point(0, 0), new Point(0, 0), null, new Instruction(Instruction.Type.EN_ATTENTE), false);
    }
}
