package Figures.FabricMethod;

import Figures.Figure;
import Figures.Point;
import Figures.Polygon;

import java.util.ArrayList;

public class PolygonCreator implements ICreateFigure{

    public Figure create(ArrayList<Point> points) {
        return new Polygon(points);
    }

}
