package Figures.Writer;

import Figures.Figure;
import Figures.Point;
import Figures.Triangle;
import Figures.axisPoint;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Writer {

    public void writeFigureName(Figure figure) throws IOException {

        FileWriter writer = null;
        writer = new FileWriter("Figure Names.txt", true);
//        writer.write("Эта строка по идее не должна распечататься\n");
//        writer.write(" А эта строка по идее должна распечататься\n");
        String result = figure.getClass().getSimpleName() + ": ";
        ArrayList<Point> list = figure.getPointsList();
////        figure.getPointsList().forEach(r -> result += );
        for (var point : list) {
            result += point.toPrintableString();
        }
        writer.append(result + "\n");
        writer.close();
        System.out.println(result);
}
        public void writerLambda() {
        Point p1 = new Point(-3, -2);
        Point p2 = new Point(-1, 4);
        Point p3 = new Point(6, 1);
        Point p4 = new Point(3, 10);
        Point p5 = new Point(-4, 9);

        ArrayList<Point> list = new ArrayList<Point>(Arrays.asList(p1, p2, p3, p4, p5));

        var result = new Object(){String value = "Pentangle: ";};
        list.forEach(r->{
            result.value += r.toPrintableString();
        });
            System.out.println(result.value);
    }

    public void writeFigureNameWithNoDelete(Figure figure) throws IOException {

        BufferedWriter writer = null;
        writer = new BufferedWriter(new FileWriter("Figure Names.txt", true));
        writer.write("-------------------------\n");
        writer.append("Название фигуры: " + figure.getClass().getSimpleName() + "\n");
        writer.close();
    }


}
