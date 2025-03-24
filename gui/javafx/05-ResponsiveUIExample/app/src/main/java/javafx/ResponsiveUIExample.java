package javafx;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ResponsiveUIExample extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Slider slider = new Slider(0, 100, 50);
        Label label = new Label();

        label.textProperty().bind(Bindings.format("Slider Value: %.2f", slider.valueProperty()));

        VBox root = new VBox(slider, label);
        root.setSpacing(10);

        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("Responsive UI Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
