package albumPhoto.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import albumPhoto.control.ControlMenuButtons;

public class ListenerQuit implements ActionListener{
    private ControlMenuButtons control;

    public ListenerQuit(ControlMenuButtons control) {
        this.control = control;
    }

    public void actionPerformed(ActionEvent e) {
        control.quit();
    }
    
}
