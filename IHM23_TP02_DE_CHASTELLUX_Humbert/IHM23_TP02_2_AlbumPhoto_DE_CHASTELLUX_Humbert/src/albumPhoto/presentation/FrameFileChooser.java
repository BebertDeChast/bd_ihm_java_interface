package albumPhoto.presentation;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class FrameFileChooser extends JFrame{
    public FrameFileChooser(){
        super("Choose a image");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public String getPath(){
        JFileChooser chooser = new JFileChooser();
        int bouton = chooser.showSaveDialog(this);
        if (bouton == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile().getAbsolutePath();
        } else {
            return null;
        }
    }
}
