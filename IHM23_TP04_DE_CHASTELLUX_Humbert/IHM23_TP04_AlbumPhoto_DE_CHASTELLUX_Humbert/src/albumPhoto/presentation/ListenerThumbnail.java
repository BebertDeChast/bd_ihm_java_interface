package albumPhoto.presentation;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import albumPhoto.control.ControlThumbnails;

public class ListenerThumbnail implements MouseListener {
	private int index;
	private ControlThumbnails control; 
	
	public ListenerThumbnail(ControlThumbnails control, int index) {
		this.control = control; 
		this.index = index;
	}

	public void mouseEntered(MouseEvent e) {
		this.control.go(this.index);
	}

	public void mouseClicked(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
}
