package albumPhoto.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import albumPhoto.control.ControlMenuNew;

public class ListenerMenuNew implements ActionListener {

	private ControlMenuNew control;
	
	public ListenerMenuNew(ControlMenuNew control) {
		this.control = control;
	}
	
	public void actionPerformed(ActionEvent e) {
		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			this.control.addPhoto( chooser.getSelectedFile().getAbsolutePath() );
		}
	}

}
