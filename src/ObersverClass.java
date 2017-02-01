import java.util.Observable;
import java.util.Observer;

/**
 * Created by arnaudfreismuth on 01/02/2017.
 */
public class ObersverClass implements Observer {

    public ObersverClass() {
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("changement");
    }
}
