package Figures;

import Figures.Calculations.IRotatable;

import java.util.ArrayList;

public class Rectangle extends Figure {

    public Rectangle () {
        super();
    }

    public Rectangle (ArrayList<Point> pointsList) {
        super(pointsList);
    }


//    @Override
//    public String toString() {
//        return "Rectangle: " + "точка a: " + getPoint("p1") + ", точка b: " + getPoint("p2")
//                + ", точка c: " + getPoint("p3") + ". Мой цвет: " + color;
//    }
//
//    public Map<String, Point> getPointsMap() {
//        Map<String, Point> pointsMap = new HashMap<String, Point>();
//        int number = 1;
//        for (var point: pointsList) {
//            pointsMap.put("p" + number, point);
//            number += 1;
//        }
//        return pointsMap;
//    }
//
//    public Point getPoint(String p) {
//        return getPointsMap().get(p);
//    }
}


