package albumPhoto.control;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import albumPhoto.abstraction.Album;
import albumPhoto.presentation.FrameAlbumPhoto;

public class ControlNavigationButtons implements PropertyChangeListener {

	private FrameAlbumPhoto frame;
	private Album model; 

	public ControlNavigationButtons(Album model) {
		this.model = model; 
		this.model.addPropertyChangeListener(this); 
	}
	public void connectPresentation(FrameAlbumPhoto frame) {
		this.frame = frame;
	}
	//-------------------------------------------------------------------------------------------------------------
	// Methodes correspondant a des actions possibles de l'utilisateurs (appelees par les ecouteurs de l'interface) 
	//-------------------------------------------------------------------------------------------------------------

	public void goFirst() {
		this.model.setCurrentIndex(0);
	}

	public void goPrevious() {
		this.model.setCurrentIndex(this.model.getCurrentIndex()-1);
	}

	public void goNext() {
		this.model.setCurrentIndex(this.model.getCurrentIndex()+1);
	}

	public void goLast() {
		this.model.setCurrentIndex(this.model.getSize()-1);
	}

	public void propertyChange(PropertyChangeEvent evt) {
		String msg = evt.getPropertyName();
		if (msg == Album.MESSAGE_CHANGEMENT_IMAGE_COURANTE || msg == Album.MESSAGE_NOUVELLE_IMAGE) { // le nom de l'image demeure inchange dans le cas de l'ajout d'une image ou d'un changement de facteur de zoom
			this.frame.setButtonFirstEnabled(this.model.getCurrentIndex()!=0);
			this.frame.setButtonPreviousEnabled(this.model.getCurrentIndex()!=0);
			this.frame.setButtonNextEnabled(this.model.getCurrentIndex()!=this.model.getSize()-1);
			this.frame.setButtonLastEnabled(this.model.getCurrentIndex()!=this.model.getSize()-1);
		}
	}
}
