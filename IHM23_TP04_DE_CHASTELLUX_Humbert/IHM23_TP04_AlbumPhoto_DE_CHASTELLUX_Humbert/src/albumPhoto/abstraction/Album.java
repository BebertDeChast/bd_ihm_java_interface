package albumPhoto.abstraction;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
// Sur une idee de Cedric Dumas
import java.io.File;
import java.util.LinkedList;

public class Album {
	
	public static final String MESSAGE_CHANGEMENT_IMAGE_COURANTE = "Changement d'image courante";
	public static final String MESSAGE_CHANGEMENT_ZOOM           = "Changement du facteur de zoom";
	public static final String MESSAGE_NOUVELLE_IMAGE            = "Nouvelle image";

	private PropertyChangeSupport pcs; // propriete permettant de notifier des changements du modele

	private LinkedList<Photo> photos;
	private int currentIndex; // index de l image courante

	/**
	 * Initalise l'album en rajoutant les photos correspondantes a tous les fichiers du dossier repertoire
	 * @param repertoire le dossier contenant les photos de l'album
	 */
	public Album(String repertoire) {
		this.pcs = new PropertyChangeSupport(this);
		this.photos = new LinkedList<Photo>();
		File repImages = new File(repertoire);
		for (String s : repImages.list()) {
			this.addPhoto(repertoire+File.separator+s);
		}
		this.currentIndex = this.photos.size()-1;//0;
	}
	/**
	 * Retourne le nombre de photos dans l'album
	 * @return le nombre de photos dans l'album
	 */
	public int getSize() {
		return this.photos.size();
	}

	/**
	 * Ajoute une photo dans l'album
	 * @param fullpathname chemin complet du fichier
	 */
	public void addPhoto(String fullpathname) {
		this.photos.add(new Photo(fullpathname));
		this.pcs.firePropertyChange(MESSAGE_NOUVELLE_IMAGE, null, Integer.valueOf(this.photos.size() - 1));
	}

	/**
	 * Retourne la photo d'index i si i est dans [0, this.getSize()[. Sinon, retourne null.
	 * @return la photo d'index i si i est dans [0, this.getSize()[. Sinon, retourne null.
	 * @param i l'index de la photo a retourner
	 */
	public Photo getPhoto(int i) {
		if ((i < this.photos.size()) && (i >= 0)) {
			return this.photos.get(i);
		} else {
			return null;
		}
	}

	/**
	 * Retourne l'index de la photo courante de l'album
	 * @return l'index de la photo courante de l'album
	 */
	public int getCurrentIndex() {
		return this.currentIndex;
	}

	/**
	 * Modifie la photo courante
	 * @param cindex l'index de la photo qui devient la photo courante
	 */
	public void setCurrentIndex(int cindex) {
		if ((cindex < this.photos.size()) && (cindex >= 0)) {
			int previous = this.currentIndex;
			this.currentIndex = cindex;
			this.pcs.firePropertyChange(MESSAGE_CHANGEMENT_IMAGE_COURANTE, Integer.valueOf(previous), Integer.valueOf(cindex));
		}
	}

	/**
	 * Retourne la photo courante de l'album.
	 * @return la photo courante de l'album.
	 */
	public Photo getCurrentPhoto() {
		return this.photos.get(currentIndex);
	}

	/**
	 * redimensionne la photo courante de l'album avec zoom pour facteur de zoom.
	 *  @param zoom le facteur de zoom a appliquer a la photo courante
	 */
	public void resizeCurrentPhoto(int zoom) {
		int previous = this.getCurrentPhoto().getZoom();
		this.getCurrentPhoto().resize(zoom);
		this.pcs.firePropertyChange(MESSAGE_CHANGEMENT_ZOOM, previous, zoom);
	}

	public void addPropertyChangeListener(PropertyChangeListener l) {
		pcs.addPropertyChangeListener(MESSAGE_CHANGEMENT_IMAGE_COURANTE, l);
		pcs.addPropertyChangeListener(MESSAGE_CHANGEMENT_ZOOM, l);
		pcs.addPropertyChangeListener(MESSAGE_NOUVELLE_IMAGE, l);
	}

}
