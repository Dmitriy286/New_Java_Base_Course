package Figures;

import Figures.Calculations.IMovable;
import Figures.Calculations.IRotatable;
import Figures.Calculations.IScalable;

import java.util.ArrayList;

public class Polygon extends Figure  implements IRotatable, IScalable, IMovable {
    public Polygon () {
        super();
    }

    public Polygon (ArrayList<Point> pointsList) {
        super(pointsList);
    }
}
