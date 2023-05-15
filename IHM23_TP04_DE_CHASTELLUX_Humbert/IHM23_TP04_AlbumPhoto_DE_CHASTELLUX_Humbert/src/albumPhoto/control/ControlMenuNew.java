package albumPhoto.control;
import albumPhoto.abstraction.Album;

public class ControlMenuNew {
	private Album modele; 

	public ControlMenuNew( Album modele) {
		this.modele = modele; 
	}

	public void addPhoto(String path) {
		this.modele.addPhoto(path);
	}
}
