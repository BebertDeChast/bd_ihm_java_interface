package packnp.cadenas.presentation;

import java.awt.BorderLayout;
import java.awt.Font;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import packnp.cadenas.control.Control;
import packnp.cadenas.control.ControlArrows;
import packnp.cadenas.control.ControlLabels;
import packnp.cadenas.control.ControlOpen;
import packnp.cadenas.control.ControlSliders;

public class FrameCadenas extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final Font FONTE = new Font("Monospaced", Font.BOLD, 42);
	private JButton upCentaine;
	private JButton upDizaine;
	private JButton upUnite;
	private JButton downCentaine;
	private JButton downDizaine;
	private JButton downUnite;
	private JLabel labelCentaine;
	private JLabel labelDizaine;
	private JLabel labelUnite;
	private JButton ouvrir;
	private JSlider sliderCentaine;
	private JSlider sliderDizaine;
	private JSlider sliderUnite;
	private JPanel panelCenter;
	private Control control;
	private ControlArrows controlArrows;
	private ControlSliders controlSliders;

	public FrameCadenas(Control control) {
		super("Cadenas de DE CHASTELLUX Humbert");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.control = control;
		this.controlArrows = control.getControlArrows();
		this.controlSliders = control.getControlSliders();

		this.setLayout(new BorderLayout());

		ouvrir = new JButton("OUVRIR");
		ouvrir.setFont(FONTE);
		ouvrir.setEnabled(false);

		this.add(ouvrir, BorderLayout.SOUTH);

		buildCenter();

		this.pack();
		this.setResizable(false);
	}

	public void buildCenter() {
		this.panelCenter = new JPanel();
		panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.X_AXIS));

		this.buildCentaine();
		this.buildDizaine();
		this.buildUnite();

		this.add(panelCenter, BorderLayout.CENTER);
	}

	public void buildCentaine() {
		this.upCentaine = new JButton(new ImageIcon("images" + File.separator + "inc.gif"));
		ListenerUpCentaine listenerUpCentaine = new ListenerUpCentaine(controlArrows);
		this.upCentaine.addActionListener(listenerUpCentaine);
		this.downCentaine = new JButton(new ImageIcon("images" + File.separator + "dec.gif"));
		ListenerDownCentaine listenerDownCentaine = new ListenerDownCentaine(controlArrows);
		this.downCentaine.addActionListener(listenerDownCentaine);
		this.downCentaine.setEnabled(false);
		this.labelCentaine = new JLabel("0");
		this.labelCentaine.setFont(FONTE);
		this.sliderCentaine = new JSlider(0, 9, 0);
		this.sliderCentaine.setOrientation(JSlider.VERTICAL);
		this.sliderCentaine.setMajorTickSpacing(1);
		this.sliderCentaine.setPaintTicks(true);
		this.sliderCentaine.setPaintLabels(true);
		ListenerSliderCentaine listenerSliderCentaine = new ListenerSliderCentaine(controlSliders);
		this.sliderCentaine.addChangeListener(listenerSliderCentaine);

		JPanel innerCentainePanel = new JPanel();
		innerCentainePanel.setLayout(new BorderLayout());
		innerCentainePanel.add(upCentaine, BorderLayout.NORTH);
		innerCentainePanel.add(labelCentaine, BorderLayout.CENTER);
		innerCentainePanel.add(downCentaine, BorderLayout.SOUTH);

		JPanel panelCentaine = new JPanel();
		panelCentaine.setLayout(new BorderLayout());
		panelCentaine.add(innerCentainePanel, BorderLayout.CENTER);
		panelCentaine.add(sliderCentaine, BorderLayout.EAST);

		panelCenter.add(panelCentaine);
	}

	public void buildDizaine() {
		this.upDizaine = new JButton(new ImageIcon("images" + File.separator + "inc.gif"));
		ListenerUpDizaine listenerUpDizaine = new ListenerUpDizaine(controlArrows);
		this.upDizaine.addActionListener(listenerUpDizaine);
		this.downDizaine = new JButton(new ImageIcon("images" + File.separator + "dec.gif"));
		ListenerDownDizaine listenerDownDizaine = new ListenerDownDizaine(controlArrows);
		this.downDizaine.addActionListener(listenerDownDizaine);
		this.downDizaine.setEnabled(false);
		this.labelDizaine = new JLabel("0");
		this.labelDizaine.setFont(FONTE);
		this.sliderDizaine = new JSlider(0, 9, 0);
		this.sliderDizaine.setOrientation(JSlider.VERTICAL);
		this.sliderDizaine.setMajorTickSpacing(1);
		this.sliderDizaine.setPaintTicks(true);
		this.sliderDizaine.setPaintLabels(true);
		ListenerSliderDizaine listenerSliderDizaine = new ListenerSliderDizaine(controlSliders);
		this.sliderDizaine.addChangeListener(listenerSliderDizaine);

		JPanel innerDizainePanel = new JPanel();
		innerDizainePanel.setLayout(new BorderLayout());
		innerDizainePanel.add(upDizaine, BorderLayout.NORTH);
		innerDizainePanel.add(labelDizaine, BorderLayout.CENTER);
		innerDizainePanel.add(downDizaine, BorderLayout.SOUTH);

		JPanel panelDizaine = new JPanel();
		panelDizaine.setLayout(new BorderLayout());
		panelDizaine.add(innerDizainePanel, BorderLayout.CENTER);
		panelDizaine.add(sliderDizaine, BorderLayout.EAST);

		panelCenter.add(panelDizaine);
	}

	public void buildUnite() {
		this.upUnite = new JButton(new ImageIcon("images" + File.separator + "inc.gif"));
		ListenerUpUnite listenerUpUnite = new ListenerUpUnite(controlArrows);
		this.upUnite.addActionListener(listenerUpUnite);
		this.downUnite = new JButton(new ImageIcon("images" + File.separator + "dec.gif"));
		ListenerDownUnite listenerDownUnite = new ListenerDownUnite(controlArrows);
		this.downUnite.addActionListener(listenerDownUnite);
		this.downUnite.setEnabled(false);
		this.labelUnite = new JLabel("0");
		this.labelUnite.setFont(FONTE);
		this.sliderUnite = new JSlider(0, 9, 0);
		this.sliderUnite.setOrientation(JSlider.VERTICAL);
		this.sliderUnite.setMajorTickSpacing(1);
		this.sliderUnite.setPaintTicks(true);
		this.sliderUnite.setPaintLabels(true);
		ListenerSliderUnite listenerSliderUnite = new ListenerSliderUnite(controlSliders);
		this.sliderUnite.addChangeListener(listenerSliderUnite);

		JPanel innerUnitePanel = new JPanel();
		innerUnitePanel.setLayout(new BorderLayout());
		innerUnitePanel.add(upUnite, BorderLayout.NORTH);
		innerUnitePanel.add(labelUnite, BorderLayout.CENTER);
		innerUnitePanel.add(downUnite, BorderLayout.SOUTH);

		JPanel panelUnite = new JPanel();
		panelUnite.setLayout(new BorderLayout());
		panelUnite.add(innerUnitePanel, BorderLayout.CENTER);
		panelUnite.add(sliderUnite, BorderLayout.EAST);

		panelCenter.add(panelUnite);
	}

	public void setUnites(int unites) {
		this.labelUnite.setText("" + unites);
	}

	public void setDizaines(int dizaines) {
		this.labelDizaine.setText("" + dizaines);
	}

	public void setCentaines(int centaines) {
		this.labelCentaine.setText("" + centaines);
	}

	public void setOuvrir(boolean ouvrir) {
		this.ouvrir.setEnabled(ouvrir);
	}

	public void setDownCentaine(boolean downCentaine) {
		this.downCentaine.setEnabled(downCentaine);
	}

	public void setDownDizaine(boolean downDizaine) {
		this.downDizaine.setEnabled(downDizaine);
	}

	public void setDownUnite(boolean downUnite) {
		this.downUnite.setEnabled(downUnite);
	}

	public void setUpCentaine(boolean upCentaine) {
		this.upCentaine.setEnabled(upCentaine);
	}

	public void setUpDizaine(boolean upDizaine) {
		this.upDizaine.setEnabled(upDizaine);
	}

	public void setUpUnite(boolean upUnite) {
		this.upUnite.setEnabled(upUnite);
	}

	public void setSliderCentaine(int sliderCentaine) {
		this.sliderCentaine.setValue(sliderCentaine);
	}

	public void setSliderDizaine(int sliderDizaine) {
		this.sliderDizaine.setValue(sliderDizaine);
	}

	public void setSliderUnite(int sliderUnite) {
		this.sliderUnite.setValue(sliderUnite);
	}
}