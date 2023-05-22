package shopping.presentation;

import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import shopping.control.ControlCart;

public class ListenerSpinner implements ChangeListener {
    private ControlCart control;

    public ListenerSpinner(ControlCart control) {
        this.control = control;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        control.updateQuantity((int) ((JSpinner) e.getSource()).getValue());
    }

}
