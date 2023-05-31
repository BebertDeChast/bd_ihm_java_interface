package packnp.cadenas.control;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import packnp.cadenas.abstraction.Cadenas;
import packnp.cadenas.presentation.FrameCadenas;

public class ControlLabels implements PropertyChangeListener {
    private Cadenas cadenas;
    private FrameCadenas frameCadenas;

    public ControlLabels(Cadenas cadenas) {
        this.cadenas = cadenas;
        this.cadenas.addPropertyChangeListener(this);
    }

    public void connectFrame(FrameCadenas frameCadenas) {
        this.frameCadenas = frameCadenas;
    }

    public void propertyChange(PropertyChangeEvent evt) {
        String msg = evt.getPropertyName();
        if (msg == Cadenas.MESSAGE_CHANGEMENT_CENTAINES) {
            frameCadenas.setCentaines(cadenas.getCentaines());
        } else if (msg == Cadenas.MESSAGE_CHANGEMENT_DIZAINES) {
            frameCadenas.setDizaines(cadenas.getDizaines());
        } else if (msg == Cadenas.MESSAGE_CHANGEMENT_UNITES) {
            frameCadenas.setUnites(cadenas.getUnites());
        }
    }
    
}
