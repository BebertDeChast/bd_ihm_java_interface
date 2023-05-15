package albumPhoto.control;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import albumPhoto.abstraction.Album;
import albumPhoto.presentation.FrameAlbumPhoto;

public class ControlPhotoName implements PropertyChangeListener {

	private FrameAlbumPhoto presentation;
	private Album model;
	
	public ControlPhotoName(Album model) {
		this.model = model;
		this.model.addPropertyChangeListener(this); 
	}
	
	public void connectPresentation(FrameAlbumPhoto presentation) {
		this.presentation = presentation;
	}

	public void propertyChange(PropertyChangeEvent evt) {
		String msg = evt.getPropertyName();
		if (msg == Album.MESSAGE_CHANGEMENT_IMAGE_COURANTE ) { // le nom de l'image demeure inchange dans le cas de l'ajout d'une image ou d'un changement de facteur de zoom
			this.presentation.setPhotoNameText( this.model.getCurrentPhoto().getName() );
		} 
	}

}
