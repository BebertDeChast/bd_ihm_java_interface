package motLePlusLong.presentation;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class FrameMotLePlusLong extends JFrame {

    public FrameMotLePlusLong() {
        super("Mot le plus long");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // panneau nord
        JPanel panneauNord = new JPanel();
        panneauNord.setLayout(new BorderLayout());
        JLabel tirage = new JLabel("Tirage :");
        tirage.setToolTipText("Veuillez indiquer les lettres du tirage");
        panneauNord.add(tirage, BorderLayout.WEST);

        // text field
        panneauNord.add(new JTextField("ETS"), BorderLayout.CENTER);

        this.add(panneauNord, BorderLayout.NORTH);

        // list
        String[] test = { "ES", "ET", "SE", "TE", "EST", "SET", "TES" };
        JList<String> testj = new JList<String>(test);
        testj.setLayoutOrientation(JList.VERTICAL);
        testj.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scroll = new JScrollPane(testj);
        this.add(scroll, BorderLayout.CENTER);

        this.pack();

    }

}
