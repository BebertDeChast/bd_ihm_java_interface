package pokedex.control;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import pokedex.abstraction.Pokedex;
import pokedex.presentation.FramePokedex;

public class ControlButton implements PropertyChangeListener {
    private Pokedex pokedex;
    private FramePokedex framePokedex;

    public ControlButton(Pokedex pokedex, FramePokedex framePokedex) {
        this.pokedex = pokedex;
        this.framePokedex = framePokedex;
        this.pokedex.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String msg = evt.getPropertyName();
        if (msg == Pokedex.MESSAGE_CHANGEMENT_POKEMON_COURANT) {
            if (this.pokedex.getCurrentIndex() == 0) {
                this.framePokedex.setButtonPreviousEnabled(false);
            } else {
                this.framePokedex.setButtonPreviousEnabled(true);
            }
            if (this.pokedex.getCurrentIndex() == (this.pokedex.size()-1)) {
                this.framePokedex.setButtonNextEnabled(false);
            } else {
                this.framePokedex.setButtonNextEnabled(true);
            }
        }
    }

    public void next() {
        this.pokedex.goNext();;
    }

    public void previous() {
        this.pokedex.goPrevious();
    }
}
