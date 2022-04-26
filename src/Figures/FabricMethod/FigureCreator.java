package Figures.FabricMethod;

import Figures.Figure;
import Figures.Point;
import Figures.Rectangle;

import java.util.ArrayList;

public class FigureCreator implements ICreateFigure{
//    FigureCreator creator; //fixme - почему не здесь?
        @Override
    public Figure create(ArrayList<Point> points) {
        ICreateFigure creator; //fixme WTF????????????
            // почему не FigureCreator или CircleCreator???

        if (points.size() == 2) {
            creator = new CircleCreator();
        }
        else if (points.size() == 3) {
            creator = new TriangleCreator();
        }
        else if (points.size() == 4) {
            creator = new RectangleCreator();
        }
        else if (points.size() > 4) {
            creator = new PolygonCreator();
        }
        else {
            return null;
        }
        return creator.create(points);
    }
}
