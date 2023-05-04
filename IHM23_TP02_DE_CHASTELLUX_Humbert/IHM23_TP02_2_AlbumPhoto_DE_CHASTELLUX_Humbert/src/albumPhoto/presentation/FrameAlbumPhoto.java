package albumPhoto.presentation;

// Sur une idee de Cedric Dumas
import java.awt.*;
import javax.swing.*;
import albumPhoto.abstraction.Album;
import albumPhoto.control.ControlMenuButtons;
import albumPhoto.control.ControlNavigationButtons;

//  AlbumPhoto herite de JFrame et est donc une JFrame.
// On peut donc appeler toutes les methodes de JFrame sur this.
@SuppressWarnings("serial")
public class FrameAlbumPhoto extends JFrame {

	private Album model; // notre noyau applicatif : un album photo
	private JLabel centerPhoto;
	private JLabel photoName;
	private JButton buttonFirst;
	private JButton buttonPrevious;
	private JButton buttonNext;
	private JButton buttonLast;

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

		this.centerPhoto = new JLabel(this.model.getCurrentPhoto());

		centralPanel.add(centerPhoto);

		this.add(centralPanel, BorderLayout.CENTER);

	}

	private void buildNorthPanel() {
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout());

		ControlNavigationButtons control = new ControlNavigationButtons(this.model, this);

		this.buttonFirst = new JButton("premiere");
		this.buttonFirst.setEnabled(model.getCurrentIndex() > 0);
		northPanel.add(buttonFirst);
		ListenerButtonFirst listenerfirst = new ListenerButtonFirst(control);
		this.buttonFirst.addActionListener(listenerfirst);

		this.buttonPrevious = new JButton("<- precedente");
		this.buttonPrevious.setEnabled(model.getCurrentIndex() > 0);
		northPanel.add(buttonPrevious);
		ListenerButtonPrevious listenerprevious = new ListenerButtonPrevious(control);
		this.buttonPrevious.addActionListener(listenerprevious);

		JPanel pName = new JPanel();
		this.photoName = new JLabel(this.model.getCurrentPhoto().getName());
		pName.setPreferredSize(new Dimension(150, 24));
		pName.add(this.photoName);
		northPanel.add(pName);

		this.buttonNext = new JButton("suivante ->");
		this.buttonNext.setEnabled(this.model.getCurrentIndex() < this.model.getSize() - 1);
		northPanel.add(this.buttonNext);
		ListenerButtonNext listenernext = new ListenerButtonNext(control);
		this.buttonNext.addActionListener(listenernext);

		this.buttonLast = new JButton("derniere");
		this.buttonLast.setEnabled(this.model.getCurrentIndex() < this.model.getSize() - 1);
		northPanel.add(this.buttonLast);
		ListenerButtonLast listenerlast = new ListenerButtonLast(control);
		this.buttonLast.addActionListener(listenerlast);

		this.add(northPanel, BorderLayout.NORTH);
	}

	private void buildMenu() {
		JMenuBar jmb = new JMenuBar();
		this.setJMenuBar(jmb);
		JMenu mfile = new JMenu("Fichier");
		jmb.add(mfile);
		ControlMenuButtons control = new ControlMenuButtons(this.model);

		JMenuItem addImage = new JMenuItem("Ajouter une image");
		mfile.add(addImage);
		ListenerAddImage listeneraddimage = new ListenerAddImage(control);
		addImage.addActionListener(listeneraddimage);

		mfile.addSeparator();
		JMenuItem quitter = new JMenuItem("Quitter");
		mfile.add(quitter);
		ListenerQuit listenerquit = new ListenerQuit(control);
		quitter.addActionListener(listenerquit);
	}

	public void actualiserPhoto() {
		this.centerPhoto.setIcon(this.model.getCurrentPhoto());
		this.photoName.setText(this.model.getCurrentPhoto().getName());
		this.buttonFirst.setEnabled(model.getCurrentIndex() > 0);
		this.buttonPrevious.setEnabled(model.getCurrentIndex() > 0);
		this.buttonNext.setEnabled(this.model.getCurrentIndex() < this.model.getSize() - 1);
		this.buttonLast.setEnabled(this.model.getCurrentIndex() < this.model.getSize() - 1);
	}

}