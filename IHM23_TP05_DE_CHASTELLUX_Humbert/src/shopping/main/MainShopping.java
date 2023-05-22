package shopping.main;

import shopping.control.Control;

import shopping.abstraction.Cart;
import shopping.presentation.FrameShopping;

public class MainShopping {
	public static void main(String[] args) {
			Cart cart = new Cart("catalogue.txt");
			Control control = new Control(cart);
			FrameShopping fen = new FrameShopping(control);
			control.connectFrame(fen);
			fen.setVisible(true);
			cart.setCurrentIndex(0);
	}
}
