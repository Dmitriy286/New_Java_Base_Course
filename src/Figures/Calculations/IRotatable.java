package Figures.Calculations;

import Figures.Figure;
import Figures.Point;

import java.util.ArrayList;

public interface IRotatable {
    public void rotate(double angle, boolean direction);
    public ArrayList<Point> drawBoundingBox();
    public ArrayList<Point> findDiagonal();
    public Point findCentre();
    public Point newCoordinatesCalculating(Point point, double angle, boolean direction);

}

// 1. Сравниваем расстояния между всеми точками.
// 2. Находим самую длинную диагональ.
// 3. Центр этой диагонали будет являться центром для поворота.
// 4. Рассчитываем по формулам нове координаты (направление задаем через булевскую переменную) точек.
