package albumPhoto.control;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import albumPhoto.abstraction.Album;
import albumPhoto.presentation.FrameAlbumPhoto;

public class ControlPhotoName implements PropertyChangeListener {

    private FrameAlbumPhoto presentation;
    private Album model;

    public ControlPhotoName(Album model, FrameAlbumPhoto presentation) {
        this.model = model;
        this.presentation = presentation;
        this.model.addPropertyChangeListener(this);
    }
    
    public void propertyChange(PropertyChangeEvent evt) {
        String msg = evt.getPropertyName();
        if (msg == Album.MESSAGE_CHANGEMENT_IMAGE_COURANTE) {
            this.presentation.setPhotoNameText(this.model.getCurrentPhoto().getName());
        } else {
        }
    }
    
}
