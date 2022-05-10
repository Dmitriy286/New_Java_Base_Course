package Figures;

import Figures.Calculations.IMovable;
import Figures.Calculations.IRotatable;
import Figures.Calculations.IScalable;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Triangle extends Figure  implements IRotatable, IScalable, IMovable {

    public Triangle () {
        super();
    }

    public Triangle (ArrayList<Point> pointsList) {
        super(pointsList);
    }

    @Override
    public String toString() {
        return "Triangle: " + "точка a: " + getPoint("p1") + ", точка b: " + getPoint("p2") + ", точка c: " + getPoint("p3");
    }
    @JsonIgnore
    public Map<String, Point> getPointsMap() {
        Map<String, Point> pointsMap = new HashMap<String, Point>();
        int number = 1;
        for (var point: pointsList) {
            pointsMap.put("p" + number, point);
            number += 1;
        }
        return pointsMap;
    }

    public Point getPoint(String p) {
        return getPointsMap().get(p);
    }

}


