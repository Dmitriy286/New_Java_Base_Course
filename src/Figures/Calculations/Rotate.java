package Figures.Calculations;

import Figures.Figure;
import Figures.Point;

import java.util.ArrayList;

import static java.lang.Math.sin;

public class Rotate implements IRotatable {
    ArrayList<Point> pointsList = null;
    Figure figure = null;

    public Rotate (Figure figure) {
        this.pointsList = figure.getPointsList();
        this.figure = figure;
    }

    public void rotate(double angle, boolean direction) {
        String direct = "вправо";
        if (!direction) {
            direct = "влево";
        }

        ArrayList<Point> newPointsList= new ArrayList<Point>();
        for (var point: this.pointsList) {
            newPointsList.add(this.newCoordinatesCalculating(point, angle, direction));
        }
       this.figure.setPointsList(newPointsList);

        System.out.println("Я - " + this.figure.getClass().getSimpleName() + ", развернутый на " + angle + " радиан " + direct + ".\n"
                + this.figure);
    }

    @Override
    public ArrayList<Point> drawBoundingBox() {
        double minX = this.pointsList.get(0).getX();
        double maxX = this.pointsList.get(0).getX();
        double minY = this.pointsList.get(0).getY();
        double maxY = this.pointsList.get(0).getY();
        ArrayList<Point> pointsArray = new ArrayList<>();

        for (var point: this.pointsList) {
            if (point.getX() < minX) {
                minX = point.getX();
            }
            else if (point.getX() > maxX) {
                maxX = point.getX();
            }

            if (point.getY() < minY) {
                minY = point.getY();
            }
            else if (point.getY() > maxY) {
                maxY = point.getY();
            }
        }
        pointsArray.add(new Point(minX, minY));
        pointsArray.add(new Point(maxX, maxY));
        return pointsArray;

    }

    public ArrayList<Point> findDiagonal() {
        ArrayList<Point> diameterPointsArray = new ArrayList<Point>();
        int i = 0;
        double biggestLength = 0;
        Point pointA = null;
        Point pointB = null;
        for (var point: this.pointsList) {
            for (int j = i + 1; j < (this.pointsList.size()); j++) {
                double length = Figure.getSideLength(point, this.pointsList.get(j));
                if (length > biggestLength) {
                    biggestLength = length;
                    pointA = this.pointsList.get(i);
                    pointB = this.pointsList.get(i + 1); //fixme насколько вообще хорошо, что из функции меняются глобальные переменные?
                }
            }
            if (point == this.pointsList.get(this.pointsList.size() - 1)) {
                break;
            }
            i += 1;
        }
        diameterPointsArray.add(pointA);
        diameterPointsArray.add(pointB);
        return diameterPointsArray;
    }

    public Point findCentre() {
//        Point pointA = this.findDiagonal().get(0);
//        Point pointB = this.findDiagonal().get(1);
        Point pointA = this.drawBoundingBox().get(0);
        Point pointB = this.drawBoundingBox().get(1);
        double x;
        double y;
        x = (pointA.getX() + pointB.getX()) / 2;
        y = (pointA.getY() + pointB.getY()) / 2;
        Point centrePoint = new Point(x, y);
        return centrePoint;
    }

    public Point newCoordinatesCalculating(Point point, double angle, boolean direction) {
        double radius = this.figure.getSideLength(findCentre(), point);

//        h = смещение точки по оси абсцисс (в - или в +)
//        m = смещение точки по оси ординат

        double c = 2 * radius * sin(angle/2);
        double h = (c * Math.sqrt(4 * radius * radius - c * c)) / 2 * radius;
        double m = Math.sqrt(c * c - h * h);
        if (!direction) {
            h = -h; //todo как поменять знак?
        }
        //новые координаты:
        Point newPoint = new Point(point.getX() + m, point.getY() + h);
        return newPoint;
    }
}
