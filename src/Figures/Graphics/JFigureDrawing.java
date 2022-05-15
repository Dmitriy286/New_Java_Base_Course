package Figures.Graphics;

import Figures.Circle;
import Figures.Figure;
import Figures.Point;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class JFigureDrawing extends JPanel {
    private ArrayList<Figure> figureList;
    int multiX = 1;
    int multiY = 1;

    public JFigureDrawing(ArrayList<Figure> figureList) {
        super();
        this.figureList = figureList;
    }

    public void paint(Graphics g) {
        int width = this.getWidth();
        int height = this.getHeight();
        Graphics figurePane = g.create(0, 0, width, height);
        drawGrid(figurePane, width, height);
        drawAxis(figurePane, width, height);
        BasicStroke bs = (new BasicStroke(2));
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(bs);
        if (figureList.size() > 0) {
            for (var figure : figureList) {
                switch (figure.getColor()) {
                    case "Красный" -> g.setColor(Color.RED);
                    case "Синий" -> g.setColor(Color.BLUE);
                    case "Оранжевый" -> g.setColor(Color.ORANGE);
                    case "Голубой" -> g.setColor(Color.CYAN);
                    default -> g.setColor(Color.BLACK);
                }

//                double maxModulX = this.figureList.get(0).getPointsList().get(0).getX();
//                //        double maxModulX = this.figureList.get(0).getPointsList().get(0).getX();
//                double maxModulY = this.figureList.get(0).getPointsList().get(0).getY();
//                //        double maxModulX = this.figureList.get(0).getPointsList().get(0).getX();
//
//                for (var fig : this.figureList) {
//                    for (var point : fig.getPointsList()) {
//                        if (Math.abs(point.getX()) > maxModulX) {
//                            maxModulX = Math.abs(point.getX());
//                        }
//                        if (Math.abs(point.getY()) > maxModulY) {
//                            maxModulY = Math.abs(point.getY());
//                        }
//                    }
//                }
//                this.multiX = (int) (width * 0.95 / maxModulX);
//                this.multiY = (int) (width * 0.95 / maxModulY);

//                multiplicatorCalculating();
//            ArrayList<Point> pointsList = figure.getPointsList();
//            ArrayList<Point> newPointsList = multiplicate(pointsList);
//            if (newPointsList.size() == 2) {
//                int circleMulti = Math.min(multiX, multiY);
//                Circle circle = (Circle)figure;
//                g.drawOval((int) (newPointsList.get(0).getX() - circle.getRadius()) + getWidth() / 2,
//                         (getHeight() / 2) - (int)(newPointsList.get(0).getY() + circle.getRadius()), //250 650
//                        (int) circle.getDiametr(), (int) circle.getDiametr()
//                );
//            }


                if (figure.getPointsList().size() == 2) {
                    int circleMulti = Math.min(multiX, multiY);
                    Circle circle = (Circle)figure;
                    g.drawOval((int) (figure.getPointsList().get(0).getX() - circle.getRadius()) + getWidth() / 2,
                            (getHeight() / 2) - (int)(figure.getPointsList().get(0).getY() + circle.getRadius()), //250 650
                            (int) circle.getDiametr(), (int) circle.getDiametr()
                    );
                }

            else {
//                ArrayList<Point> pointsList = figure.getPointsList();
//                ArrayList<Point> newPointsList = multiplicate(pointsList);
////                multiplicate(figure);
                for (int i = 0; i < figure.getPointsList().size() - 1; i++) {
                    g.drawLine((int) (figure.getPointsList().get(i).getX()) + getWidth() / 2,
                            getHeight() / 2 - (int) (figure.getPointsList().get(i).getY()),
                            (int) (figure.getPointsList().get(i + 1).getX()) + getWidth() / 2,
                            getHeight() / 2 - (int) (figure.getPointsList().get(i + 1).getY()));
                }
                g.drawLine((int) (figure.getPointsList().get(figure.getPointsList().size() - 1).getX()) + getWidth() / 2,
                        getHeight() / 2 - (int) (figure.getPointsList().get(figure.getPointsList().size() - 1).getY()),
                        (int) (figure.getPointsList().get(0).getX()) + getWidth() / 2,
                        getHeight() / 2 - (int) (figure.getPointsList().get(0).getY()));
            }

//              else {
////                ArrayList<Point> pointsList = figure.getPointsList();
////                ArrayList<Point> newPointsList = multiplicate(pointsList);
//////                multiplicate(figure);
//                    for (int i = 0; i < figure.getPointsList().size() - 1; i++) {
//                        g.drawLine((int) (figure.getPointsList().get(i).getX() * this.multiX) + getWidth() / 2,
//                                getHeight() / 2 - (int) (figure.getPointsList().get(i).getY() * this.multiY),
//                                (int) (figure.getPointsList().get(i + 1).getX() * this.multiX) + getWidth() / 2,
//                                getHeight() / 2 - (int) (figure.getPointsList().get(i + 1).getY()) * this.multiY);
//                    }
//                    g.drawLine((int) (figure.getPointsList().get(figure.getPointsList().size() - 1).getX() * this.multiX) + getWidth() / 2,
//                            getHeight() / 2 - (int) (figure.getPointsList().get(figure.getPointsList().size() - 1).getY() * this.multiY),
//                            (int) (figure.getPointsList().get(0).getX() * this.multiX) + getWidth() / 2,
//                            getHeight() / 2 - (int) (figure.getPointsList().get(0).getY()) * this.multiY);
//                }

//            else {
////                ArrayList<Point> pointsList = figure.getPointsList();
////                ArrayList<Point> newPointsList = multiplicate(pointsList);
////                multiplicate(figure);
//                for (int i = 0; i < newPointsList.size() - 1; i++) {
//                    g.drawLine((int) (newPointsList.get(i).getX()) + getWidth() / 2,
//                            getHeight() / 2 - (int) (newPointsList.get(i).getY()),
//                            (int) (newPointsList.get(i + 1).getX()) + getWidth() / 2,
//                            getHeight() / 2 - (int) (newPointsList.get(i + 1).getY()));
//                }
//                g.drawLine((int) (newPointsList.get(newPointsList.size() - 1).getX()) + getWidth() / 2,
//                        getHeight() / 2 - (int) (newPointsList.get(newPointsList.size() - 1).getY()),
//                        (int) (newPointsList.get(0).getX()) + getWidth() / 2,
//                        getHeight() / 2 - (int) (newPointsList.get(0).getY()));
//            }
            }
        }

//        int uniteMulti = Math.min(multiX, multiY);
//        for (int i = 0; i < figure.getPointsList().size() - 1; i++) {
//            g.drawLine((int) (figure.getPointsList().get(i).getX() * uniteMulti) + getWidth() / 2,
//                    getHeight() / 2 - (int) (figure.getPointsList().get(i).getY() * uniteMulti),
//                    (int) (figure.getPointsList().get(i + 1).getX() * uniteMulti) + getWidth() / 2,
//                    getHeight() / 2 - (int) (figure.getPointsList().get(i + 1).getY()) * uniteMulti);
//        }
//        g.drawLine((int) (figure.getPointsList().get(figure.getPointsList().size() - 1).getX() * uniteMulti) + getWidth() / 2,
//                getHeight() / 2 - (int) (figure.getPointsList().get(figure.getPointsList().size() - 1).getY() * uniteMulti),
//                (int) (figure.getPointsList().get(0).getX() * uniteMulti) + getWidth() / 2,
//                getHeight() / 2 - (int) (figure.getPointsList().get(0).getY()) * uniteMulti);
//    }

        else {
            g.drawString("Фигуры удалены", getWidth() / 2 - 20, getHeight() / 2 - 10);
        }
    }

    public void drawGrid(Graphics figurePane, int width, int height) {
        figurePane.setColor(Color.YELLOW);

        for(int x=width/2; x<width; x+=5){
            figurePane.drawLine(x, 0, x, height);
        }
        for(int x=width/2; x>0; x-=5){
            figurePane.drawLine(x, 0, x, height);
        }
        for(int y=height/2; y<height; y+=5){
            figurePane.drawLine(0, y, width, y);
        }
        for(int y=height/2; y>0; y-=5){
            figurePane.drawLine(0, y, width, y);
        }
    }

    public void drawAxis (Graphics figurePane, int width, int height) {
        figurePane.setColor(Color.black);
        figurePane.drawLine(0, height / 2, width, height / 2);
        figurePane.drawLine(width / 2, 0, width / 2, height);
    }

    public void multiplicatorCalculating() {
        double maxModulX = this.figureList.get(0).getPointsList().get(0).getX();
//        double minX = this.figureList.get(0).getPointsList().get(0).getX();
        double maxModulY = this.figureList.get(0).getPointsList().get(0).getY();
//        double minY = this.figureList.get(0).getPointsList().get(0).getY();

        for (var figure : this.figureList) {
            for (var point : figure.getPointsList()) {
                if (Math.abs(point.getX()) > maxModulX) {
                    maxModulX = Math.abs(point.getX());
                }
                if (Math.abs(point.getY()) > maxModulY) {
                    maxModulY = Math.abs(point.getY());
                }
            }
        }
        this.multiX = (int) (this.getWidth() * 0.95 / maxModulX);
        this.multiY = (int) (this.getWidth() * 0.95 / maxModulY);
    }

    public ArrayList<Point> multiplicate(ArrayList<Point> pointsList) {
        multiplicatorCalculating();
        double xCentre = findCentre(pointsList).getX();
        double yCentre = findCentre(pointsList).getY();
        double xNew;
        double yNew;
        ArrayList<Point> newPointsList = new ArrayList<>();
        for (var point: pointsList) {
            xNew = xCentre + (point.getX() - xCentre) * multiX;
            yNew = yCentre + (point.getY() - yCentre) * multiY;
            newPointsList.add(new Point(xNew, yNew));
        }
//        figure.setPointsList(newPointsList);
        return newPointsList;
    }

    public Point findCentre(ArrayList<Point> pointsList) {

        Point pointA = drawBoundingBox(pointsList).get(0);
        Point pointB = drawBoundingBox(pointsList).get(1);
        double x;
        double y;
        x = (pointA.getX() + pointB.getX()) / 2;
        y = (pointA.getY() + pointB.getY()) / 2;
        Point centrePoint = new Point(x, y);
        return centrePoint;
    }

    public ArrayList<Point> drawBoundingBox(ArrayList<Point> pointsList) {
        double minX = pointsList.get(0).getX();
        double maxX = pointsList.get(0).getX();
        double minY = pointsList.get(0).getY();
        double maxY = pointsList.get(0).getY();
        ArrayList<Figures.Point> pointsArray = new ArrayList<>();

        for (var point: pointsList) {
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

//    double maxX = this.figureList.get(0).getPointsList().get(0).getX();
//    double minX = this.figureList.get(0).getPointsList().get(0).getX();
//    double maxY = this.figureList.get(0).getPointsList().get(0).getY();
//    double minY = this.figureList.get(0).getPointsList().get(0).getY();
//
//                for (var fig : this.figureList) {
//        for (var point : fig.getPointsList()) {
//            if (point.getX() > maxX) {
//                maxX = point.getX();
//            }
//            if (point.getX() < minX) {
//                minX = point.getX();
//            }
//            if (point.getY() < minY) {
//                minY = point.getY();
//            }
//        }
//    }
//                this.multiX = (int) (width * 0.95 / (maxX - minX));
//                this.multiY = (int) (width * 0.95 / (maxY - minY));

    public void repaintFigures(ArrayList<Figure> figureList) {
        this.figureList = figureList;
        this.revalidate();
        this.repaint();
    }

}
