package Figures.AbstractFactory;

import Figures.Figure;
import Figures.Point;
import Figures.Polygon;
import Figures.Rectangle;

import java.util.ArrayList;

public class BluePolygonCreator implements IPolygon {

    @Override
    public Figure createPolygon(ArrayList<Point> points) {
        Figure polygon = new Polygon(points);
        polygon.setColor("blue");
        return polygon;
    }

}
