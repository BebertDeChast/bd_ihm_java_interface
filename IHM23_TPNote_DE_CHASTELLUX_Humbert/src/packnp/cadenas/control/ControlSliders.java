package packnp.cadenas.control;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import packnp.cadenas.abstraction.Cadenas;
import packnp.cadenas.presentation.FrameCadenas;

public class ControlSliders implements PropertyChangeListener {
    private Cadenas cadenas;
    private FrameCadenas frameCadenas;

    public ControlSliders(Cadenas cadenas) {
        this.cadenas = cadenas;
        this.cadenas.addPropertyChangeListener(this);
    }

    public void connectFrame(FrameCadenas frameCadenas) {
        this.frameCadenas = frameCadenas;
    }

    public void propertyChange(PropertyChangeEvent evt) {
        String msg = evt.getPropertyName();
        if (msg == Cadenas.MESSAGE_CHANGEMENT_CENTAINES) {
            frameCadenas.setSliderCentaine(cadenas.getCentaines());
        } else if (msg == Cadenas.MESSAGE_CHANGEMENT_DIZAINES) {
            frameCadenas.setSliderDizaine(cadenas.getDizaines());
        } else if (msg == Cadenas.MESSAGE_CHANGEMENT_UNITES) {
            frameCadenas.setSliderUnite(cadenas.getUnites());
        }
    }

    public void setCentaines(int centaines) {
        cadenas.setCentaines(centaines);
    }

    public void setDizaines(int dizaines) {
        cadenas.setDizaines(dizaines);
    }

    public void setUnites(int unites) {
        cadenas.setUnites(unites);
    }

}
