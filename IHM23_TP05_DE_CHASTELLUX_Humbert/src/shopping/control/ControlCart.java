package shopping.control;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import shopping.abstraction.Cart;
import shopping.presentation.FrameShopping;

public class ControlCart implements PropertyChangeListener {
    private Cart panier;
    private FrameShopping frame;

    public ControlCart(Cart panier) {
        this.panier = panier;
        this.panier.addPropertyChangeListener(this);
    }

    public void connectFrame(FrameShopping frame) {
        this.frame = frame;
        updateTotal();
        updateSpinner();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String msg = evt.getPropertyName();
        if (msg == Cart.MESSAGE_CHANGEMENT_CONTENU_PANIER) {
            updateTotal();
        }

        if (msg == Cart.MESSAGE_CHANGEMENT_ARTICLE_COURANT) {
            updateSpinner();
        }
    }

    public void empty() {
        panier.clear();
        updateSpinner();
    }

    public void updateQuantity(int quantity) {
        panier.setCurrentQuantity(quantity);
    }

    public void updateSpinner() {
        frame.updateSpinner(panier.getCurrentQuantity(), panier.getCurrentArticle().getInStock());
    }

    public void updateTotal() {
        frame.updateTotal(panier.getTotalPrice(), panier.getCartSize());
    }

}
