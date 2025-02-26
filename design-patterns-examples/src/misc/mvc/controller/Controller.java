package misc.mvc.controller;

import misc.mvc.model.Model;
import misc.mvc.view.View;

public class Controller {
    private final View view;
    private final Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }
}
