package pokedex.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import pokedex.control.ControlSearch;

public class ListenerSearch implements ActionListener {
    private ControlSearch controlSearch;
    private JTextField search;

    public ListenerSearch(ControlSearch controlSearch, JTextField search) {
        this.controlSearch = controlSearch;
        this.search = search;
    }

    public void actionPerformed(ActionEvent e) {
        this.controlSearch.selectPokemon(search.getText());

    }

}
