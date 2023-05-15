package albumPhoto.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import albumPhoto.control.ControlMenuQuit;

public class ListenerMenuQuit implements ActionListener {
	private ControlMenuQuit control;

	public ListenerMenuQuit(ControlMenuQuit control) {
		this.control = control;
	}

	public void actionPerformed(ActionEvent e) {
		this.control.quit();
	}
}
