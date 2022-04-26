package Figures.AbstractFactory;

import Figures.FabricMethod.FigureCreator;
import Figures.FabricMethod.PolygonCreator;
import Figures.Figure;
import Figures.Point;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Point penta1 = new Point(-3, -2);
        Point penta2 = new Point(-1, 4);
        Point penta3 = new Point(6, 1);
        Point penta4 = new Point(3, 10);
        Point penta5 = new Point(-4, 9);

        ArrayList<Point> arrayList2 = new ArrayList<Point>(0);

        arrayList2.add(penta1);
        arrayList2.add(penta2);
        arrayList2.add(penta3);
        arrayList2.add(penta4);
        arrayList2.add(penta5);

        AbstractFactory factory = new AbstractFactory();

        factory.setTheme("blue");
        Figure newFigure = factory.createPolygon(arrayList2);

        System.out.println(newFigure);
    }



}
