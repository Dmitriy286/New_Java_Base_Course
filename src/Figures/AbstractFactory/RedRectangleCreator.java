package Figures.AbstractFactory;

import Figures.Figure;
import Figures.Point;
import Figures.Rectangle;

import java.util.ArrayList;

public class RedRectangleCreator implements IRectangle {
    @Override
    public Figure createRectangle(ArrayList<Point> points) {
        Figure rectangle = new Rectangle(points);
        rectangle.setColor("red");
        return rectangle;
    }

}
