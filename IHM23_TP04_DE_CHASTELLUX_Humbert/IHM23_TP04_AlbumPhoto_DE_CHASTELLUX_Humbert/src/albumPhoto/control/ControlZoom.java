package albumPhoto.control;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import albumPhoto.abstraction.Album;
import albumPhoto.presentation.FrameAlbumPhoto;

public class ControlZoom implements PropertyChangeListener {
	private FrameAlbumPhoto presentation;
	private Album model; 

	public ControlZoom(Album model) {
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
			this.presentation.setZoomValue(this.model.getCurrentPhoto().getZoom());
		}		
	}

	public void connectPresentation(FrameAlbumPhoto presentation) {
		this.presentation = presentation;
	}

	/**
	 * Methode modifiant le facteur de zoom de la photo courante.
	 * Cette methode est appelee par l'ecouteur du slider
	 * @param zoom
	 */
	public void resizeCurrentPhoto(int zoom) {
		this.model.resizeCurrentPhoto(zoom);
	}

}
