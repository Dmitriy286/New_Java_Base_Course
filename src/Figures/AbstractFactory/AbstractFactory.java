package Figures.AbstractFactory;

import Figures.FabricMethod.ICreateFigure;
import Figures.Figure;
import Figures.Point;
import Figures.Polygon;
import Figures.Rectangle;

import java.util.ArrayList;

public class AbstractFactory implements IFigureFactory {
    String theme;

//    public AbstractFactory (String theme) {
//        this.theme = theme;
//    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Figure createRectangle(ArrayList<Point> points) {
        IFigureFactory factory = null;
        if (theme == "red") {
            factory = new RedFiguresFactory();
        } else if (theme == "blue") {
            factory = new BlueFiguresFactory();
        }
        return factory.createRectangle(points);
    }

    public Figure createPolygon(ArrayList<Point> points) {
        IFigureFactory factory = null;
        if (theme == "red") {
            factory = new RedFiguresFactory();
        } else if (theme == "blue") {
            factory = new BlueFiguresFactory();
        }
        return factory.createPolygon(points);
    }


}
