package javafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalculatorExample extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TextField inputField = new TextField();

        Button button1 = new Button("1");
        Button button2 = new Button("2");
        Button addButton = new Button("+");
        Button calculateButton = new Button("Calculate");

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.add(inputField, 0, 0, 2, 1);
        gridPane.add(button1, 0, 1);
        gridPane.add(button2, 1, 1);
        gridPane.add(addButton, 0, 2);
        gridPane.add(calculateButton, 1, 2);

        Scene scene = new Scene(gridPane, 300, 200);

        primaryStage.setTitle("Calculator Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

