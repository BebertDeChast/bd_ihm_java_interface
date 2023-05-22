package shopping.control;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import shopping.abstraction.Cart;
import shopping.presentation.FrameShopping;

public class ControlButton implements PropertyChangeListener {
    private Cart panier;
    private FrameShopping frame;

    public ControlButton(Cart panier) {
        this.panier = panier;
        this.panier.addPropertyChangeListener(this);
    }

    public void connectFrame(FrameShopping frame) {
        this.frame = frame;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String msg = evt.getPropertyName();
        if (msg == Cart.MESSAGE_CHANGEMENT_ARTICLE_COURANT) {
            if (panier.getCurrentIndex() == 0) {
                frame.enableNext(true);
                frame.enablePrevious(false);
            } else if (panier.getCurrentIndex() == panier.getCatalogSize() - 1) {
                frame.enableNext(false);
                frame.enablePrevious(true);
            } else {
                frame.enableNext(true);
                frame.enablePrevious(true);
            }

        }
    }

    public void next() {
        panier.setCurrentIndex(panier.getCurrentIndex() + 1);
        ;
    }

    public void previous() {
        panier.setCurrentIndex(panier.getCurrentIndex() - 1);
    }

}
