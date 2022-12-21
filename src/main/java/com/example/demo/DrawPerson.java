package com.example.demo;

import com.example.demo.enums.ErrorNumber;
import javafx.scene.canvas.GraphicsContext;

import java.util.HashMap;
import java.util.function.Consumer;

public class DrawPerson {
    private final HashMap<ErrorNumber, Consumer<GraphicsContext>> drawingMap = new HashMap<ErrorNumber, Consumer<GraphicsContext>>() {{
        put(ErrorNumber.ERROR_ONE_DRAWING_THE_FLOOR, ((gc) -> addLineToPerson(gc, getTheFloor(gc.getCanvas().getHeight(), gc.getCanvas().getWidth()))));
        put(ErrorNumber.ERROR_TWO_DRAWING_THE_POLL, ((gc) -> addLineToPerson(gc, getThePoll(gc.getCanvas().getHeight(), gc.getCanvas().getWidth()))));
        put(ErrorNumber.ERROR_THREE_DRAWING_THE_POLL_ROOF, ((gc) -> addLineToPerson(gc, getTheRoof(gc.getCanvas().getHeight(), gc.getCanvas().getWidth()))));
        put(ErrorNumber.ERROR_FOUR_DRAWING_THE_CABLE_OF_LOOP, ((gc) -> addLineToPerson(gc, getTheLoop(gc.getCanvas().getHeight(), gc.getCanvas().getWidth()))));
        put(ErrorNumber.ERROR_FIVE_DRAWING_THE_HEAD_OF_PERSON, ((gc) -> addOvalToPerson(gc, getTheHeadOfThePerson(gc.getCanvas().getHeight(), gc.getCanvas().getWidth()))));
        put(ErrorNumber.ERROR_SIX_DRAWING_THE_BODY, ((gc) -> addLineToPerson(gc, getTheBodyOfThePerson(gc.getCanvas().getHeight(), gc.getCanvas().getWidth()))));
        put(ErrorNumber.ERROR_SEVEN_DRAWING_LEFT_HAND, ((gc) -> addLineToPerson(gc, getTheLeftHandOfPerson(gc.getCanvas().getHeight(), gc.getCanvas().getWidth()))));
        put(ErrorNumber.ERROR_EIGHT_DRAWING_RIGHT_HAND, ((gc) -> addLineToPerson(gc, getTheRightHandOfPerson(gc.getCanvas().getHeight(), gc.getCanvas().getWidth()))));
        put(ErrorNumber.ERROR_NINE_DRAWING_LEFT_LEG, ((gc) -> addLineToPerson(gc, getTheLeftLegOfPerson(gc.getCanvas().getHeight(), gc.getCanvas().getWidth()))));
        put(ErrorNumber.ERROR_TEN_DRAWING_RIGHT_LEG, ((gc) -> addLineToPerson(gc, getTheRightLegOfPerson(gc.getCanvas().getHeight(), gc.getCanvas().getWidth()))));
    }};

    public void drawingSelector(ErrorNumber errorNumber, GraphicsContext gc) {
        drawingMap.get(errorNumber).accept(gc);
    }

    private void addLineToPerson(GraphicsContext gc, CoordinatesWrapper coordinatesWrapper) {
        gc.strokeLine(coordinatesWrapper.getX1(), coordinatesWrapper.getY1(), coordinatesWrapper.getX2(), coordinatesWrapper.getY2());

    }

    private void addOvalToPerson(GraphicsContext gc, CoordinatesWrapper coordinatesWrapper) {
        gc.strokeOval(coordinatesWrapper.getX1(), coordinatesWrapper.getY1(), coordinatesWrapper.getX2(), coordinatesWrapper.getY2());
    }

    private CoordinatesWrapper getTheFloor(double height, double width) {
        return new CoordinatesWrapper(width - 400, height, width - 200, height);
    }

    private CoordinatesWrapper getThePoll(double height, double width) {
        return new CoordinatesWrapper(width - 370, height, width - 370, height - 230);
    }

    private CoordinatesWrapper getTheRoof(double height, double width) {
        return new CoordinatesWrapper(width - 370, height - 230, width - 260, height - 230);
    }

    private CoordinatesWrapper getTheLoop(double height, double width) {
        return new CoordinatesWrapper(width - 260, height - 230, width - 260, height - 170);
    }

    private CoordinatesWrapper getTheHeadOfThePerson(double height, double width) {
        return new CoordinatesWrapper(width - 280, height - 170, width - 560, height - 250);
    }

    private CoordinatesWrapper getTheBodyOfThePerson(double height, double width) {
        return new CoordinatesWrapper(width - 260, height - 140, width - 260, height - 70);
    }

    private CoordinatesWrapper getTheLeftHandOfPerson(double height, double width) {
        return new CoordinatesWrapper(width - 260, height - 120, width - 280, height - 90);
    }

    private CoordinatesWrapper getTheRightHandOfPerson(double height, double width) {
        return new CoordinatesWrapper(width - 260, height - 120, width - 240, height - 90);
    }

    private CoordinatesWrapper getTheLeftLegOfPerson(double height, double width) {
        return new CoordinatesWrapper(width - 260, height - 70, width - 280, height - 50);
    }

    private CoordinatesWrapper getTheRightLegOfPerson(double height, double width) {
        return new CoordinatesWrapper(width - 260, height - 70, width - 240, height - 50);
    }
}
