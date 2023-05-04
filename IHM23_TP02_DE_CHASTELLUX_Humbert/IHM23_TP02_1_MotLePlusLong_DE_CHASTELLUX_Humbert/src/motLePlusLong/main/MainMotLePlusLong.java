package motLePlusLong.main;
import motLePlusLong.abstraction.Dico;
import motLePlusLong.presentation.FrameMotLePlusLong;

public class MainMotLePlusLong {
	public static void main(String[] args) {
		Dico dico = new Dico("IHM23_TP02_1_MotLePlusLong_DE_CHASTELLUX_Humbert/Dico.txt");
		FrameMotLePlusLong fen = new FrameMotLePlusLong(dico);
		fen.setVisible(true);
	}
}
