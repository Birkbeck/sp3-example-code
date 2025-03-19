package mvc.controller;

import mvc.model.Model;
import mvc.view.View;

public class Controller {
    private final View view;
    private final Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }
}
