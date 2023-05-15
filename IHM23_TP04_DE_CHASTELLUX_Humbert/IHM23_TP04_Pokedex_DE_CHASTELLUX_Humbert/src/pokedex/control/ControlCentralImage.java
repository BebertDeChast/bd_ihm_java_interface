package pokedex.control;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

import pokedex.abstraction.Pokedex;
import pokedex.presentation.FramePokedex;

public class ControlCentralImage implements PropertyChangeListener {
	private FramePokedex presentation;
	private Pokedex model;
	
	public ControlCentralImage(Pokedex model, FramePokedex presentation) {
		this.model = model;
		this.presentation = presentation;
		this.model.addPropertyChangeListener(this); 
	}

	/**
	 * Methode appelee suite a une modification de l'abstraction
	 * --> le controleur met a jour sa facette de presentation en fonction du type de changement qui a eu lieu dans l'abstraction.
	 */
	public void propertyChange(PropertyChangeEvent evt) {
		String msg = evt.getPropertyName();
		if (msg == Pokedex.MESSAGE_CHANGEMENT_POKEMON_COURANT ) {
			this.presentation.setCentralImageIcon("images"+File.separator+"moyennes"+File.separator+this.model.getCurrentPokemon().getNomen()+".jpg");
		} 
	}
}
