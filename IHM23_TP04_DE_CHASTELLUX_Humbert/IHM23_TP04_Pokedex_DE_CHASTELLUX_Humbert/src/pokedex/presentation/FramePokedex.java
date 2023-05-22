package pokedex.presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import pokedex.abstraction.Pokedex;
import pokedex.control.ControlButton;
import pokedex.control.ControlCentralImage;
import pokedex.control.ControlDescription;
import pokedex.control.ControlSearch;
import pokedex.control.ControlSlider;

public class FramePokedex extends JFrame {

	private static final long serialVersionUID = 1L;

	private Pokedex pokedex;
	private JLabel centralImage;
	private JButton buttonPrevious;
	private JButton buttonNext;
	private JButton searchButton;
	private Color color = new Color(255, 200, 1);
	private JSlider slider;
	private JLabel name;
	private JLabel id;
	private JLabel type;
	private JLabel type2;
	private JLabel life;
	private JLabel attack;
	private JLabel defense;
	private JLabel speed;
	private JLabel spattack;
	private JLabel spdefense;
	private JLabel generation;
	private ImageIcon nextTT = new ImageIcon("images" + File.separator + "divers" + File.separator + "next50.jpg");
	private ImageIcon previousTT = new ImageIcon("images" + File.separator + "divers" + File.separator + "prev50.jpg");
	private ImageIcon nextFF = new ImageIcon("images" + File.separator + "divers" + File.separator + "next50d.jpg");
	private ImageIcon previousFF = new ImageIcon("images" + File.separator + "divers" + File.separator + "prev50d.jpg");
	private ImageIcon gotoTT = new ImageIcon("images" + File.separator + "divers" + File.separator + "goto25p.jpg");
	private ImageIcon gotoFF = new ImageIcon("images" + File.separator + "divers" + File.separator + "goto25d.jpg");
	private ControlButton controlButton;

	public FramePokedex(Pokedex pokedex) {
		setTitle("POKEDEX");
		setIconImage(new ImageIcon("images" + File.separator + "divers" + File.separator + "pokeball.jpg").getImage());
		this.pokedex = pokedex;
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.getContentPane().setBackground(color);
		controlButton = new ControlButton(this.pokedex, this);

		@SuppressWarnings("unused")
		ControlDescription controlDescription = new ControlDescription(this.pokedex, this);

		this.setLayout(new BorderLayout());
		this.creerCentre();
		this.buildEastPanel();
		this.buildWestPanel();
		this.buildNorthPanel();
		this.buildSouthPanel();

		this.pack();
		this.setVisible(true);
	}

	public void creerCentre() {
		centralImage = new JLabel(new ImageIcon("images" + File.separator
				+ "moyennes" + File.separator
				+ pokedex.getCurrentPokemon().getNomen() + ".jpg"));
		new ControlCentralImage(pokedex, this);
		this.add(centralImage, BorderLayout.CENTER);
	}

	public void buildEastPanel() {
		this.buttonNext = new JButton(nextTT);
		this.buttonNext.setBackground(color);
		ListenerButtonNext listenerButtonNext = new ListenerButtonNext(controlButton);
		this.buttonNext.addActionListener(listenerButtonNext);

		this.add(buttonNext, BorderLayout.EAST);

	}

	public void buildWestPanel() {
		this.buttonPrevious = new JButton(previousFF);
		this.buttonPrevious.setBackground(color);
		ListenerButtonPrevious listenerButtonPrevious = new ListenerButtonPrevious(controlButton);
		this.buttonPrevious.addActionListener(listenerButtonPrevious);

		this.add(buttonPrevious, BorderLayout.WEST);

	}

	public void buildNorthPanel() {
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new BorderLayout());
		northPanel.setBackground(color);

		JLabel title = new JLabel(
				new ImageIcon("images" + File.separator + "divers" + File.separator + "pokemon500.jpg"));
		northPanel.add(title, BorderLayout.NORTH);

		searchButton = new JButton(gotoFF);
		searchButton.setBorder(null);
		northPanel.add(searchButton, BorderLayout.WEST);

		JTextField searchField = new JTextField();
		northPanel.add(searchField, BorderLayout.CENTER);
		ControlSearch controlSearch = new ControlSearch(pokedex, this);
		ListenerTextField listenerTextField = new ListenerTextField(controlSearch, searchField);
		ListenerSearch listenerSearch = new ListenerSearch(controlSearch, searchField);
		searchButton.addActionListener(listenerSearch);
		searchField.addCaretListener(listenerTextField);

		this.add(northPanel, BorderLayout.NORTH);
	}

	public void buildSouthPanel() {
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new BorderLayout());
		southPanel.setBackground(color);
		Integer hspace = 2;
		Integer vspace = 10;

		slider = new JSlider(JSlider.HORIZONTAL, 1, pokedex.size(), 1);
		slider.setMajorTickSpacing(100);
		slider.setMinorTickSpacing(10);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		southPanel.add(slider, BorderLayout.SOUTH);
		ControlSlider controlSlider = new ControlSlider(pokedex, this);
		ListenerSlider listenerSlider = new ListenerSlider(controlSlider);
		slider.addChangeListener(listenerSlider);

		JPanel mainTextpanel = new JPanel();
		mainTextpanel.setLayout(new BoxLayout(mainTextpanel, BoxLayout.Y_AXIS));
		mainTextpanel.setBackground(color);

		name = new JLabel(pokedex.getCurrentPokemon().getNomfr());
		mainTextpanel.add(name);

		id = new JLabel("ID : " + pokedex.getCurrentPokemon().getId());
		mainTextpanel.add(id);

		JPanel typePanel = new JPanel();
		typePanel.setLayout(new BoxLayout(typePanel, BoxLayout.X_AXIS));
		typePanel.setBackground(color);

		type = new JLabel("Type Pr. : " + pokedex.getCurrentPokemon().getTypep());
		type.setBorder(new EmptyBorder(0, vspace, 0, vspace));
		typePanel.add(type);

		type2 = new JLabel("Type Sec. : " + pokedex.getCurrentPokemon().getTypes());
		type2.setBorder(new EmptyBorder(0, vspace, 0, vspace));
		typePanel.add(type2);

		mainTextpanel.add(typePanel);

		life = new JLabel("Pv : " + pokedex.getCurrentPokemon().getPv());
		mainTextpanel.add(life);

		JPanel statContainer = new JPanel();
		statContainer.setLayout(new BoxLayout(statContainer, BoxLayout.X_AXIS));
		statContainer.setBackground(color);

		JPanel statPanelLeft = new JPanel();
		statPanelLeft.setLayout(new BoxLayout(statPanelLeft, BoxLayout.Y_AXIS));
		statPanelLeft.setBackground(color);

		
		attack = new JLabel("Attaque : " + pokedex.getCurrentPokemon().getAttaque());
		attack.setBorder(new EmptyBorder(hspace, vspace, hspace, vspace));
		statPanelLeft.add(attack);
		defense = new JLabel("Defense : " + pokedex.getCurrentPokemon().getDefense());
		defense.setBorder(new EmptyBorder(hspace, vspace, hspace, vspace));
		statPanelLeft.add(defense);
		speed = new JLabel("Vitesse : " + pokedex.getCurrentPokemon().getVitesse());
		speed.setBorder(new EmptyBorder(hspace, vspace, hspace, vspace));
		statPanelLeft.add(speed);

		JPanel statPanelRight = new JPanel();
		statPanelRight.setLayout(new BoxLayout(statPanelRight, BoxLayout.Y_AXIS));
		statPanelRight.setBackground(color);

		spattack = new JLabel("Attaque Sp. : " + pokedex.getCurrentPokemon().getAttspe());
		spattack.setBorder(new EmptyBorder(hspace, vspace, hspace, vspace));
		statPanelRight.add(spattack);
		spdefense = new JLabel("Defense Sp. : " + pokedex.getCurrentPokemon().getDefspe());
		spdefense.setBorder(new EmptyBorder(hspace, vspace, hspace, vspace));
		statPanelRight.add(spdefense);
		generation = new JLabel("Generation : " + pokedex.getCurrentPokemon().getGeneration());
		generation.setBorder(new EmptyBorder(hspace, vspace, hspace, vspace));
		statPanelRight.add(generation);

		statContainer.add(statPanelLeft);
		statContainer.add(statPanelRight);
		mainTextpanel.add(statContainer);

		southPanel.add(mainTextpanel, BorderLayout.CENTER);
		this.add(southPanel, BorderLayout.SOUTH);
	}

	/**
	 * Vous n'etes pas tenus d'utiliser cette methode. Elle est fournie
	 * uniquement dans le cas ou vous souhaiteriez obtenir une version
	 * redimensionnee d'une image.
	 * 
	 * @param filename, le chemin et le nom du fichier contenant l'image
	 * @param largeur
	 * @param hauteur
	 * @return Retourne une ImageIcon de dimension lageur x hauteur de
	 *         l'image du fichier filename
	 */
	public ImageIcon getImage(String filename, int largeur, int hauteur) {
		ImageIcon originale = new ImageIcon(filename);
		int width = originale.getIconWidth();
		int height = originale.getIconHeight();
		double ratio = Math.min((1.0 * largeur) / width, (1.0 * hauteur) / height);
		int largeurIcone = (int) (width * ratio);
		int hauteurIcone = (int) (height * ratio);
		BufferedImage buf = new BufferedImage(largeur, hauteur, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = buf.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.drawImage(originale.getImage(), (largeur - largeurIcone) / 2, (hauteur - hauteurIcone) / 2, largeurIcone,
				hauteurIcone, null);
		g.dispose();
		return (new ImageIcon(buf));
	}

	public void setCentralImageIcon(String filename) {
		ImageIcon originale = new ImageIcon(filename);
		this.centralImage.setIcon(originale);
		this.centralImage.repaint();
	}

	public void setButtonPreviousEnabled(boolean b) {
		if (b) {
			this.buttonPrevious.setIcon(previousTT);
		} else {
			this.buttonPrevious.setIcon(previousFF);
		}
	}

	public void setButtonNextEnabled(boolean b) {
		if (b) {
			this.buttonNext.setIcon(nextTT);
		} else {
			this.buttonNext.setIcon(nextFF);
		}
	}

	public void updateDescription() {
		this.name.setText(pokedex.getCurrentPokemon().getNomfr());
		this.id.setText("ID : " + pokedex.getCurrentPokemon().getId());
		this.type.setText("Type Pr. : " + pokedex.getCurrentPokemon().getTypep());
		this.type2.setText("Type Sec. : " + pokedex.getCurrentPokemon().getTypes());
		this.life.setText("Pv : " + pokedex.getCurrentPokemon().getPv());
		this.attack.setText("Attaque : " + pokedex.getCurrentPokemon().getAttaque());
		this.defense.setText("Defense : " + pokedex.getCurrentPokemon().getDefense());
		this.speed.setText("Vitesse : " + pokedex.getCurrentPokemon().getVitesse());
		this.spattack.setText("Attaque Sp. : " + pokedex.getCurrentPokemon().getAttspe());
		this.spdefense.setText("Defense Sp. : " + pokedex.getCurrentPokemon().getDefspe());
		this.generation.setText("Generation : " + pokedex.getCurrentPokemon().getGeneration());
	}

	public void updateSlider(Integer value) {
		this.slider.setValue(value);
	}

	public void activateSearchButton() {
		this.searchButton.setIcon(gotoTT);
	}

	public void desactivateSearchButton() {
		this.searchButton.setIcon(gotoFF);
	}
}
