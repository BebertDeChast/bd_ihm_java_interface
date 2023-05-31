package packnp.cadenas.control;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import packnp.cadenas.abstraction.Cadenas;
import packnp.cadenas.presentation.FrameCadenas;

public class ControlArrows implements PropertyChangeListener {
    private Cadenas cadenas;
    private FrameCadenas frameCadenas;

    public ControlArrows(Cadenas cadenas) {
        this.cadenas = cadenas;
        this.cadenas.addPropertyChangeListener(this);
    }

    public void connectFrame(FrameCadenas frameCadenas) {
        this.frameCadenas = frameCadenas;
    }

    public void propertyChange(PropertyChangeEvent evt) {
        String msg = evt.getPropertyName();
        if (msg == Cadenas.MESSAGE_CHANGEMENT_CENTAINES) {
            updateCentaine();

        } else if (msg == Cadenas.MESSAGE_CHANGEMENT_DIZAINES) {
            updateDizaine();

        } else if (msg == Cadenas.MESSAGE_CHANGEMENT_UNITES) {
            updateUnite();
        }
    }

    public void upCentaine() {
        this.cadenas.incCentaines();
    }

    public void downCentaine() {
        this.cadenas.decCentaines();
    }

    public void upDizaine() {
        this.cadenas.incDizaines();
    }

    public void downDizaine() {
        this.cadenas.decDizaines();
    }

    public void upUnite() {
        this.cadenas.incUnites();
    }

    public void downUnite() {
        this.cadenas.decUnites();
    }

    public void updateCentaine() {
        if (cadenas.getCentaines() == 0) {
            frameCadenas.setUpCentaine(true);
            frameCadenas.setDownCentaine(false);
        } else if (cadenas.getCentaines() == 9) {
            frameCadenas.setUpCentaine(false);
            frameCadenas.setDownCentaine(true);
        } else {
            frameCadenas.setUpCentaine(true);
            frameCadenas.setDownCentaine(true);
        }
    }

    public void updateDizaine() {
        if (cadenas.getDizaines() == 0) {
            frameCadenas.setUpDizaine(true);
            frameCadenas.setDownDizaine(false);
        } else if (cadenas.getDizaines() == 9) {
            frameCadenas.setUpDizaine(false);
            frameCadenas.setDownDizaine(true);
        } else {
            frameCadenas.setUpDizaine(true);
            frameCadenas.setDownDizaine(true);
        }
    }

    public void updateUnite() {
        if (cadenas.getUnites() == 0) {
            frameCadenas.setUpUnite(true);
            frameCadenas.setDownUnite(false);
        } else if (cadenas.getUnites() == 9) {
            frameCadenas.setUpUnite(false);
            frameCadenas.setDownUnite(true);
        } else {
            frameCadenas.setUpUnite(true);
            frameCadenas.setDownUnite(true);
        }
    }
}
