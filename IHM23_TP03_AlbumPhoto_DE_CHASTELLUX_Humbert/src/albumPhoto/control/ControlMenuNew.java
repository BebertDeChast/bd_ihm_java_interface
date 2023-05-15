package albumPhoto.control;
import albumPhoto.abstraction.Album;
import albumPhoto.presentation.FrameAlbumPhoto;

public class ControlMenuNew {
	private Album modele; 

	public ControlMenuNew( Album modele,  FrameAlbumPhoto frame) {
		this.modele = modele; 
	}

	public void addPhoto(String path) {
		this.modele.addPhoto(path);
	}
}
