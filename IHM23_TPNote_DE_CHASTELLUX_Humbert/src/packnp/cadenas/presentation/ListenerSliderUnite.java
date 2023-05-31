package packnp.cadenas.presentation;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JSlider;

import packnp.cadenas.control.ControlSliders;

public class ListenerSliderUnite implements ChangeListener {
    private ControlSliders controlSliders;

    public ListenerSliderUnite(ControlSliders controlSliders) {
        this.controlSliders = controlSliders;
    }

    public void stateChanged(ChangeEvent e) {
        this.controlSliders.setUnites(((JSlider) e.getSource()).getValue());
    }

}
