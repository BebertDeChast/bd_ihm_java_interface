package albumPhoto.control;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.LinkedList;
import java.util.List;

import albumPhoto.abstraction.Album;
import albumPhoto.presentation.FrameAlbumPhoto;

public class ControlList implements PropertyChangeListener {
	private FrameAlbumPhoto presentation;
	private Album model; 

	public ControlList(Album model) {
		this.model = model; 
		this.model.addPropertyChangeListener(this); 
	}

	/**
	 * Methode appelee suite a une modification de l'abstraction
	 * --> le controleur met a jour sa facette de presentation en fonction du type de changement qui a eu lieu dans l'abstraction.
	 */
	public void propertyChange(PropertyChangeEvent evt) {
		String msg = evt.getPropertyName();
		if (msg == Album.MESSAGE_CHANGEMENT_IMAGE_COURANTE ) {
			this.presentation.setListSelectedIndex(this.model.getCurrentIndex());
		} else if (msg == Album.MESSAGE_NOUVELLE_IMAGE ) {
			this.presentation.addToList(this.model.getPhoto(this.model.getSize()-1).getName());
		}
	}
	
	/**
	 * Les controleurs sont crees avant l'interface : un appel a connectPresentation
	 * est necessaire apres la creation de l'interface graphique afin que le controleur
	 * dispose d'un lien vers l'interface.
	 */
	public void connectPresentation(FrameAlbumPhoto presentation) {
		this.presentation = presentation;
	}
	
	//-----------------------------------------------------------------------
	// Methode appelee par l'interface afin de connaitre les noms des images 
	//-----------------------------------------------------------------------
	public List<String> getNames() {
		List<String> res = new LinkedList<String>();
		for (int i = 0; i < this.model.getSize(); i++) {
			res.add(this.model.getPhoto(i).getName());
		}
		return res;
	}

	//-------------------------------------------------------------------------------------------------------------
	// Methodes correspondant a des actions possibles de l'utilisateurs (appelees par les ecouteurs de l'interface) 
	//-------------------------------------------------------------------------------------------------------------
	public void select(int index) {
		this.model.setCurrentIndex(index);
	}


}