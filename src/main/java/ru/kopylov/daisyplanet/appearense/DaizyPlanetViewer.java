package ru.kopylov.daisyplanet.appearense;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import ru.kopylov.daisyplanet.model.Planet;

/**
 * Created by sergey on 04.10.17.
 */
public class DaizyPlanetViewer extends Application{
    final Planet planet = new Planet();
    public static void main(String...args){
        launch(DaizyPlanetViewer.class, args);
    }

    public void init(){

    }
    @Override
    public void start(Stage primaryStage) throws Exception {

//        controller
        PlanetLayer pl = new PlanetLayer(planet);
        TemperatureLayer tl = new TemperatureLayer(planet);


        primaryStage.setTitle("Daizy planet view");
        Group root = new Group();
        BorderPane borderPane = new BorderPane();
        Canvas canvas= new Canvas(590, 560);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        pl.ekspose(gc);
        tl.ekspose(gc);

        Button updateButton = new Button();
        updateButton.setLayoutX(1);
        updateButton.setLayoutY(1);
        updateButton.setText("update");
        updateButton.setOnAction(event-> {
            planet.update();
            pl.setColors(planet);
            pl.ekspose(gc);

        });


        borderPane.setCenter(canvas);
        borderPane.setLeft(updateButton);


        Scene scene = new Scene(root, 620, 640);
        root.getChildren().add(borderPane);


        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void stop(){

    }
}
