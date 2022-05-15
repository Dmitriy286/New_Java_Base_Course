package Figures;

import Figures.Calculations.IMovable;
import Figures.Calculations.IRotatable;
import Figures.Calculations.IScalable;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static java.lang.Math.sin;

@JsonTypeInfo
        (use = JsonTypeInfo.Id.CLASS,
                property = "classNameExtenral")
@JsonSubTypes(
        {
        @JsonSubTypes.Type(value = Triangle.class, name = "Triangle"),
        @JsonSubTypes.Type(value = Rectangle.class, name = "Rectangle"),
        @JsonSubTypes.Type(value = Pentangle.class, name = "Pentangle"),
        @JsonSubTypes.Type(value = Polygon.class, name = "Polygon"),
        @JsonSubTypes.Type(value = Circle.class, name = "Circle"),

        }
        )

@JsonAutoDetect
public abstract class Figure implements Serializable, IRotatable, IScalable, IMovable {
    @Serial
    private static final long serialVersionUID = 1L;
    ArrayList<Point> pointsList;
    private String color;

    public Figure () {

    }

    public Figure (ArrayList<Point> pointsList) {
        this.pointsList = pointsList;
    }

    public void setPointsList(ArrayList<Point> pointsList) {
        this.pointsList = pointsList;
        //fixme - наверное надо добавить что-то? вызов конструктора?
    }

    public ArrayList<Point> getPointsList() {
        return this.pointsList;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
    return "Привет, я " + this.getClass().getSimpleName() + " с точками: " + this.pointsList + ". Мой цвет: " + this.color;
    }

    public Point getNextPoint(int index) {
        if (index == pointsList.size() - 1) {
            return pointsList.get(0);
        }
       else {
           return pointsList.get(index + 1);
        }
    }

//    public Point getNextPointTwo(Point point) {
//        if (index == pointsList.size() - 1) {
//            return pointsList.get(0);
//        }
//        else {
//            return pointsList.get(index + 1);
//        }
//    }

    public static double getSideLength(Point one, Point two) {
        double x1 = one.getX();
        double y1 = one.getY();
        double x2 = two.getX();
        double y2 = two.getY();

        double sideLength = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));

        return sideLength;
    }

    @JsonIgnore
    public double getPerimetr() {
        double perimetr = 0;
        int index = 0;
        for (var element: pointsList) {
            perimetr += getSideLength(element, getNextPoint(index));
            index += 1;
        }
        return perimetr;
    }

    @JsonIgnore
    public double getSquare() {
        double firstSum = 0;
        double secondSum = 0;
        double square = 0;
        int index = 0;
        for (var point: pointsList) {
            firstSum += point.getX() * getNextPoint(index).getY();
            secondSum += point.getY() * getNextPoint(index).getX();
            index += 1;
        }
        square = Math.abs(firstSum - secondSum) / 2;
        return square;
    }
    @Override
    public Figure rotate(double angle, boolean direction) {
            ArrayList<Point> newPointsList = new ArrayList<>();
            for (var point : this.pointsList) {
                double centreX = findCentre().getX();
                double centreY = findCentre().getY();
                double x2 = point.getX();
                double y2 = point.getY();

                newPointsList.add(new Point(centreX + ((x2 - centreX) * Math.cos(angle) - (y2 - centreY) * Math.sin(angle)),
                        centreY + ((x2 - centreX) * Math.sin(angle) + (y2 - centreY) * Math.cos(angle))));
            }
            this.setPointsList(newPointsList);
            return this;
        }

    //новый вариант
//    public void rotate (double angle, boolean direction){
//        //поворот фигуры через поворот точек по формуле:
//        // X'=Xo+(X1-Xo)∗cos(ϕ)−(Y1-Yo)∗sin(ϕ)
//        // Y'=Yo +(X1-Xo)∗sin(ϕ)+(Y1-Yo)∗cos(ϕ)
////        ArrayList <Point> buffer = this.pointsList;
//        ArrayList <Point> newPointsList = new ArrayList<>();
//        if (ang > 0 && ang < 360 && buffer.size() > 2){
//            Point centre = this.findBarCentre();
//            double xC = centre.getX();
//            double yC = centre.getY();
//            double centreX = findCentre().getX();
//            double centreY = findCentre().getY();
//            buffer.replaceAll( x -> {double a = x.getX() - xC; double b = x.getY() - yC;
//                x.setX(xC + a * Math.cos(Math.toRadians(ang)) - b * Math.sin(Math.toRadians(ang)));
//                x.setY(yC + a * Math.sin(Math.toRadians(ang)) + b * Math.cos(Math.toRadians(ang)));
//                return x;});
//            this.nPoint = buffer;
//        }
//        else if (buffer.size() == 2) System.out.println("Круг есть круг, что его крутить то!");
//        else
//            System.out.println("Ошибка ввода градусов!");
//    }

//    @Override
//    public Figure rotate(double angle, boolean direction) {
//        String direct = "вправо";
//        if (!direction) {
//            direct = "влево";
//        }
//
//        ArrayList<Point> newPointsList = new ArrayList<>();
//        for (var point: this.pointsList) {
//            newPointsList.add(this.newCoordinatesCalculating(point, angle, direction));
//
//        }
////        this.pointsList = newPointsList;
//        this.setPointsList(newPointsList);
//
//        System.out.println("Я - " + this.getClass().getSimpleName() + ", развернутый на " + angle + " радиан " + direct + ".\n"
//                + this);
//        return this;
//    }

    @Override
    public Figure scale(double factor) {
        double xCentre = this.findCentre().getX();
        double yCentre = this.findCentre().getY();
        double xNew;
        double yNew;
        ArrayList<Point> newPointsList = new ArrayList<>();
        for (var point: this.pointsList) {
            xNew = xCentre + (point.getX() - xCentre) * factor;
            yNew = yCentre + (point.getY() - yCentre) * factor;
            newPointsList.add(new Point(xNew, yNew));
        }
        this.setPointsList(newPointsList);

        System.out.println("Я - " + this.getClass().getSimpleName() + ", увеличенный в " + factor + " раз " + ".\n"
                + this);

        return this;
    }

    @Override
    public Figure move(int factor, int vector) {
            ArrayList<Point> newPointsList = new ArrayList<>();
            for (var point: this.pointsList) {
                newPointsList.add(this.newMoveCoordinatesCalculating(point, factor, vector));
            }
            this.setPointsList(newPointsList);

            return this;
        }


    public Point newMoveCoordinatesCalculating(Point point, int factor, int vector) {
        Point newPoint = new Point();
        if (vector == 1) {
            newPoint = new Point(point.getX(), point.getY() + factor);
        }

        else if (vector == 2) {
            newPoint = new Point(point.getX(), point.getY() - factor);
        }

        else if (vector == 3) {
            newPoint = new Point(point.getX() - factor, point.getY());
        }

        else {
            newPoint = new Point(point.getX() + factor, point.getY());
        }

        return newPoint;
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

    @Override
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

    @Override
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
        double radius = getSideLength(findCentre(), point);

//        h = смещение точки по оси абсцисс (в - или в +)
//        m = смещение точки по оси ординат

        double c = 2 * radius * sin(angle/2);
        double h = (c * Math.sqrt(4 * radius * radius - c * c)) / (2 * radius);
        double m = Math.sqrt(c * c - h * h);
        if (!direction) {
            h = -h; //todo как поменять знак?
        }
        //новые координаты:
        Point newPoint = new Point(point.getX() + m, point.getY() + h);
        return newPoint;
    }


}
