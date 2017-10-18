package ru.kopylov.daisyplanet.appearense;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ru.kopylov.daisyplanet.model.Planet;

/**
 * Created by sergey on 17.10.17.
 */
public class Populator implements EventHandler {
    private final Planet planet;
    private final PlanetLayer pl;
    TemperatureLayer tl;
    InfoLayer il;
    private final GraphicsContext gc;

    private final TitledPane titledPane = new TitledPane();
    private final VBox vBox = new VBox();

    private final Button button = new Button();
    private final TextField white = new TextField();
    private final TextField black = new TextField();
    private final TextField none = new TextField();

    int whiteExpectation =1;
    int blackExpectation =1;
    int noneExpectation =1;

    public Populator(Planet planet, PlanetLayer pl, TemperatureLayer tl, InfoLayer il, GraphicsContext gc) {
        this.planet = planet;
        this.pl = pl;
        this.tl = tl;
        this.il = il;
        this.gc = gc;
        button.setText("Populate");
        button.setLayoutX(1);
        button.setLayoutY(1);
        button.setOnAction(this);

        white.setPrefColumnCount(3);
        black.setPrefColumnCount(3);
        none.setPrefColumnCount(3);

        white.setText("1");
        black.setText("1");
        none.setText("1");

        titledPane.setGraphic(new Label("Populator"));

        vBox.getChildren().add(button);
        HBox hBoxWhite = new HBox();
        HBox hBoxBlack = new HBox();
        HBox hBoxNone = new HBox();

        hBoxWhite.getChildren().add(white);
        hBoxWhite.getChildren().add(new Label(" white expectation"));

        hBoxBlack.getChildren().add(black);
        hBoxBlack.getChildren().add(new Label(" black expectation"));

        hBoxNone.getChildren().add(none);
        hBoxNone.getChildren().add(new Label(" none expectation"));
        vBox.getChildren().addAll(hBoxWhite, hBoxBlack, hBoxNone);
        titledPane.setContent(vBox);
    }

    public TitledPane getPane(){
        return titledPane;
    }



    @Override
    public void handle(Event event) {
        updateNumbers();
        planet.populate(whiteExpectation, blackExpectation, noneExpectation);
        pl.setColors(planet);
        pl.ekspose(gc);

        tl.ekspose(gc);

        il.ekspose(gc);
    }

    private void updateNumbers(){
        try {
            whiteExpectation = Math.abs(Integer.parseInt(white.getText()));
            blackExpectation = Math.abs(Integer.parseInt(black.getText()));
            noneExpectation = Math.abs(Integer.parseInt(none.getText()));

        } catch (NumberFormatException e){
            e.printStackTrace();
        }
    }
}
