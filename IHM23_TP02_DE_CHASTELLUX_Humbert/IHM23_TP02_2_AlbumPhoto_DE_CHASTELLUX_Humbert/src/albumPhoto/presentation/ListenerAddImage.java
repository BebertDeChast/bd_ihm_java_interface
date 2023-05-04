package albumPhoto.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import albumPhoto.control.ControlMenuButtons;

public class ListenerAddImage implements ActionListener{
    private ControlMenuButtons control;

    public ListenerAddImage(ControlMenuButtons control) {
        this.control = control;
    }

    public void actionPerformed(ActionEvent e) {
        FrameFileChooser frame = new FrameFileChooser();
        String path = frame.getPath();
        if (path != null) {
            control.addImage(path);
        }
    }
    
}
