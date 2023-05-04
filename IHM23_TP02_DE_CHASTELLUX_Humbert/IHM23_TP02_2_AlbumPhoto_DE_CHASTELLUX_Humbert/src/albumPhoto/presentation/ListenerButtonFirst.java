package albumPhoto.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import albumPhoto.control.ControlNavigationButtons;

public class ListenerButtonFirst implements ActionListener {
    private ControlNavigationButtons control;

    public ListenerButtonFirst(ControlNavigationButtons control) {
        this.control = control;
    }

    public void actionPerformed(ActionEvent e) {
        control.goFirst();
    }
}