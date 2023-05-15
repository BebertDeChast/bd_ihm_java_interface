package pokedex.presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import pokedex.abstraction.Pokedex;
import pokedex.control.ControlCentralImage;


public class FramePokedex extends JFrame {

	private static final long serialVersionUID = 1L;

	private Pokedex pokedex;
	private JLabel centralImage;

	public FramePokedex(Pokedex pokedex) {
		setTitle("POKEDEX");
		setIconImage(new ImageIcon("images"+File.separator+"divers"+File.separator+"pokeball.jpg").getImage());
		this.pokedex = pokedex;
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.getContentPane().setBackground(new Color(255,200,0));		
		
		this.setLayout(new BorderLayout());
		this.creerCentre();
		
		this.pack();
		this.setVisible(true);		
	}

	public void creerCentre() {
		centralImage = new JLabel(new ImageIcon("images"+File.separator
				+"moyennes"+File.separator
				+pokedex.getCurrentPokemon().getNomen()+".jpg"));
		new ControlCentralImage(pokedex, this);
		this.add(centralImage, BorderLayout.CENTER);
	}
	
	/**
	 * Vous n'etes pas tenus d'utiliser cette methode. Elle est fournie
	 * uniquement dans le cas ou vous souhaiteriez obtenir une version
	 * redimensionnee d'une image.
	 * @param filename, le chemin et le nom du fichier contenant l'image
	 * @param largeur
	 * @param hauteur
	 * @return Retourne une ImageIcon de dimension lageur x hauteur de
	 * l'image du fichier filename
	 */
	public ImageIcon getImage(String filename, int largeur, int hauteur) {
		ImageIcon originale = new ImageIcon(filename);
		int width = originale.getIconWidth();
		int height= originale.getIconHeight();
		double ratio = Math.min((1.0*largeur)/width, (1.0*hauteur)/height);
		int largeurIcone = (int) (width*ratio);
		int hauteurIcone = (int) (height*ratio);
		BufferedImage buf = new BufferedImage(largeur, hauteur,	BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = buf.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.drawImage( originale.getImage(), (largeur-largeurIcone)/2, (hauteur-hauteurIcone)/2, largeurIcone, hauteurIcone, null);
		g.dispose();
		return (new ImageIcon(buf));
	}

	public void setCentralImageIcon(String filename) {
		ImageIcon originale = new ImageIcon(filename);
		this.centralImage.setIcon(originale);
		this.centralImage.repaint();
	}
}
