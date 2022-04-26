package Figures.AbstractFactory;

import Figures.Figure;
import Figures.Point;
import Figures.Polygon;
import Figures.Rectangle;

import java.util.ArrayList;

public interface IPolygon {

    public Figure createPolygon(ArrayList<Point> points);
}
