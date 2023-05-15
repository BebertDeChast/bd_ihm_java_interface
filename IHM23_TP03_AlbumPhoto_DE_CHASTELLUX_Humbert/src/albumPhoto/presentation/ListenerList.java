package albumPhoto.presentation;


import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import albumPhoto.control.ControlList;

public class ListenerList implements ListSelectionListener {

    private ControlList control;

    public ListenerList(ControlList control) {
        this.control = control;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        this.control.select(((JList<String>)(e.getSource())).getSelectedIndex());
        
    }

    

}
