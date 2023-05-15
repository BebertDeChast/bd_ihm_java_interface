package albumPhoto.presentation;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import albumPhoto.control.ControlZoom;

public class ListenerZoom implements ChangeListener {
	private ControlZoom controlZoom;

	public ListenerZoom(ControlZoom controlZoom) {
		this.controlZoom=controlZoom;
	}
	public void stateChanged(ChangeEvent e) {
		this.controlZoom.resizeCurrentPhoto( (((JSlider)e.getSource()).getValue()));
	}

}
