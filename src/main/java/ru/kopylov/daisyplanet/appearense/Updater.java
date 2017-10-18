package ru.kopylov.daisyplanet.appearense;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.converter.NumberStringConverter;
import ru.kopylov.daisyplanet.model.Conditions;
import ru.kopylov.daisyplanet.model.Planet;

/**
 * Created by sergey on 13.10.17.
 */
public class Updater implements EventHandler {
    private final Planet planet;
    private final PlanetLayer pl;
    private final TemperatureLayer tl;
    private final InfoLayer il;
    private final GraphicsContext gc;

    private final TitledPane titledPane = new TitledPane();
    private final VBox vBox = new VBox();

    private final Button button = new Button();
    private final TextField timesField = new TextField();
    private final TextField incrementOnField = new TextField();
    private final TextField everyField = new TextField();

    private int times=0;
    private int every =0;
    private double incrementOn=0;




    public Updater(Planet planet, PlanetLayer pl, TemperatureLayer tl, InfoLayer il, GraphicsContext gc) {
        this.planet = planet;
        this.pl = pl;
        this.tl = tl;
        this.gc = gc;
        this.il = il;
        button.setText("Update");
        button.setLayoutX(1);
        button.setLayoutY(1);
        button.setOnAction(this);
        timesField.setPrefColumnCount(5);
        incrementOnField.setPrefColumnCount(4);
        everyField.setPrefColumnCount(4);
        timesField.setText("1");
        incrementOnField.setText("0");
        everyField.setText("0");

        titledPane.setGraphic(new Label("Updater"));

        vBox.getChildren().add(button);
        HBox hBoxTms = new HBox();
        hBoxTms.getChildren().add(timesField);
        hBoxTms.getChildren().add(new Label(" times, "));
        vBox.getChildren().add(hBoxTms);
        vBox.getChildren().add(new Label("and increment star constant"));
        HBox hBoxIncr = new HBox();
        hBoxIncr.getChildren().add(new Label("on"));
        hBoxIncr.getChildren().add(incrementOnField);
        hBoxIncr.getChildren().add(new Label(" every"));
        hBoxIncr.getChildren().add(everyField);
        vBox.getChildren().add(hBoxIncr);
        vBox.getChildren().add(new Label("iteration(s)"));
        titledPane.setContent(vBox);




    }

    @Override
    public void handle(Event event) {
        update();

    }
    private void update(){
        titledPane.setDisable(true);
        updateNumbers();
        for (int i=0; i<times;i++){
            planet.update();
            if(every!=0){
                if(i%every==0){
                    Conditions.getInstance().StarConstant+=incrementOn;
                }
            }
        }

        pl.setColors(planet);
        pl.ekspose(gc);

        tl.setColors(planet);
        tl.ekspose(gc);

        il.setInfo(planet);
        il.ekspose(gc);
        titledPane.setDisable(false);
    }

    private void updateNumbers(){
        try {
            times = Math.abs(Integer.parseInt(timesField.getText()));
            incrementOn = Double.parseDouble(incrementOnField.getText());
            every = Math.abs(Integer.parseInt(everyField.getText()));
             } catch (NumberFormatException e){
            e.printStackTrace();
        }
    }


    public TitledPane getPane(){
        return titledPane;
    }

}
