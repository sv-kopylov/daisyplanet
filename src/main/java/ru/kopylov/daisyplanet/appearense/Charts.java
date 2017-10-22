package ru.kopylov.daisyplanet.appearense;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by sergey on 18.10.17.
 */
public class Charts implements EventHandler {

    private final Stage primaryStage;


    private final VBox vBox = new VBox();
    private final TitledPane titledPane = new TitledPane();
    private final Button button = new Button();
    private final Popup popup = new Popup();

    private boolean enabled = false;


    private final LineChart temperChart;
    private final LineChart starConstChart;



    private final NumberAxis xAxisTemper = new NumberAxis();
    private final NumberAxis yAxisTemper = new NumberAxis();
    private final NumberAxis xAxisStarConst = new NumberAxis();
    private final NumberAxis yAxisStarConst = new NumberAxis();


    ArrayList<XYChart.Data<Long, Double>> tempersList = new ArrayList<>();
    ArrayList<XYChart.Data<Long, Double>> starConstsList = new ArrayList<>();

    public void addTemper(Long iteration, Double temper){
        XYChart.Data<Long, Double> data = new XYChart.Data<>(iteration, temper);
        tempersList.add(data);

    }
    public void addStarConst(Long iteration, Double starConst){
        XYChart.Data<Long, Double> data = new XYChart.Data<>(iteration, starConst);
        starConstsList.add(data);

    }
    public void update(){
        temperChart.getData().addAll(tempersList);
        tempersList.clear();
        starConstChart.getData().addAll(starConstsList);
        starConstsList.clear();
    }



    public Charts(Stage primaryStage) {
        this.primaryStage = primaryStage;
        xAxisTemper.setAutoRanging(true);
        yAxisTemper.setAutoRanging(true);
        yAxisTemper.setLabel("Temperature");
        xAxisStarConst.setAutoRanging(true);
        yAxisStarConst.setAutoRanging(true);
        yAxisStarConst.setLabel("Star energy");

        temperChart = new LineChart(xAxisTemper, yAxisTemper);
        temperChart.setAnimated(true);
        starConstChart = new LineChart(xAxisStarConst, yAxisStarConst);
        starConstChart.setAnimated(true);

        button.setText("show/hide");
        button.setOnAction(this);

        titledPane.setGraphic(new Label("Charts"));
        titledPane.setContent(button);

        vBox.getChildren().addAll(temperChart, starConstChart);
        popup.getContent().add(vBox);




    }

    @Override
    public void handle(Event event) {
        enabled =!enabled;
        if(enabled) {
            update();
            popup.show(primaryStage);
        } else {
            popup.hide();
        }

    }

    public TitledPane getPane(){
        return titledPane;
    }
}
