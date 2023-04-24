package albumPhoto.main;

import albumPhoto.abstraction.Album;
import albumPhoto.presentation.FrameAlbumPhoto;

public class MainAlbumPhoto {
	public static void main(String[] args) {
		Album album = new Album(
				"IHM23_TP01_DE_CHASTELLUX_Humbert_packages/IHM23_TP01_2_AlbumPhoto_DE_CHASTELLUX_Humbert/images");
		FrameAlbumPhoto fen = new FrameAlbumPhoto(album);
		fen.setVisible(true);
	}
}
