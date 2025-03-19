package javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ChartExample extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();

        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("Item 1", 10));
        series.getData().add(new XYChart.Data<>("Item 2", 20));
        series.getData().add(new XYChart.Data<>("Item 3", 15));

        barChart.getData().add(series);

        Scene scene = new Scene(barChart, 600, 450);

        primaryStage.setTitle("Chart Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
