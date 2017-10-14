package ru.kopylov.daisyplanet.appearense;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
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
        Canvas canvas= new Canvas(610, 560);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        pl.ekspose(gc);
        tl.ekspose(gc);

        Canvas infoCanvas = new Canvas(610, 560);
        GraphicsContext infoGc =infoCanvas.getGraphicsContext2D();
        infoGc.setStroke(Color.GOLD);
        infoGc.strokeRect(10, 10, 50, 50);

        Button updateButton = new Button();
        updateButton.setLayoutX(1);
        updateButton.setLayoutY(1);
        updateButton.setText("update");
        updateButton.setOnAction(event-> {
            planet.update();
            pl.setColors(planet);
            pl.ekspose(gc);

            tl.setColors(planet);
            tl.ekspose(gc);
        });

        Pane pane = new Pane();
        pane.getChildren().add(canvas);
        pane.getChildren().add(infoCanvas);
        infoCanvas.toFront();

        borderPane.setCenter(pane);
        borderPane.setLeft(updateButton);


        Scene scene = new Scene(root, 670, 640);
        root.getChildren().add(borderPane);


        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void stop(){

    }

    public void update(){

    }
}
