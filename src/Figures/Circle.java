package Figures;

import java.util.ArrayList;

public class Circle extends Figure{
    double radius;

    public Circle () {
        super();
    }

    public Circle(ArrayList<Point> pointsList) {
        super(pointsList);
        this.radius = getRadius();
    }

    public double getRadius() {
        double x1 = pointsList.get(0).getX();
        double y1 = pointsList.get(0).getY();
        double x2 = pointsList.get(1).getX();
        double y2 = pointsList.get(1).getY();


        double radius = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        return radius;
    }

    public double getDiametr() {
        double diameter;
        diameter = this.radius * 2;
        return diameter;
    }

    public double getCircumference() {
        double circumference;
        circumference = 2 * Math.PI * this.radius;
        return circumference;
    }

    @Override
    public double getSquare() {
        double square;
        square = Math.PI * Math.pow(this.radius, 2);
        return square;
    }

    @Override
    public String toString() {
    return "Привет, я " + getClass().getName() + " с точками: " + this.pointsList;
    }

}
