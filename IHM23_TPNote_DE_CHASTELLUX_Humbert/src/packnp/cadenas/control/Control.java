package packnp.cadenas.control;

import packnp.cadenas.abstraction.Cadenas;
import packnp.cadenas.presentation.FrameCadenas;

public class Control {
    private ControlLabels controlLabels;
    private ControlSliders controlSliders;
    private ControlArrows controlArrows;
    private ControlOpen controlOpen;

    public Control(Cadenas cadenas) {
        controlLabels = new ControlLabels(cadenas);
        controlSliders = new ControlSliders(cadenas);
        controlArrows = new ControlArrows(cadenas);
        controlOpen = new ControlOpen(cadenas);
    }

    public void connect(FrameCadenas frameCadenas) {
        controlLabels.connectFrame(frameCadenas);
        controlSliders.connectFrame(frameCadenas);
        controlArrows.connectFrame(frameCadenas);
        controlOpen.connectFrame(frameCadenas);
    }

    public ControlLabels getControlLabels() {
        return controlLabels;
    }

    public ControlSliders getControlSliders() {
        return controlSliders;
    }

    public ControlArrows getControlArrows() {
        return controlArrows;
    }

    public ControlOpen getControlOpen() {
        return controlOpen;
    }
}
