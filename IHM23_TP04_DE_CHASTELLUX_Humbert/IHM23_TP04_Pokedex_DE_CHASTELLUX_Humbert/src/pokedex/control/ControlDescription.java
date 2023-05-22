package pokedex.control;

import java.beans.PropertyChangeListener;

import pokedex.abstraction.Pokedex;
import pokedex.presentation.FramePokedex;

public class ControlDescription implements PropertyChangeListener {
    private Pokedex pokedex;
    private FramePokedex framePokedex;

    public ControlDescription(Pokedex pokedex, FramePokedex framePokedex) {
        this.pokedex = pokedex;
        this.framePokedex = framePokedex;
        this.pokedex.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(java.beans.PropertyChangeEvent evt) {
        String msg = evt.getPropertyName();
        if (msg == Pokedex.MESSAGE_CHANGEMENT_POKEMON_COURANT) {
            this.framePokedex.updateDescription();
        }
    }
}
