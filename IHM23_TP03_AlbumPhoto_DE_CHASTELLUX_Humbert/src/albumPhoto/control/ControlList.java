package albumPhoto.control;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import albumPhoto.abstraction.Album;
import albumPhoto.presentation.FrameAlbumPhoto;

public class ControlList implements PropertyChangeListener {

    private FrameAlbumPhoto frame;
    private Album model;

    public ControlList(Album model, FrameAlbumPhoto frame) {
        this.model = model;
        this.frame = frame;
        this.model.addPropertyChangeListener(this);
    }

    public void select(int index) {
        this.model.setCurrentIndex(index);
    }

    public void propertyChange(PropertyChangeEvent evt) {
        String msg = evt.getPropertyName();
        if (msg == Album.MESSAGE_CHANGEMENT_IMAGE_COURANTE) {
            this.frame.setListSelectedIndex(this.model.getCurrentIndex());
        } else if (msg == Album.MESSAGE_NOUVELLE_IMAGE) {
            this.frame.addToList(this.model.getPhoto(this.model.getSize() - 1).getName());
        } else {
        }
    }

}
