package motLePlusLong.presentation;

import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import motLePlusLong.control.ControlTirage;

public class ListenerTirage implements CaretListener {

	private ControlTirage control;

	public ListenerTirage(ControlTirage control) {
		this.control = control;
	}

	public void caretUpdate(CaretEvent e) {
		JTextField textFielTirage = ((JTextField) (e.getSource()));
		String tirage = textFielTirage.getText();
		this.control.nouveauTirage(tirage);
	}

}
