package motLePlusLong.control;

import motLePlusLong.presentation.FrameMotLePlusLong;
import motLePlusLong.abstraction.Dico;

public class ControlTirage {
    private Dico dico;
    private FrameMotLePlusLong frame;

    public ControlTirage(Dico dico, FrameMotLePlusLong frame) {
        this.dico = dico;
        this.frame = frame;
    }

    public void nouveauTirage(String tirage) {
        String[] tab = dico.motsRealisables(tirage);
        frame.actualiserListe(tab);
    }
}
