package albumPhoto.presentation;
// Sur une idee de Cedric Dumas
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

import javax.swing.*;
import albumPhoto.control.Control;
import albumPhoto.control.ControlList;
import albumPhoto.control.ControlMenuNew;
import albumPhoto.control.ControlMenuQuit;
import albumPhoto.control.ControlNavigationButtons;
import albumPhoto.control.ControlThumbnails;
import albumPhoto.control.ControlZoom;


// FrameAlbumPhotoAlbumPhoto herite de JFrame et est donc une JFrame.
// On peut donc appeler toutes les methodes de JFrame sur this.
@SuppressWarnings("serial")
public class FrameAlbumPhoto extends JFrame {

	private JLabel 	centralImage;

	private Control control;
	private JLabel photoName;
	private JButton buttonFirst;
	private JButton buttonPrevious;
	private JButton buttonNext;
	private JButton buttonLast;
	private JList<String> list;
	private JSlider slider;
	private JPanel southPanel;
	private List<JLabel> thumbnails;
	private ControlThumbnails cThumbnails;
	
	public FrameAlbumPhoto(Control control) {//Album album) {
		super("Album Photo");
		this.control=control;

        // parametrage de la JFrame
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Un BorderLayout pour gestionnaire de placement
		// La fenetre est organisee en 5 zones : NORTH, SOUTH, EAST, WEST et CENTER
		this.setLayout(new BorderLayout());

		this.buildCenterPanel();
		this.buildNorthPanel();
		this.buildWestPanel();
		this.buildEastPanel();
		this.buildSouthPanel();
		this.buildMenu();
		this.pack();
	}

	private void buildCenterPanel() {
		JPanel centralPanel = new JPanel();
		centralPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		centralPanel.setPreferredSize(new Dimension(1024, 780));
		this.centralImage = new JLabel();
		centralPanel.add(centralImage);
		this.add(centralPanel, BorderLayout.CENTER);
	}

	private void buildNorthPanel() {
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout());//FlowLayout.CENTER, 50, 10));

		ControlNavigationButtons cNavigationButtons=this.control.getControlButtons();

		this.buttonFirst = new JButton("premiere");
		this.buttonFirst.addActionListener(new ListenerButtonFirst(cNavigationButtons)); 
		northPanel.add(buttonFirst);
		
		this.buttonPrevious = new JButton("<- precedente");
		this.buttonPrevious.addActionListener(new ListenerButtonPrevious(cNavigationButtons));
		northPanel.add(buttonPrevious);

		JPanel pName = new JPanel();
		this.photoName = new JLabel();
		pName.setPreferredSize(new Dimension(150, 24));
		pName.add(this.photoName);
		northPanel.add(pName);
		
		this.buttonNext = new JButton("suivante ->");
		this.buttonNext.addActionListener(new ListenerButtonNext(cNavigationButtons)); 
		northPanel.add(this.buttonNext);

		this.buttonLast = new JButton("derniere");
		this.buttonLast.addActionListener(new ListenerButtonLast(cNavigationButtons)); 
		northPanel.add(this.buttonLast);
		
		this.add(northPanel,BorderLayout.NORTH);
	}

	private void buildWestPanel() {
		JPanel panelWest = new JPanel();
		panelWest.setLayout(new BorderLayout());

		List<String> names = this.control.getControlList().getNames();
		
		DefaultListModel<String> lm = new DefaultListModel<String>();
		for (String name : names) {
			lm.addElement(name);
		}
		this.list = new JList<String>(lm);
		this.list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		ControlList cList = this.control.getControlList();
		ListenerList listenerList = new ListenerList(cList);
		this.list.addListSelectionListener(listenerList);
		panelWest.add(new JScrollPane(this.list), BorderLayout.CENTER);
	

		this.add(panelWest, BorderLayout.WEST);
	}

	private void buildEastPanel() {
		this.slider = new JSlider(JSlider.VERTICAL, 0, 300, 100); 
		this.slider.setMajorTickSpacing(100); // espace (en unite) entre les tirets principaux
		this.slider.setMinorTickSpacing(10); // espace (en unite) entre les petits tirets
		this.slider.setPaintTicks(true); // active l affichage des tirets sur le slider
		this.slider.setPaintLabels(true); // active l affichage des valeurs des unites sur les tirets principaux

		ControlZoom cZoom = this.control.getControlZoom();
		ListenerZoom listenerZoom = new ListenerZoom(cZoom);
		slider.addChangeListener(listenerZoom);
		this.add(slider, BorderLayout.EAST);
	}
	
	private void buildSouthPanel() {
		this.southPanel = new JPanel();
		this.thumbnails = new LinkedList<JLabel>();

		this.cThumbnails = this.control.getControlThumbnails();
		List<ImageIcon> images = this.cThumbnails.getIcons();

		for (int i=0; i<images.size(); i++) {
			JLabel thumbnail = new JLabel();
			thumbnail.setIcon(images.get(i));
			ListenerThumbnail listenerThumbnail=new ListenerThumbnail(this.cThumbnails, i);
			thumbnail.addMouseListener(listenerThumbnail);
			thumbnail.setBorder(null);
			southPanel.add(thumbnail);
			this.thumbnails.add(thumbnail);
		}
		this.add(southPanel, BorderLayout.SOUTH);
	}

	private void buildMenu() {
		JMenuBar jmb = new JMenuBar();
		this.setJMenuBar(jmb);
		JMenu mfile = new JMenu("Fichier");
		jmb.add(mfile);
		JMenuItem addImage = new JMenuItem("Ajouter une image");
		ControlMenuNew cMenuNew = this.control.getControlMenuNew();
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
	public void setListSelectedIndex(int index) {
		this.list.setSelectedIndex(index);
	}
	public void addToList(String name) {
		ListModel<String> m = this.list.getModel();
		DefaultListModel<String> dm = ((DefaultListModel<String>)m);
		dm.addElement(name);
	}
	public void setZoomValue(int zoom) {
		this.slider.setValue(zoom);
	}
	public void setSelectedThumbnail(int index) {
		for (int i=0; i<this.thumbnails.size(); i++) {
			if (i==index) {
				thumbnails.get(i).setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			} else {
				thumbnails.get(i).setBorder(null);
			}
		}
	}
	public void addThumbnail(ImageIcon image) {
		JLabel thumbnail = new JLabel(image);
		this.thumbnails.add(thumbnail);
		ListenerThumbnail listenerThumbnail=new ListenerThumbnail(this.cThumbnails, this.thumbnails.size()-1);
		thumbnail.addMouseListener(listenerThumbnail);
		thumbnail.setBorder(null);
		southPanel.add(thumbnail);
		southPanel.validate();
	}

}