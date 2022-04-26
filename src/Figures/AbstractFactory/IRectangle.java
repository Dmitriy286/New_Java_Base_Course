package Figures.AbstractFactory;

import Figures.Figure;
import Figures.Point;

import java.util.ArrayList;

public interface IRectangle {

    public Figure createRectangle(ArrayList<Point> points);

}
