package pokedex.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pokedex.control.ControlButton;

public class ListenerButtonNext implements ActionListener{
    private ControlButton controlButton;

    public ListenerButtonNext(ControlButton controlButton) {
        this.controlButton = controlButton;
    }

    
    public void actionPerformed(ActionEvent e) {
        this.controlButton.next();
    }
    
}
