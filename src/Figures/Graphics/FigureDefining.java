package Figures.Graphics;

import Figures.Circle;
import Figures.Figure;
import Figures.Point;

import java.util.ArrayList;

public class FigureDefining {
    ArrayList<Figure> figureList;
    ArrayList<Figure> foundFigure;
    ArrayList<Point> pointsList;
    Point point;
    int index = -1;

    public FigureDefining (ArrayList<Figure> figureList, Point point){
        this.point = point;
        this.figureList = figureList;
    }

    public void scanningFigures() {
        foundFigure = new ArrayList<>();
        for (var figure : this.figureList) {
            index += 1;
            if (figure instanceof Circle) {
                if (isPartOfCircle(figure)) {
                    foundFigure.add(figure);
                    break;
                }
            }
            else {
                    if (isPartOfFigure(figure)) {
                        foundFigure.add(figure);
                        break;
                    }
                }
            }
        }

    public ArrayList<Point> findLine() {
        ArrayList<Point> mainLinePoints = new ArrayList<>();
        mainLinePoints.add(this.point);
        Point point2 = new Point(findMaxX(), this.point.getY());
        mainLinePoints.add(point2);

        return mainLinePoints;
    }

    public double findMaxX() {
        double maxX = this.pointsList.get(0).getX();
        for (var figure: this.figureList) {
            for (var point: figure.getPointsList()) {
                if (point.getX() > maxX) {
                    maxX = point.getX();
                }
            }
        }
        return maxX;
    }

    public boolean isPartOfFigure(Figure figure) {
        int count = 0;
        if (figure.getPointsList().size() == 2) {
            return isPartOfCircle(figure);
        }
        else {
            this.pointsList = figure.getPointsList();

            for (int i = 0; i < this.pointsList.size(); i++) {
                ArrayList<Point> sideLinePoints = new ArrayList<>();
                sideLinePoints.add(this.pointsList.get(i));
                sideLinePoints.add(figure.getNextPoint(i));
                count += this.areCrossedLines(findLine(), sideLinePoints);
            }
            return count % 2 != 0;
        }
    }

    public int areCrossedLines(ArrayList<Point> mainLinePoints, ArrayList<Point> sideLinePoints) {
        double mainXCoordinateOne = mainLinePoints.get(0).getX(); //x1
        double mainXCoordinateTwo = mainLinePoints.get(1).getX(); //x2
        double mainYCoordinateOne = mainLinePoints.get(0).getY(); //y1
        double mainYCoordinateTwo = mainLinePoints.get(1).getY(); //y2

        double sideXCoordinateOne = Math.min(sideLinePoints.get(0).getX(), sideLinePoints.get(1).getX()); //x3
        double sideXCoordinateTwo = Math.max(sideLinePoints.get(0).getX(), sideLinePoints.get(1).getX());  //x4

        double sideYCoordinateOne = (sideXCoordinateOne == sideLinePoints.get(0).getX())
                ? sideLinePoints.get(0).getY() : sideLinePoints.get(1).getY(); //y3
        double sideYCoordinateTwo = (sideXCoordinateTwo == sideLinePoints.get(1).getX())
                ? sideLinePoints.get(1).getY() : sideLinePoints.get(0).getY();

        if ((mainYCoordinateTwo - mainYCoordinateOne) / (mainXCoordinateTwo - mainXCoordinateOne) ==
               (sideYCoordinateTwo - sideYCoordinateOne) / (sideXCoordinateTwo - sideXCoordinateOne)) {
            return 0;
        }
//вариант 1
//        double xCross = ((mainXCoordinateOne * mainYCoordinateTwo - mainXCoordinateTwo * mainYCoordinateOne)
//                * (sideXCoordinateTwo - sideXCoordinateOne) - (sideXCoordinateOne * sideYCoordinateTwo - sideXCoordinateTwo
//                * sideYCoordinateOne) * (mainXCoordinateTwo - mainXCoordinateOne))
//                / ((mainYCoordinateOne - mainYCoordinateTwo) * (sideXCoordinateTwo - sideXCoordinateOne)
//                - (sideYCoordinateOne - sideYCoordinateTwo) * (mainXCoordinateTwo - mainXCoordinateOne));

        //        double yCross = ((sideYCoordinateOne - sideYCoordinateTwo) * xCross
//                - (sideXCoordinateOne * sideYCoordinateTwo - sideXCoordinateTwo * sideXCoordinateOne))
//                / (sideXCoordinateTwo - sideXCoordinateOne);

        //        if ((mainYCoordinate >= sideLinePoints.get(0).getY()) && (mainYCoordinate <= sideLinePoints.get(1).getY()) ||
//        (mainYCoordinate <= sideLinePoints.get(0).getY()) && (mainYCoordinate >= sideLinePoints.get(1).getY())) {
//                if (sideXCoordinateOne >= mainXCoordinateOne && sideXCoordinateOne <= mainXCoordinateTwo ||
//                        sideXCoordinateTwo >= mainXCoordinateOne && sideXCoordinateTwo <= mainXCoordinateTwo) {
//                    return 1;
//                }
//                else {
//                return 0;
//                }
//        }
//        else {
//        return 0;
//        }

        //вариант 2

//        double xCross = (((sideXCoordinateTwo - sideXCoordinateOne) * (mainYCoordinateOne - sideYCoordinateOne) -
//                (sideYCoordinateTwo - sideYCoordinateOne) * (mainXCoordinateOne - sideXCoordinateOne)) /
//                ((sideYCoordinateTwo - sideYCoordinateOne) * (mainXCoordinateTwo - mainXCoordinateOne) -
//                (sideXCoordinateTwo - sideXCoordinateOne) * (mainYCoordinateTwo - mainYCoordinateOne))) *
//                (mainXCoordinateTwo - mainXCoordinateOne) + mainXCoordinateOne;
//
//        double yCross = (((sideXCoordinateTwo - sideXCoordinateOne) * (mainYCoordinateOne - sideYCoordinateOne) -
//                (sideYCoordinateTwo - sideYCoordinateOne) * (mainXCoordinateOne - sideXCoordinateOne)) /
//                ((sideYCoordinateTwo - sideYCoordinateOne) * (mainXCoordinateTwo - mainXCoordinateOne) -
//                        (sideXCoordinateTwo - sideXCoordinateOne) * (mainYCoordinateTwo - mainYCoordinateOne))) *
//                (mainYCoordinateTwo - mainYCoordinateOne) + mainYCoordinateOne;

//        if ((((mainXCoordinateOne <= xCross) && (mainXCoordinateTwo >= xCross)
//                && (sideXCoordinateOne <= xCross) && (sideXCoordinateTwo >= xCross)) &&
//                ((mainYCoordinateOne<=yCross) && (mainYCoordinateTwo>=yCross)
//                        && (sideYCoordinateOne<=yCross) && (sideYCoordinateTwo>=yCross)))) {
//            return 1;
//        }
//
//        else {
//            return 0;
//        }


        //вариант 3
        double uA = ((sideXCoordinateTwo - sideXCoordinateOne) * (mainYCoordinateOne - sideYCoordinateOne) -
                (sideYCoordinateTwo - sideYCoordinateOne) * (mainXCoordinateOne - sideXCoordinateOne)) /
                ((sideYCoordinateTwo - sideYCoordinateOne) * (mainXCoordinateTwo - mainXCoordinateOne) -
                        (sideXCoordinateTwo - sideXCoordinateOne) * (mainYCoordinateTwo - mainYCoordinateOne));

        double uB = ((mainXCoordinateTwo - mainXCoordinateOne) * (mainYCoordinateOne - sideYCoordinateOne) -
                (mainYCoordinateTwo - mainYCoordinateOne) * (mainXCoordinateOne - sideXCoordinateOne))
                /
        ((sideYCoordinateTwo - sideYCoordinateOne) * (mainXCoordinateTwo - mainXCoordinateOne) -
                (sideXCoordinateTwo - sideXCoordinateOne) * (mainYCoordinateTwo - mainYCoordinateOne));

        if ((uA >= 0 && uA <= 1) && (uB >= 0 && uB <= 1)) {
            return 1;
        }

        else {
            return 0;
        }
    }

    public boolean isPartOfCircle(Figure figure) {
        Circle circle = (Circle)figure;
        double x0 = circle.getPointsList().get(0).getX();
        double y0 = circle.getPointsList().get(0).getY();

        double radius = circle.getRadius();
        double clickPointX = point.getX();
        double clickPointY = point.getY();

        double straightLength = Math.sqrt((clickPointX - x0) * (clickPointX - x0) +
                    (clickPointY - y0) * (clickPointY - y0));

        return radius > straightLength;
        }
    }


