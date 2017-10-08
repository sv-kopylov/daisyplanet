package ru.kopylov.daisyplanet.appearense;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import ru.kopylov.daisyplanet.model.Planet;

/**
 * Created by sergey on 04.10.17.
 */
public class DaizyPlanetViewer extends Application{

    public static void main(String...args){
        launch(DaizyPlanetViewer.class, args);
    }

    public void init(){

    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Daizy planet view");
        Group root = new Group();

        Canvas canvas= new Canvas(800, 800);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Planet planet = new Planet();
        PlanetLayer pl = new PlanetLayer(planet);


        pl.ekspose(gc);




        Scene scene = new Scene(root, 600, 300);

        root.getChildren().add(canvas);


        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void stop(){

    }
}
