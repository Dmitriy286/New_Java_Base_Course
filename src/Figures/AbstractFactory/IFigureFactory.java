package Figures.AbstractFactory;

import Figures.Figure;
import Figures.Point;
import Figures.Polygon;
import Figures.Rectangle;

import java.util.ArrayList;

public interface IFigureFactory {

    public Figure createRectangle(ArrayList<Point> points);
    public Figure createPolygon(ArrayList<Point> points);


}
