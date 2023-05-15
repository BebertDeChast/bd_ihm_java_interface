package albumPhoto.main;

import albumPhoto.abstraction.Album;
import albumPhoto.control.Control;
import albumPhoto.presentation.FrameAlbumPhoto;

public class MainAlbumPhoto {
	public static void main(String[] args) {
			Album album = new Album("images");
			Control control = new Control(album);
			FrameAlbumPhoto fen = new FrameAlbumPhoto(control);
			control.connectPresentation(fen);
			fen.setVisible(true);
			album.setCurrentIndex(0);
	}
}
