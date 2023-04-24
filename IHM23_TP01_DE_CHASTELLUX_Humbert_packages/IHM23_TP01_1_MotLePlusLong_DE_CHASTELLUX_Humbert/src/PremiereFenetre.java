import javax.swing.*;

public class PremiereFenetre extends JFrame {
    public PremiereFenetre() {
        super("ma premiere fenetre");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.add(new JLabel("Bonjour. C'est quoi ton nom ?"));
        this.add(new JTextField(20));
        this.pack();
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        PremiereFenetre f = new PremiereFenetre();
        f.setVisible(true);
    }
}
