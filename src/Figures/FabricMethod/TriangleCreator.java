package Figures.FabricMethod;

import Figures.Figure;
import Figures.Point;
import Figures.Triangle;

import java.util.ArrayList;

public class TriangleCreator implements ICreateFigure {

    //todo возможно, тут нужен конструктор?

    @Override
    public Figure create(ArrayList<Point> points) {
        return new Triangle(points);
    }
}
