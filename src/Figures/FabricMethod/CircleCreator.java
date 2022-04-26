package Figures.FabricMethod;

import Figures.Circle;
import Figures.Figure;
import Figures.Point;

import java.util.ArrayList;

public class CircleCreator implements ICreateFigure {

    //fixme возникают проблемы, если не экстэндю класс - extends FigureCreator
    //fixme почему не создаем конструктор?
//    public CircleCreator (ArrayList<Point> points) {
//        this.points = points;
//    }

    @Override
    public Figure create(ArrayList<Point> points) {
        return new Circle(points);
    }
}

//Мэйн вызывает интерфейс -> интерфейс вызывает класс, который выбирает метод создания (здесь прописываются условия)
// -> класс возвращает класс с методом создания -> метод создания запускает класс конкретной фигуры
// класс, который выбирает методы и классы с методами создания реализуют интерфейс
