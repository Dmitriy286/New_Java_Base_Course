package Figures.Writer;

import Figures.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {


    public void readFromFile(String fileName) throws IOException {
        FileReader reader = new FileReader(fileName);
        BufferedReader bufReader = new BufferedReader(reader);
        String fileContent;
        while ((fileContent = bufReader.readLine()) != null) {
            int splitIndex = fileContent.indexOf(":") + 1;
            String pointString = fileContent.substring(splitIndex, fileContent.length());
            String newPointString = pointString.replace(")", "!");
            String newPointStringTwo = newPointString.replace("(", "");
            String newPointStringThree = newPointStringTwo.replaceAll("\\s+","");
            ArrayList<Point> pointArray = new ArrayList<Point>();
            String[] numbersString = newPointStringThree.split("!");
            int i = 0;
            for (String value: numbersString) {
                String[] values = value.split(";");
                double x = Double.parseDouble(values[0]);
                double y = Double.parseDouble(values[1]);
                Point p = new Point(x, y);
                pointArray.add(p);
            }
            Figure figure = null;
            if (pointArray.size() == 2) {
                figure = new Circle(pointArray);
            }

            else if (pointArray.size() == 3) {
                figure = new Triangle(pointArray);
            }

            else if (pointArray.size() == 4) {
                figure = new Rectangle(pointArray);
            }

            else if (pointArray.size() > 4) {
                figure = new Polygon(pointArray);
            }

            else {
                System.out.println("Unable to create figure");
            }

            System.out.println(figure);

        }
    }
}
