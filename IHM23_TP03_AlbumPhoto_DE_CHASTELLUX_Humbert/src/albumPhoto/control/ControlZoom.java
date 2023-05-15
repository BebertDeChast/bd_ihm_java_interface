package albumPhoto.control;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import albumPhoto.abstraction.Album;
import albumPhoto.presentation.FrameAlbumPhoto;

public class ControlZoom implements PropertyChangeListener {
    private FrameAlbumPhoto frame;
    private Album model;

    public ControlZoom(Album model, FrameAlbumPhoto frame) {
        this.model = model;
        this.frame = frame;
        this.model.addPropertyChangeListener(this);
    }

    public void resizeCurrentPhoto(int zoom) {
        this.model.resizeCurrentPhoto(zoom);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String msg = evt.getPropertyName();
        if (msg == Album.MESSAGE_CHANGEMENT_IMAGE_COURANTE) {
            this.frame.setZoomValue(this.model.getCurrentPhoto().getZoom());
        } else {
        }
    }
}
