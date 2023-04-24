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

		/**
		 * Question 1 : Initialisez l'etiquette centrale
		 * avec l'image courante du modele
		 **/
		JLabel centralImage = new JLabel(this.model.getCurrentPhoto());

		centralPanel.add(centralImage);

		this.add(centralPanel, BorderLayout.CENTER);
	}

	private void buildNorthPanel() {
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));

		JLabel title = new JLabel(this.model.getCurrentPhoto().getName());
		title.setPreferredSize(new Dimension(500, 20));
		title.setHorizontalAlignment(JLabel.CENTER);

		// creation des boutons gauche
		JButton left_first_Button = new JButton("premiere");
		JButton left_back_Button = new JButton("< precedente");
		JPanel leftnorthJPanel = new JPanel();
		leftnorthJPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
		leftnorthJPanel.add(left_first_Button);
		leftnorthJPanel.add(left_back_Button);

		northPanel.add(leftnorthJPanel);
		northPanel.add(title);

		// creation des boutons droite
		JButton right_next_Button = new JButton("suivante >");
		JButton right_last_Button = new JButton("derniere");
		JPanel rightnorthJPanel = new JPanel();
		rightnorthJPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
		rightnorthJPanel.add(right_next_Button);
		rightnorthJPanel.add(right_last_Button);

		northPanel.add(rightnorthJPanel);

		this.add(northPanel, BorderLayout.NORTH);

	}

	private void buildMenu() {

	}

}