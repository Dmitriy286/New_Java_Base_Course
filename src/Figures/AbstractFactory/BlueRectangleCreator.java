package Figures.AbstractFactory;

import Figures.Figure;
import Figures.Point;
import Figures.Polygon;
import Figures.Rectangle;

import java.util.ArrayList;

public class BlueRectangleCreator implements IRectangle {
    @Override
    public Figure createRectangle(ArrayList<Point> points) {
        Figure rectangle = new Rectangle(points);
        rectangle.setColor("blue");
        return rectangle;
    }

}
