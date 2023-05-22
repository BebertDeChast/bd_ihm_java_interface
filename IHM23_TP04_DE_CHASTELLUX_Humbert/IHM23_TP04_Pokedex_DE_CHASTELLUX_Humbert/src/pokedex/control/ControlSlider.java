package pokedex.control;

import java.beans.PropertyChangeListener;

import pokedex.abstraction.Pokedex;
import pokedex.presentation.FramePokedex;

public class ControlSlider implements PropertyChangeListener{
    private Pokedex pokedex;
    private FramePokedex framePokedex;

    public ControlSlider(Pokedex pokedex, FramePokedex framePokedex) {
        this.pokedex = pokedex;
        this.framePokedex = framePokedex;
        this.pokedex.addPropertyChangeListener(this);
    }

    public void selectPokemon(int value) {
        this.pokedex.goToIndex(value);
    }

    @Override
    public void propertyChange(java.beans.PropertyChangeEvent evt) {
        String msg = evt.getPropertyName();
        if (msg == Pokedex.MESSAGE_CHANGEMENT_POKEMON_COURANT) {
            this.framePokedex.updateSlider(this.pokedex.getCurrentIndex());
        }
    }
    
}
