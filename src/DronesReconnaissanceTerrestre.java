/**
 * Created by arnaudfreismuth on 18/01/2017.
 */
public class DronesReconnaissanceTerrestre extends DronesTerrestres {
    public DronesReconnaissanceTerrestre(String nom) {
        super(nom, 4, 0.5, 100, 2, 100, new Point(0,0), new Point(0,0),null,  new Instruction(Instruction.Type.EN_ATTENTE));
    }
}
