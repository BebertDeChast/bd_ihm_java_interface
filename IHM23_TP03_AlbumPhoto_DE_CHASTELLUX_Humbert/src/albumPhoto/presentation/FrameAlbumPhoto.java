package albumPhoto.presentation;

// Sur une idee de Cedric Dumas
import java.awt.*;
import java.util.Hashtable;
import java.util.LinkedList;

import javax.swing.*;
import albumPhoto.abstraction.Album;
import albumPhoto.control.ControlCentralImage;
import albumPhoto.control.ControlList;
import albumPhoto.control.ControlMenuNew;
import albumPhoto.control.ControlMenuQuit;
import albumPhoto.control.ControlNavigationButtons;
import albumPhoto.control.ControlPhotoName;
import albumPhoto.control.ControlThumbnails;
import albumPhoto.control.ControlZoom;

//  AlbumPhoto herite de JFrame et est donc une JFrame.
// On peut donc appeler toutes les methodes de JFrame sur this.
@SuppressWarnings("serial")
public class FrameAlbumPhoto extends JFrame {

	private Album model; // notre noyau applicatif : un album photo
	private JLabel centralImage;;
	private JLabel photoName;
	private JButton buttonFirst;
	private JButton buttonPrevious;
	private JButton buttonNext;
	private JButton buttonLast;
	private JList<String> list;
	private JSlider slider;
	private LinkedList<JLabel> thumbnails;
	private JPanel southPanel;
	private ControlThumbnails cThumbnails;

	public FrameAlbumPhoto(Album album) {
		super("Album Photo");
		this.model = album;
		this.thumbnails = new LinkedList<JLabel>();
		this.cThumbnails = new ControlThumbnails(this.model, this);

		// parametrage de la JFrame
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Un BorderLayout pour gestionnaire de placement
		// La fenetre est organisee en 5 zones : NORTH, SOUTH, EAST, WEST et CENTER
		this.setLayout(new BorderLayout());

		this.buildCenterPanel();
		this.buildNorthPanel();
		this.buildMenu();
		this.buildWestPanel();
		this.buildEastPanel();
		this.buildSouthPanel();
		this.pack();
	}

	private void buildCenterPanel() {
		JPanel centralPanel = new JPanel();
		centralPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		centralPanel.setPreferredSize(new Dimension(1024, 780));

		this.centralImage = new JLabel(this.model.getCurrentPhoto());

		centralPanel.add(centralImage);

		@SuppressWarnings("unused")
		ControlCentralImage cCentralImage = new ControlCentralImage(model, this);

		this.add(centralPanel, BorderLayout.CENTER);
	}

	private void buildNorthPanel() {
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout());// FlowLayout.CENTER, 50, 10));

		this.buttonFirst = new JButton("premiere");
		this.buttonFirst.setEnabled(model.getCurrentIndex() > 0);
		northPanel.add(buttonFirst);

		this.buttonPrevious = new JButton("<- precedente");
		this.buttonPrevious.setEnabled(model.getCurrentIndex() > 0);
		northPanel.add(buttonPrevious);

		JPanel pName = new JPanel();
		this.photoName = new JLabel(this.model.getCurrentPhoto().getName());
		pName.setPreferredSize(new Dimension(150, 24));
		pName.add(this.photoName);
		northPanel.add(pName);
		@SuppressWarnings("unused")
		ControlPhotoName cPhotoName = new ControlPhotoName(this.model, this);

		this.buttonNext = new JButton("suivante ->");
		this.buttonNext.setEnabled(this.model.getCurrentIndex() < this.model.getSize() - 1);
		northPanel.add(this.buttonNext);

		this.buttonLast = new JButton("derniere");
		this.buttonLast.setEnabled(this.model.getCurrentIndex() < this.model.getSize() - 1);
		northPanel.add(this.buttonLast);

		ControlNavigationButtons cNavigationButtons = new ControlNavigationButtons(this.model, this);
		this.buttonFirst.addActionListener(new ListenerButtonFirst(cNavigationButtons));
		this.buttonPrevious.addActionListener(new ListenerButtonPrevious(cNavigationButtons));
		this.buttonNext.addActionListener(new ListenerButtonNext(cNavigationButtons));
		this.buttonLast.addActionListener(new ListenerButtonLast(cNavigationButtons));
		this.add(northPanel, BorderLayout.NORTH);
	}

	private void buildMenu() {
		JMenuBar jmb = new JMenuBar();
		this.setJMenuBar(jmb);
		JMenu mfile = new JMenu("Fichier");
		jmb.add(mfile);
		JMenuItem addImage = new JMenuItem("Ajouter une image");
		ControlMenuNew cMenuNew = new ControlMenuNew(this.model, this);
		addImage.addActionListener(new ListenerMenuNew(cMenuNew));
		mfile.add(addImage);

		mfile.addSeparator();
		JMenuItem quitter = new JMenuItem("Quitter");
		mfile.add(quitter);

		ControlMenuQuit cMenuQuit = new ControlMenuQuit();
		quitter.addActionListener(new ListenerMenuQuit(cMenuQuit));
	}

	public void setButtonFirstEnabled(boolean b) {
		this.buttonFirst.setEnabled(b);
	}

	public void setButtonPreviousEnabled(boolean b) {
		this.buttonPrevious.setEnabled(b);
	}

	public void setButtonNextEnabled(boolean b) {
		this.buttonNext.setEnabled(b);
	}

	public void setButtonLastEnabled(boolean b) {
		this.buttonLast.setEnabled(b);
	}

	public void setCentralImageIcon(ImageIcon i) {
		this.centralImage.setIcon(i);
		this.centralImage.repaint();
	}

	public void setPhotoNameText(String s) {
		this.photoName.setText(s);
	}

	public void resizeCentralImage(Dimension d) {
		this.centralImage.setSize(d);
		this.centralImage.repaint();
	}

	public void buildWestPanel() {
		JPanel westPanel = new JPanel();
		westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
		westPanel.setBorder(BorderFactory.createEmptyBorder(1, 5, 1, 5));

		DefaultListModel<String> listModel = new DefaultListModel<String>();
		for (int i = 0; i < this.model.getSize(); i++) {
			listModel.addElement(this.model.getPhoto(i).getName());
		}
		this.list = new JList<String>(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);

		list.setSelectedIndex(0);
		JScrollPane listScroller = new JScrollPane(list);
		westPanel.add(listScroller);
		ControlList cList = new ControlList(this.model, this);
		ListenerList cListenerList = new ListenerList(cList);
		list.addListSelectionListener(cListenerList);

		this.add(westPanel, BorderLayout.WEST);

	}

	public void setListSelectedIndex(int i) {
		this.list.setSelectedIndex(i);
	}

	public void addToList(String name) {
		DefaultListModel<String> listModel = (DefaultListModel<String>) this.list.getModel();
		listModel.addElement(name);
	}

	public void buildEastPanel() {
		JPanel eastPanel = new JPanel();
		eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
		eastPanel.setBorder(BorderFactory.createEmptyBorder(1, 5, 1, 5));

		this.slider = new JSlider(JSlider.VERTICAL, 0, 300, 100);
		slider.setMajorTickSpacing(100);
		slider.setMinorTickSpacing(10);
		slider.setPaintTicks(true);
		Hashtable<Integer, JLabel> etiquettes = new Hashtable<Integer, JLabel>();
		etiquettes.put(Integer.valueOf(0), new JLabel("0"));
		etiquettes.put(Integer.valueOf(100), new JLabel("100"));
		etiquettes.put(Integer.valueOf(200), new JLabel("200"));
		etiquettes.put(Integer.valueOf(300), new JLabel("300"));
		slider.setLabelTable(etiquettes); // on précise les étiquettes
		slider.setPaintLabels(true); // on affiche les etiquettes
		eastPanel.add(this.slider);
		ControlZoom cZoom = new ControlZoom(this.model, this);
		ListenerZoom cListenerZoom = new ListenerZoom(cZoom);
		slider.addChangeListener(cListenerZoom);

		this.add(eastPanel, BorderLayout.EAST);

	}

	public void setZoomValue(int zoom) {
		this.slider.setValue(zoom);
	}

	public void buildSouthPanel() {
		this.southPanel = new JPanel();
		southPanel.setLayout(new FlowLayout());

		for (int i = 0; i < this.model.getSize(); i++) {
			JLabel label = new JLabel(this.model.getPhoto(i).getIcon());
			label.setBorder(BorderFactory.createEmptyBorder(1, 5, 1, 5));
			ListenerThumbnails cListenerThumbnails = new ListenerThumbnails(cThumbnails, i);
			label.addMouseListener(cListenerThumbnails);
			thumbnails.add(label);
			southPanel.add(label);
		}

		this.add(new JScrollPane(southPanel), BorderLayout.SOUTH);
	}

	public void setThumbnailsSelectedIndex(int index) {
		for (int i = 0; i < thumbnails.size(); i++) {
			if (i == index) {
				thumbnails.get(index).setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
			} else {
				thumbnails.get(i).setBorder(BorderFactory.createEmptyBorder(1, 5, 1, 5));
			}
		}
	}

	public void addThumbnail() {
		JLabel label = new JLabel(this.model.getPhoto(this.model.getSize() - 1).getIcon());
		label.setBorder(BorderFactory.createEmptyBorder(1, 5, 1, 5));
		ListenerThumbnails listenerThumbnail = new ListenerThumbnails(cThumbnails, this.model.getSize() - 1);
		label.addMouseListener(listenerThumbnail);

		thumbnails.add(label);
		southPanel.add(label);
		southPanel.repaint();
	}
}