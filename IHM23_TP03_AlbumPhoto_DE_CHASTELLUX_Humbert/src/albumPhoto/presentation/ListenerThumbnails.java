package albumPhoto.presentation;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import albumPhoto.control.ControlThumbnails;

public class ListenerThumbnails implements MouseListener {
    private ControlThumbnails control;
    private int index;

    public ListenerThumbnails(ControlThumbnails control, int index) {
        this.control = control;
        this.index = index;
    }

    public void mouseEntered(MouseEvent e) {
        control.go(index);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
