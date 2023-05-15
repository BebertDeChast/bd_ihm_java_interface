package albumPhoto.control;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;

import albumPhoto.abstraction.Album;
import albumPhoto.presentation.FrameAlbumPhoto;

public class ControlThumbnails implements PropertyChangeListener {
	private FrameAlbumPhoto presentation;
	private Album model; 

	public ControlThumbnails(Album model) {
		this.model = model; 
		this.model.addPropertyChangeListener(this); 
	}

	/**
	 * Methode appelee suite a une modification de l'abstraction
	 * --> le controleur met a jour sa facette de presentation en fonction du type de changement qui a eu lieu dans l'abstraction.
	 */
	public void propertyChange(PropertyChangeEvent evt) {
		String msg = evt.getPropertyName();
		if (msg==Album.MESSAGE_CHANGEMENT_IMAGE_COURANTE) {
			this.presentation.setSelectedThumbnail(this.model.getCurrentIndex());
		} else if (msg == Album.MESSAGE_NOUVELLE_IMAGE ) {
			this.presentation.addThumbnail(this.model.getPhoto(this.model.getSize()-1).getIcon());
		}
	}

	public void connectPresentation(FrameAlbumPhoto presentation) {
		this.presentation = presentation;
	}

	/**
	 * Methode faisant de la photo d'index index la photo courante.
	 * Cette methode est appelee par les listeners des vignettes afin "d'aller" a la photo correspondante suite a un survol de la vignette par la souris.
	 * @param index  index dan [0, this.model.getSize()-1]
	 */
	public void go(int index) {
		this.model.setCurrentIndex(index);
	}
	//---------------------------------------------------------------------------------------------------------------------------
	// Methode appelee par l'interface afin de connaitre les icones des photos (utiles pour la creation des vignettes/thumbnails) 
	//---------------------------------------------------------------------------------------------------------------------------
	public List<ImageIcon> getIcons() {
		List<ImageIcon> res = new LinkedList<ImageIcon>();
		for (int i=0; i<this.model.getSize(); i++) {
			res.add( this.model.getPhoto(i).getIcon());
		}
		return res;
	}

}