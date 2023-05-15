package albumPhoto.control;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import albumPhoto.abstraction.Album;
import albumPhoto.presentation.FrameAlbumPhoto;

public class ControlCentralImage implements PropertyChangeListener {
	private FrameAlbumPhoto presentation;
	private Album model;
	
	public ControlCentralImage(Album model) {
		this.model = model;
		this.model.addPropertyChangeListener(this); 
	}
	/**
	 * Les controleurs sont crees avant l'interface : un appel a connectPresentation
	 * est necessaire apres la creation de l'interface graphique afin que le controleur
	 * dispose d'un lien vers l'interface.
	 */
	public void connectPresentation(FrameAlbumPhoto presentation) {
		this.presentation = presentation;
	}

	/**
	 * Methode appelee suite a une modification de l'abstraction
	 * --> le controleur met a jour sa facette de presentation en fonction du type de changement qui a eu lieu dans l'abstraction.
	 */
	public void propertyChange(PropertyChangeEvent evt) {
		String msg = evt.getPropertyName();
		if (msg == Album.MESSAGE_CHANGEMENT_IMAGE_COURANTE ) {
			this.presentation.setCentralImageIcon(this.model.getCurrentPhoto());
		} else if (msg == Album.MESSAGE_CHANGEMENT_ZOOM) {
			this.presentation.resizeCentralImage(model.getCurrentPhoto().getSize());
		} else {
			// Le message correspond a l'ajout d'une nouvelle image
			// rien a faire vu que l'image courante ne change pas
		}
	}
}
