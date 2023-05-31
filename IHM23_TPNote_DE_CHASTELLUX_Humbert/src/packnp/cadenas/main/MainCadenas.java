package packnp.cadenas.main;

import packnp.cadenas.control.Control;

import packnp.cadenas.abstraction.Cadenas;
import packnp.cadenas.presentation.FrameCadenas;

public class MainCadenas {
	public static void main(String[] args) {
		Cadenas cadenas = new Cadenas(421);
		Control control = new Control(cadenas);
		FrameCadenas fen = new FrameCadenas(control);
		control.connect(fen);
		fen.setVisible(true);
	}
}
