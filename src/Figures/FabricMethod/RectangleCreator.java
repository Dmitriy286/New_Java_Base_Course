package Figures.FabricMethod;

import Figures.Figure;
import Figures.Point;
import Figures.Rectangle;

import java.util.ArrayList;

public class RectangleCreator implements ICreateFigure{

    @Override
    public Figure create(ArrayList<Point> points) {
        return new Rectangle(points);
    }

}
