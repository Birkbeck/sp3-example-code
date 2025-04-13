package javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class StylingApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button button = new Button("Styled Button"); 

        StackPane root = new StackPane();
        root.getChildren().add(button);

        Scene scene = new Scene(root, 300, 200);

        // Load the CSS file
        scene.getStylesheets().add(getClass().getClassLoader().getResource("styles.css").toExternalForm());

        // Apply a CSS class to the button
        button.getStyleClass().add("my-button");

        primaryStage.setScene(scene);
        primaryStage.setTitle("Styling App");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
};
