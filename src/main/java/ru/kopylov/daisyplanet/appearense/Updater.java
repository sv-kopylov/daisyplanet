package ru.kopylov.daisyplanet.appearense;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.GridPane;
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
    private final GraphicsContext gc;

    private final GridPane pane = new GridPane();
    private final Button button = new Button();
    private final TextField timesField = new TextField();
    private final TextField incrementOnField = new TextField();
    private final TextField everyField = new TextField();

    private int times=0;
    private int every =0;
    private double incrementOn=0;


    public Updater(Planet planet, PlanetLayer pl, TemperatureLayer tl, GraphicsContext gc) {
        this.planet = planet;
        this.pl = pl;
        this.tl = tl;
        this.gc = gc;
        button.setText("Update");
        button.setOnAction(this);
        timesField.setTextFormatter(new TextFormatter<>(new NumberStringConverter()));
        incrementOnField.setTextFormatter(new TextFormatter<>(new NumberStringConverter()));
        everyField.setTextFormatter(new TextFormatter<>(new NumberStringConverter()));
    }

    @Override
    public void handle(Event event) {
        update();

    }
    private void update(){
        updateNumbers();
        for (int i=0; i<times;i++){
            planet.update();
            if(every!=0&&i!=0){
                if(i%every==0){
                    Conditions.getInstance().StarConstant+=incrementOn;
                }
            }


        }

        pl.setColors(planet);
        pl.ekspose(gc);

        tl.setColors(planet);
        tl.ekspose(gc);
    }

    private void updateNumbers(){
        try {
            times = Math.abs(Integer.parseInt(timesField.getText()));
            incrementOn = Double.parseDouble(incrementOnField.getText());
            every = Math.abs(Integer.parseInt(everyField.getText()));
            if(every==0) every=1;
        } catch (NumberFormatException e){

        }
    }



}
