package shopping.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import shopping.control.ControlButton;

public class ListenerButtonPrevious implements ActionListener {
    private ControlButton control;

    public ListenerButtonPrevious(ControlButton control) {
        this.control = control;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        control.previous();
    }

}
