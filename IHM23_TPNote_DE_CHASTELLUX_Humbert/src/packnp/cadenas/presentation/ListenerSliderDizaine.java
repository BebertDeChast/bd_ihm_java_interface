package packnp.cadenas.presentation;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JSlider;

import packnp.cadenas.control.ControlSliders;

public class ListenerSliderDizaine implements ChangeListener {
    private ControlSliders controlSliders;

    public ListenerSliderDizaine(ControlSliders controlSliders) {
        this.controlSliders = controlSliders;
    }

    public void stateChanged(ChangeEvent e) {
        this.controlSliders.setDizaines(((JSlider) e.getSource()).getValue());
    }

}
