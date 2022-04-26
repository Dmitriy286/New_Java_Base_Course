package Figures.FabricMethod;

import Figures.Figure;
import Figures.Point;
import Figures.Rectangle;

import java.util.ArrayList;

public interface ICreateFigure {
    public Figure create(ArrayList<Point> points);
}
