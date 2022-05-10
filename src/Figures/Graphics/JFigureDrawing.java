package Figures.Graphics;

import Figures.Circle;
import Figures.Figure;
import Figures.Writer.FigureFileInfo;
import Figures.Writer.JSON_Serialization;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class JFigureDrawing extends JPanel {
    private ArrayList<Figure> figureList;
    int multiX;
    int multiY;

    public JFigureDrawing(ArrayList<Figure> figureList) {
        super();
        this.figureList = figureList;
    }

//    public void setFigureList(ArrayList<Figure> figureList) {
//        this.figureList = figureList;
//    }

    public void paint(Graphics g) {
        int width = this.getWidth();
        int height = this.getHeight();
        Graphics figurePane = g.create(0, 0, width, height);
        drawGrid(figurePane, width, height);
        drawAxis(figurePane, width, height);
        g.setColor(Color.RED);
        BasicStroke bs = (new BasicStroke(2));
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(bs);
        if (figureList.size() > 0) {
            for (var figure : figureList) {
                switch (figure.getColor()) {
                    case null:
                        g.setColor(Color.BLACK);
                        break;
                    case "Красный":
                        g.setColor(Color.RED);
                        break;
                    case "Синий":
                        g.setColor(Color.BLUE);
                        break;
//                    case "Зеленый":
//                        g.setColor(Color.GREEN);
//                        break;
                    case "Оранжевый":
                        g.setColor(Color.ORANGE);
                        break;
//                    case "Pink":
//                        g.setColor(Color.PINK);
//                        break;
//                    case "Yellow":
//                        g.setColor(Color.YELLOW);
//                        break;
                    case "Голубой":
                        g.setColor(Color.CYAN);
                        break;
                    default:
                        g.setColor(Color.BLACK);
                }

                if (figure.getPointsList().size() == 2) {
                    Circle circle = (Circle)figure;
                    g.drawOval((int) (circle.getPointsList().get(0).getX() - circle.getRadius()) + getWidth() / 2,
                             (getHeight() / 2) - (int)(circle.getPointsList().get(0).getY() + circle.getRadius()), //250 650
                            (int) circle.getDiametr(), (int) circle.getDiametr()
                    );
                } else {
                    for (int i = 0; i < figure.getPointsList().size() - 1; i++) {
                        g.drawLine((int) figure.getPointsList().get(i).getX() + getWidth() / 2,
                                getHeight() / 2 - (int) figure.getPointsList().get(i).getY(),
                                (int) figure.getPointsList().get(i + 1).getX() + getWidth() / 2,
                                getHeight() / 2 - (int) figure.getPointsList().get(i + 1).getY());
                    }
                    g.drawLine((int) figure.getPointsList().get(figure.getPointsList().size() - 1).getX() + getWidth() / 2,
                            getHeight() / 2 - (int) figure.getPointsList().get(figure.getPointsList().size() - 1).getY(),
                            (int) figure.getPointsList().get(0).getX() + getWidth() / 2,
                            getHeight() / 2 - (int) figure.getPointsList().get(0).getY());
                }
            }
        }
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

    public void multiplicatorCalculating( {
        double maxX = figureList.get(0).getPointsList().get(0).getX();

        for (var figure: this.figureList) {
            for (var point: figure.getPointsList()) {
                if (point.getX() > maxX) {
                    maxX = point.getX();
                }
            }
    })

    public void repaintFigures(ArrayList<Figure> figureList) {
        this.figureList = figureList;
        this.revalidate();
        this.repaint();
    }

}
