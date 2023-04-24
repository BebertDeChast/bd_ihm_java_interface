package albumPhoto.presentation; // Sur une idee de Cedric Dumas
import java.awt.*;
import javax.swing.*;
import albumPhoto.abstraction.Album;

//  AlbumPhoto herite de JFrame et est donc une JFrame.
// On peut donc appeler toutes les methodes de JFrame sur this.
@SuppressWarnings("serial")
public class FrameAlbumPhoto extends JFrame {

	private Album model; // notre noyau applicatif : un album photo

	public FrameAlbumPhoto(Album album) {
		super("Album Photo");
		this.model = album;

        // param�trage de la JFrame
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Un BorderLayout pour gestionnaire de placement
		// La fenetre est organisee en 5 zones : NORTH, SOUTH, EAST, WEST et CENTER
		this.setLayout(new BorderLayout());

		this.buildCenterPanel();
		this.buildNorthPanel();
		this.buildMenu();
		this.pack();
	}

	private void buildCenterPanel() {
		JPanel centralPanel = new JPanel();
		centralPanel.setLayout(new FlowLayout());
		centralPanel.setPreferredSize(new Dimension(1024, 780));

		/** Question 1 : Initialisez l'etiquette centrale
		 *               avec l'image courante du modele  **/
		JLabel centralImage = new JLabel("Jolie photo" );

		centralPanel.add(centralImage);

		this.add(centralPanel, BorderLayout.CENTER);
	}

	private void buildNorthPanel() {

	}

	private void buildMenu() {

	}

}