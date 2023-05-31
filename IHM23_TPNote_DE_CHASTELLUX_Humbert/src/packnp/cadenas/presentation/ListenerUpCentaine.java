package packnp.cadenas.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import packnp.cadenas.control.ControlArrows;

public class ListenerUpCentaine implements ActionListener{
    private ControlArrows controlArrows;

    public ListenerUpCentaine(ControlArrows controlArrows) {
        this.controlArrows = controlArrows;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controlArrows.upCentaine();
    }
    
}
