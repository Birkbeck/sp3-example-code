package misc.mvc.view;

import javax.swing.JFrame;

import misc.mvc.model.Model;

public class View extends JFrame {
    private final Model model;

    public View(Model model) {
        super("MVC Demo");
        this.model = model;
    }
}