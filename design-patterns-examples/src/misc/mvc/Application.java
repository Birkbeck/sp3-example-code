package misc.mvc;

import javax.swing.SwingUtilities;

import misc.mvc.controller.Controller;
import misc.mvc.model.Model;
import misc.mvc.view.View;

public class Application {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                runApp();
            }
        });
    }

    public static void runApp() {
        Model model = new Model();
        View view = new View(model);

        Controller controller = new Controller(view, model);
    }

}
