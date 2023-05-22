package shopping.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import shopping.control.ControlCart;

public class ListenerButtonEmpty implements ActionListener {
    private ControlCart control;

    public ListenerButtonEmpty(ControlCart control) {
        this.control = control;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        control.empty();
    }

}
