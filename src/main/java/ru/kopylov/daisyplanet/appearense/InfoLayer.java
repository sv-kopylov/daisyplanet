package ru.kopylov.daisyplanet.appearense;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import ru.kopylov.daisyplanet.model.Conditions;
import ru.kopylov.daisyplanet.model.Planet;

/**
 * Created by sergey on 14.10.17.
 */
public class InfoLayer {
    String temperature;
    String albedo;
    String starConstant;
    String iteration;


    Color infoColor = Color.GOLD;

    public InfoLayer(Planet planet) {
        setInfo(planet);
    }
    public void ekspose(GraphicsContext gc){
        gc.setFill(infoColor);
        gc.fillText(temperature, 10,12);
        gc.fillText(starConstant, 10,24);
        gc.fillText(albedo, 10,36);
        gc.fillText(iteration, 10,48);


    }
    public void setInfo(Planet planet){
        temperature = "Temperature: "+String.format("%+3.0f ", planet.getTemperature());
        starConstant = "Star energy: "+String.format("%+3.0f ", Conditions.getInstance().StarConstant);
        albedo = "Albedo: "+String.format("%+1.3f ", planet.getAlbedo());
        iteration = "Iteration: "+planet.getIterationId();


    }



    }
