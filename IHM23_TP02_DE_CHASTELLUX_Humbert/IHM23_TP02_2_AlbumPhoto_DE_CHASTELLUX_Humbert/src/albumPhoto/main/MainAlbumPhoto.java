package albumPhoto.main;

import albumPhoto.abstraction.Album;
import albumPhoto.presentation.FrameAlbumPhoto;

public class MainAlbumPhoto {
	public static void main(String[] args) {
			Album album = new Album("IHM23_TP02_2_AlbumPhoto_DE_CHASTELLUX_Humbert/images");
			album.setCurrentIndex(0);
			FrameAlbumPhoto fen = new FrameAlbumPhoto(album);
			fen.setVisible(true);
			
	}
}
