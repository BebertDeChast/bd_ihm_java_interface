package pokedex.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pokedex.control.ControlButton;

public class ListenerButtonPrevious implements ActionListener {
    private ControlButton controlButton;

    public ListenerButtonPrevious(ControlButton controlButton) {
        this.controlButton = controlButton;
    }

    public void actionPerformed(ActionEvent e) {
        this.controlButton.previous();
    }

}
