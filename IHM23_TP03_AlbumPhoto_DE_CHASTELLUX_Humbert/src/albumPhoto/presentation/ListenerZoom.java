package albumPhoto.presentation;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import albumPhoto.control.ControlZoom;

public class ListenerZoom implements ChangeListener {
    private ControlZoom control;

    public ListenerZoom(ControlZoom control) {
        this.control = control;
    }

    public void stateChanged(ChangeEvent e) {
        this.control.resizeCurrentPhoto(((JSlider) e.getSource()).getValue());
    }

}
