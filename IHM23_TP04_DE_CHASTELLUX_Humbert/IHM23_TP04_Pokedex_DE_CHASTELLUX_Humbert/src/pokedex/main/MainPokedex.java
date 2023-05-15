package pokedex.main;

import pokedex.abstraction.Pokedex;
import pokedex.presentation.FramePokedex;

public class MainPokedex {
	public static void main(String[] args) {
		Pokedex pokedex = null;
		try {
			pokedex = new Pokedex();
		} catch (Exception e) {
			System.out.println("Erreur lors de la creation du pokedex\n"+e);
		}
		FramePokedex fen = new FramePokedex(pokedex);
		fen.setVisible(true);
	}
}
