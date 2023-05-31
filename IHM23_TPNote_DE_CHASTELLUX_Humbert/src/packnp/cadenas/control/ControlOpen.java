package packnp.cadenas.control;

import java.beans.PropertyChangeListener;

import packnp.cadenas.abstraction.Cadenas;
import packnp.cadenas.presentation.FrameCadenas;

public class ControlOpen implements PropertyChangeListener {
    private Cadenas cadenas;
    private FrameCadenas frameCadenas;

    public ControlOpen(Cadenas cadenas) {
        this.cadenas = cadenas;
        this.cadenas.addPropertyChangeListener(this);
    }

    public void connectFrame(FrameCadenas frameCadenas) {
        this.frameCadenas = frameCadenas;
    }

    public void propertyChange(java.beans.PropertyChangeEvent evt) {
        if (this.cadenas.ouvertureOK()) {
            frameCadenas.setOuvrir(true);
        } else {
            frameCadenas.setOuvrir(false);
        }
    }

}
