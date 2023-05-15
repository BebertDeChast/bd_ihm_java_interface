package albumPhoto.main;

import albumPhoto.abstraction.Album;
import albumPhoto.presentation.FrameAlbumPhoto;

public class MainAlbumPhoto {
	public static void main(String[] args) {
			Album album = new Album("images");
			FrameAlbumPhoto fen = new FrameAlbumPhoto(album);
			fen.setVisible(true);
	}
}
