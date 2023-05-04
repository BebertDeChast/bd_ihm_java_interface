package albumPhoto.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import albumPhoto.control.ControlNavigationButtons;

public class ListenerButtonNext implements ActionListener {
    private ControlNavigationButtons control;

    public ListenerButtonNext(ControlNavigationButtons control) {
        this.control = control;
    }

    public void actionPerformed(ActionEvent e) {
        control.goNext();
    }
}
