package shopping.control;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import shopping.abstraction.Cart;
import shopping.presentation.FrameShopping;

public class ControlDatas implements PropertyChangeListener {
    private Cart panier;
    private FrameShopping frame;

    public ControlDatas(Cart panier) {
        this.panier = panier;
        this.panier.addPropertyChangeListener(this);

    }

    public void connectFrame(FrameShopping frame) {
        this.frame = frame;
        updateDatas();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String msg = evt.getPropertyName();
        if (msg == Cart.MESSAGE_CHANGEMENT_ARTICLE_COURANT) {
            updateDatas();
        }
    }

    public void updateDatas() {
        this.frame.updateDescription(this.panier.getCurrentArticle().getIconFile(),
                this.panier.getCurrentArticle().getDescription(), this.panier.getCurrentArticle().getInStock());
    }
}
