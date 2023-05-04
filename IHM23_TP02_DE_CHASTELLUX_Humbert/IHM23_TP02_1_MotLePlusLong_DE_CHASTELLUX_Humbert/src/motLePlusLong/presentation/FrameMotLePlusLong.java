package motLePlusLong.presentation;

import java.awt.*;
import javax.swing.*;
import motLePlusLong.abstraction.Dico;
import motLePlusLong.control.ControlTirage;

@SuppressWarnings("serial")
public class FrameMotLePlusLong extends JFrame {

	private JList<String> liste;
	private Dico dico;

	public FrameMotLePlusLong(Dico dico) {
		super("MotLePlusLong");
		this.dico = dico;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		JPanel haut = new JPanel();
		haut.setLayout(new BorderLayout());
		this.add(haut, BorderLayout.NORTH);

		haut.add(new JLabel("Tirage : "), BorderLayout.WEST);

		String[] mots = { "ES", "ET", "SE", "TE", "EST", "SET", "TES" };
		this.liste = new JList<String>(mots);
		this.add(new JScrollPane(liste), BorderLayout.CENTER);

		JTextField saisie = new JTextField("ETS");
		saisie.setToolTipText("Veuillez indiquer les lettres du tirage");
		haut.add(saisie, BorderLayout.CENTER);

		ControlTirage cTirage = new ControlTirage(this.dico, this);
		ListenerTirage lTirage = new ListenerTirage(cTirage);

		saisie.addCaretListener(lTirage);

		this.pack();
	}

	public void actualiserListe(String[] mots) {
		this.liste.setListData(mots);
	}

}
