package shopping.presentation;

import javax.swing.*;
import java.awt.*;

import shopping.control.Control;
import shopping.control.ControlButton;
import shopping.control.ControlCart;

@SuppressWarnings("serial")
public class FrameShopping extends JFrame {
	@SuppressWarnings("unused")
	private Control control;
	private JButton next;
	private JButton previous;
	private JLabel image;
	private JLabel description;
	private JLabel disponibilite;
	private ControlButton controlButton;
	private JSpinner spinner;
	private JLabel total;
	private JLabel panier;
	private JButton emptyButton;

	public FrameShopping(Control control) {
		super("TP5 Humbert DE CHASTELLUX");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.control = control;
		this.controlButton = control.getControlButton();
		this.setLayout(new BorderLayout());

		buildCenter();
		buildSouth();
		buildEast();
		buildWest();
	}

	public void buildCenter() {
		JPanel center = new JPanel();
		center.setLayout(new BoxLayout(center, BoxLayout.X_AXIS));
		image = new JLabel();
		center.add(image);

		JPanel centerRight = new JPanel();
		centerRight.setLayout(new BoxLayout(centerRight, BoxLayout.Y_AXIS));

		description = new JLabel();
		centerRight.add(description);
		disponibilite = new JLabel();
		centerRight.add(disponibilite);

		center.add(centerRight);

		this.add(center, BorderLayout.CENTER);

	}

	public void buildSouth() {
		JPanel south = new JPanel();
		south.setLayout(new FlowLayout());
		ControlCart controlCart = control.getControlCart();

		panier = new JLabel("Panier : ");
		south.add(panier);

		spinner = new JSpinner();
		ListenerSpinner listenerSpinner = new ListenerSpinner(controlCart);
		spinner.addChangeListener(listenerSpinner);
		south.add(spinner);

		total = new JLabel("Total : ");
		south.add(total);

		emptyButton = new JButton("Vider");
		ListenerButtonEmpty listenerEmpty = new ListenerButtonEmpty(controlCart);
		emptyButton.addActionListener(listenerEmpty);
		south.add(emptyButton);

		this.add(south, BorderLayout.SOUTH);

	}

	public void buildEast() {
		next = new JButton(">");
		ListenerButtonNext listenerNext = new ListenerButtonNext(controlButton);
		next.addActionListener(listenerNext);
		this.add(next, BorderLayout.EAST);
	}

	public void buildWest() {
		previous = new JButton("<");
		previous.setEnabled(false);
		ListenerButtonPrevious listenerPrevious = new ListenerButtonPrevious(controlButton);
		previous.addActionListener(listenerPrevious);
		this.add(previous, BorderLayout.WEST);
	}

	public void enableNext(boolean b) {
		next.setEnabled(b);
	}

	public void enablePrevious(boolean b) {
		previous.setEnabled(b);
	}

	public void updateSpinner(int quantity, int inStock) {
		spinner.setModel(new SpinnerNumberModel(quantity, 0, inStock, 1));
	}

	public void updateDescription(String iconPath, String ndescription, int inStock) {
		image.setIcon(new ImageIcon(iconPath));
		description.setText(ndescription);
		disponibilite.setText("Disponibilite : " + inStock);
	}

	public void updateTotal(double total, int nbArticles) {
		this.total.setText("Total : " + nbArticles + " article(s) pour " + total + " euros");
	}
}
