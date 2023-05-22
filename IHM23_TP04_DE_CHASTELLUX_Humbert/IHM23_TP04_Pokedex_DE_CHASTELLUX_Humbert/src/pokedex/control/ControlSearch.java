package pokedex.control;

import javax.swing.JTextField;

import pokedex.abstraction.Pokedex;
import pokedex.presentation.FramePokedex;

public class ControlSearch {
    private Pokedex pokedex;
    private FramePokedex framePokedex;

    public ControlSearch(Pokedex pokedex, FramePokedex framePokedex) {
        this.pokedex = pokedex;
        this.framePokedex = framePokedex;
    }

    public void selectPokemon(String research) {
        this.pokedex.goToIdOrName(research);
    }

    public void changed(JTextField textfield) {
        if (textfield.getText().equals("")) {
            this.framePokedex.desactivateSearchButton();
        } else {
            this.framePokedex.activateSearchButton();
        }

    }
}
