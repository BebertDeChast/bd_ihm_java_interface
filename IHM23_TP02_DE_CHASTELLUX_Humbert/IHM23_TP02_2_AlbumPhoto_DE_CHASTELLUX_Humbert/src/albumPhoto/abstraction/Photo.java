package albumPhoto.abstraction;
// Sur une idee de Cedric Dumas
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import javax.swing.ImageIcon;

public class Photo extends ImageIcon {
	private static final long serialVersionUID = 1L;
	// Constantes
	private final double ZOOM_MIN = 0.1;
	private final double ZOOM_MAX = 5.0;
	private final int ICON_HEIGHT = 70;
	
	// Variables d'instance
	private int initialWidth;
	private int initialHeight;
	private Image image;
	private double zoom;
	private String name;

	/**
	 * Constructeur initialisant la photo afin qu'elle corresponde a l'image a l'emplacement filename
	 * @param filename chemin complet du fichier image
	 */
	public Photo(String filename) {
		super(filename);
		this.initialWidth = this.getIconWidth();
		this.initialHeight = this.getIconHeight();
		this.image = this.getImage();
		this.zoom = 1.0f;
		this.name = (new File(filename)).getName();
		this.name = this.name.substring(0, this.name.length() - 4);
	}

	/**
	 * Retourne les dimensions de la photo
	 * @return les dimensions de la photo.
	 */
	public Dimension getSize() {
		return new Dimension(this.getIconWidth(), this.getIconHeight());
	}

	/**
	 * Retourne le facteur de zoom
	 * @return le facteur de zoom
	 */
	public int getZoom() {
		return ((int) (this.zoom * 100));
	}

	/**
	 * Retourne le nom de la photo
	 *  @return le nom de la photo
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Retourne une icone de la photo de dimension maximale ICON_SIZE
	 *  @return une icone de la photo de dimension maximale ICON_SIZE
	 */
	public ImageIcon getIcon() {
		int width = (int) (ICON_HEIGHT * (this.initialWidth/(double)this.initialHeight));
		BufferedImage buf = new BufferedImage(width, (int)ICON_HEIGHT,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = buf.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.drawImage(this.image, 0, 0, width,(int)ICON_HEIGHT,null);
		g.dispose();
		return (new ImageIcon(buf));
	}

	/**
	 * Redimensionne la photo en lui appliquant le facteur de zoom passe en parametre.
	 * @param zoom facteur de zoom du redimensionnement.
	 */
	public void resize(int zoom) 	{
		this.zoom = Math.min(Math.max(zoom/100.0 , ZOOM_MIN), ZOOM_MAX);

		int width = (int) (initialWidth * this.zoom);
		int height = (int) (initialHeight * this.zoom);
		BufferedImage buf = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

		Graphics2D g = buf.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.drawImage(this.image, 0, 0, width, height, null);
		g.dispose();

		this.setImage(buf);
	}
}