package javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class EventHandlingApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button button = new Button("Click Me!");

        // Event handling
        button.setOnAction(event -> {
            System.out.println("Button clicked!");
        });

        StackPane root = new StackPane();
        root.getChildren().add(button);

        Scene scene = new Scene(root, 300, 200);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Event Handling App");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
