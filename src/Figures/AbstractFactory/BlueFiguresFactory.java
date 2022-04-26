package Figures.AbstractFactory;

import Figures.Figure;
import Figures.Point;
import Figures.Polygon;
import Figures.Rectangle;

import java.util.ArrayList;

public class BlueFiguresFactory implements IFigureFactory{


    public Figure createRectangle(ArrayList<Point> points) {
        var creator = new BlueRectangleCreator();
        return creator.createRectangle(points);
    }

    public Figure createPolygon(ArrayList<Point> points) {
        var creator = new BluePolygonCreator();
        return creator.createPolygon(points);
    }

}
