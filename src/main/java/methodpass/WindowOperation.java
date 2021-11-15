package methodpass;

import java.util.List;

public class WindowOperation {

    public void resiSize(List<Window> windows, int plusSize) {
        for (Window w : windows) {
            w.setHeight(w.getHeight() + plusSize);
        }
    }

}
