package albumPhoto.control;

import albumPhoto.abstraction.Album;
import albumPhoto.presentation.FrameAlbumPhoto;

public class ControlNavigationButtons {
    private Album album;
    private FrameAlbumPhoto frame;

    public ControlNavigationButtons(Album album, FrameAlbumPhoto frame) {
        this.frame = frame;
        this.album = album;
    }

    public void goNext() {
        album.setCurrentIndex(album.getCurrentIndex() + 1);
        frame.actualiserPhoto();
    }

    public void goFirst() {
        album.setCurrentIndex(0);
        frame.actualiserPhoto();
    }

    public void goPrevious() {
        album.setCurrentIndex(album.getCurrentIndex() - 1);
        frame.actualiserPhoto();
    }

    public void goLast() {
        album.setCurrentIndex(album.getSize() - 1);
        frame.actualiserPhoto();
    }
}
