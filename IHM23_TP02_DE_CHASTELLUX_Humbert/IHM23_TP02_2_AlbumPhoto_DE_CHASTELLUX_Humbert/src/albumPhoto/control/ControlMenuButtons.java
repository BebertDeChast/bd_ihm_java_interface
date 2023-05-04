package albumPhoto.control;

import albumPhoto.abstraction.Album;

public class ControlMenuButtons {
    private Album album;

    public ControlMenuButtons(Album album) {
        this.album = album;
    }

    public void quit() {
        System.exit(0);
    }

    public void addImage(String path) {
        album.addPhoto(path);
    }

}
