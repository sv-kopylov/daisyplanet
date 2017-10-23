package ru.kopylov.daisyplanet.appearense;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by sergey on 18.10.17.
 */
public class Charts implements EventHandler {

    private final VBox vBox = new VBox();
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

    XYChart.Series<Long, Double> temperSeries = new XYChart.Series<>();
    XYChart.Series<Long, Double> starConstSeries = new XYChart.Series<>();

    public void addTemper(Long iteration, Double temper){
        XYChart.Data<Long, Double> data = new XYChart.Data<>(iteration, temper);
        tempersList.add(data);

    }
    public void addStarConst(Long iteration, Double starConst){
        XYChart.Data<Long, Double> data = new XYChart.Data<>(iteration, starConst);
        starConstsList.add(data);

    }
    public void update(){
        temperSeries.getData().addAll(tempersList);
        tempersList.clear();
        starConstSeries.getData().addAll(starConstsList);
        starConstsList.clear();
    }



    public Charts() {
        xAxisTemper.setAutoRanging(true);
        yAxisTemper.setAutoRanging(true);
        yAxisTemper.setLabel("Temperature");
        xAxisStarConst.setAutoRanging(true);
        yAxisStarConst.setAutoRanging(true);
        yAxisStarConst.setLabel("Star energy");



        temperChart = new LineChart(xAxisTemper, yAxisTemper);
        temperChart.setAnimated(true);
        temperChart.setTitle("Temperature");
        temperChart.setLegendVisible(false);
        temperChart.setCreateSymbols(false);
        temperChart.getData().add(temperSeries);
        temperChart.setPrefSize(400,280);

        starConstChart = new LineChart(xAxisStarConst, yAxisStarConst);
        starConstChart.setAnimated(true);
        starConstChart.setTitle("Star energy");
        starConstChart.setLegendVisible(false);
        starConstChart.setCreateSymbols(false);
        starConstChart.getData().add(starConstSeries);
        starConstChart.setPrefSize(400, 280);

         vBox.getChildren().addAll(temperChart, starConstChart);


    }

    @Override
    public void handle(Event event) {
                 update();
    }

    public Node getPane(){
        return vBox;
    }
}
