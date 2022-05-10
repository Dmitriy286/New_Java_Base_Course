package Figures.Graphics;

import Figures.Circle;
import Figures.Figure;
import Figures.Point;
import Figures.Rectangle;
import Figures.Triangle;
import Figures.Polygon;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class CreateFigure extends Figure {
    ArrayList<Point> pointsList;
    Figure newFigure;

    public CreateFigure(ArrayList<Point> pointsList) {
        this.pointsList = pointsList;
    }

    public Figure newFigure() {
        if (this.pointsList.size() == 2) {
            newFigure = new Circle(pointsList);
        } else if (this.pointsList.size() == 3) {
            newFigure =  new Triangle(pointsList);
        } else if (this.pointsList.size() == 4) {
            newFigure =  new Rectangle(pointsList);
        } else if (this.pointsList.size() >= 5) {
            newFigure =  new Polygon(pointsList);
        }

    return newFigure;
    }
}
