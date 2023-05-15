package albumPhoto.control;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import albumPhoto.abstraction.Album;
import albumPhoto.presentation.FrameAlbumPhoto;

public class ControlThumbnails implements PropertyChangeListener {
    private FrameAlbumPhoto frame;
    private Album model;

    public ControlThumbnails(Album model, FrameAlbumPhoto frame) {
        this.model = model;
        this.frame = frame;
        this.model.addPropertyChangeListener(this);
    }

    public void go(int i) {
        this.model.setCurrentIndex(i);
    }

    public void propertyChange(PropertyChangeEvent evt) {
        String msg = evt.getPropertyName();
        if (msg == Album.MESSAGE_CHANGEMENT_IMAGE_COURANTE) {
            this.frame.setThumbnailsSelectedIndex(this.model.getCurrentIndex());
        } else if (msg == Album.MESSAGE_NOUVELLE_IMAGE) {
            this.frame.addThumbnail();
        } else {
        }

    }

}
