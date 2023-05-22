package pokedex.presentation;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JSlider;

import pokedex.control.ControlSlider;

public class ListenerSlider implements ChangeListener {
    private ControlSlider controlSlider;

    public ListenerSlider(ControlSlider controlSlider) {
        this.controlSlider = controlSlider;
    }

    public void stateChanged(ChangeEvent e) {
        this.controlSlider.selectPokemon(((JSlider) e.getSource()).getValue());
    }
    
}
