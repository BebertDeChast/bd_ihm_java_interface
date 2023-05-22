package shopping.control;

import shopping.abstraction.Cart;
import shopping.presentation.FrameShopping;

public class Control {
    private ControlButton controlButton;
    private ControlDatas controlDatas;
    private ControlCart controlCart;

    public Control(Cart panier) {
        controlButton = new ControlButton(panier);
        controlDatas = new ControlDatas(panier);
        controlCart = new ControlCart(panier);
    }

    public ControlButton getControlButton() {
        return controlButton;
    }

    public ControlDatas getControlDatas() {
        return controlDatas;
    }

    public ControlCart getControlCart() {
        return controlCart;
    }

    public void connectFrame(FrameShopping frame) {
        controlButton.connectFrame(frame);
        controlDatas.connectFrame(frame);
        controlCart.connectFrame(frame);
        frame.pack();
    }
}
