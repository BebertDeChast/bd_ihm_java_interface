package pokedex.presentation;

import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import pokedex.control.ControlSearch;

public class ListenerTextField implements CaretListener {
    private ControlSearch controlSearch;
    private JTextField textfield;

    public ListenerTextField(ControlSearch controlSearch, JTextField textfield) {
        this.controlSearch = controlSearch;
        this.textfield = textfield;
    }

    public void caretUpdate(CaretEvent e) {
        this.controlSearch.changed(textfield);
    }

}
