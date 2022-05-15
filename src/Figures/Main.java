package Figures;

import Figures.Writer.JSON_Serialization;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

        public static void main(String[] args) throws IOException, ClassNotFoundException {
            Point p1 = new Point(30, 25);
            Point p2 = new Point(40, 100);
            Point p3 = new Point(70, 65);
            Point p4 = new axisPoint(67,80);
            Point p5 = new Point(-100,-50);
//
//            System.out.println(p1.toString()); //нет необходимости вызывать метод toString
//            System.out.println(p2.toString());
//            System.out.println(p3.toString());
//
//            System.out.println(p1);
//            System.out.println(p2);
//            System.out.println(p3);
//            System.out.println(p4);
//
//            System.out.println("-------------");
//            ArrayList<Point> arrayList1 = new ArrayList<Point>(0);
//
//            arrayList1.add(p1);
//            arrayList1.add(p2);
//            arrayList1.add(p3);
//
//
//            ArrayList<Point> arrayList5 = new ArrayList<>((Arrays.asList(p1, p2, p3, p4)));
//
//
//
//
//            Triangle triangle = new Triangle(arrayList1);
//            System.out.println("Площадь треугольника по новой функции: ");
//            System.out.println(triangle.getSquare());
//
//            //todo Отдельный метод
////            int n = 5;
////            Point[] points = new Point[5];
////            Random random = new Random();
////            for (int i = 0; i < n; i++) {
////                points[i] = new Point(-3 + (n/2 - i) * random.nextInt(0, 5), -2 + random.nextInt(-2, 2));
////            }
//
//            Point penta1 = new Point(-3, -2);
//            Point penta2 = new Point(-1, 4);
//            Point penta3 = new Point(6, 1);
//            Point penta4 = new Point(3, 10);
//            Point penta5 = new Point(-4, 9);
//
//            ArrayList<Point> arrayList2 = new ArrayList<Point>(0);
//
//            //fixme можно как-нибудь так?
////            for (int i = 0; i < 5; i++) {
////                arrayList2.add(penta{%i});
////            }
//
//            arrayList2.add(penta1);
//            arrayList2.add(penta2);
//            arrayList2.add(penta3);
//            arrayList2.add(penta4);
//            arrayList2.add(penta5);
//
//            Pentangle pentangle = new Pentangle(arrayList2);
//            System.out.println(arrayList2);
//
//            System.out.println("Пятиугольник: ");
//            System.out.println(pentangle);
//            System.out.println(pentangle.getSquare());
//            System.out.println(pentangle.getPerimetr());
//
//            ArrayList<Point> arrayList3 = new ArrayList<Point>(0);
//            arrayList3.add(p1);
//            arrayList3.add(p2);
//            System.out.println("Круг: ");
//            Circle circle1 = new Circle(arrayList3);
//            System.out.println(circle1.getRadius());
//            System.out.println(circle1);
//            System.out.println(circle1.getCircumference());
//            System.out.println(circle1.getSquare());
//
//            System.out.println("Новый вариант toString");
//            System.out.println(pentangle);
//
//            FigureCreator creator = new FigureCreator();
//            Figure newFigure = creator.create(arrayList2); //fixme ??????????????????????????????
//            System.out.println(newFigure);


//            Triangle triangle = new Triangle(p1, p2, p3);
//            Figure f1 = new Triangle(p1, p2, p3);
//            Figure f2 = new Rectangle(p1, p2, p3, p4);
//            Triangle triOne = new Triangle(p1, p2, p3);
//            Rectangle rectOne = new Rectangle(p1, p2, p3, p4);
////            Figure f3 = new Figure();
//            Figure f4 = (Figure)triangle; //upcast
//            ((Triangle)f4).getA(); //downcast
//
////            f3.getPerimetr();// - невозможно
//
//        Figure rect1 = new Rectangle(new Point(0, 0), p1, p2, p3);
//        System.out.println(rect1);
//
//            Triangle triTwo = new Triangle(p1, p2, p3);
//            System.out.println(triOne);
//
//            System.out.println(triOne.getTriangleSquare());

            Figure pentangle = new Pentangle(new ArrayList<Point>(Arrays.asList(p1, p2, p3, p4, p5)));
            Figure triangle = new Triangle(new ArrayList<Point>(Arrays.asList(p1, p2, p3)));
//            Writer newWriter = new Writer();
//            newWriter.writeFigureName(pentangle);
//            newWriter.writeFigureName(triangle);
//            newWriter.writeFigureNameWithNoDelete(pentangle);
//            newWriter.writeFigureNameWithNoDelete(triangle);
//
//            String fileName = "Figure Names.txt";
//            Reader reader = new Reader();
//            reader.readFromFile(fileName);
//
//
//            String separator = File.separator;
//            String path = separator + "Users" + separator + "Vladimir" + separator + "Desktop" + separator
//                    + "Программирование" + separator + "СУБД" + separator + "Test file.txt";
//            ReaderWithScanner scanReader = new ReaderWithScanner();
//            scanReader.setPath(path);
//            scanReader.readWithNoParse();
//
//            String path2 = separator + "Users" + separator + "Vladimir" + separator + "Desktop" + separator
//                    + "Программирование" + separator + "СУБД" + separator + "Test file 2.txt";
//            scanReader.setPath(path2);
//            scanReader.readWithParse();
//
//            Writer2 writer = new Writer2();
//            writer.simpleWrite();
//
//            pentangle.writeObject();
//
//            Writer writer = new Writer();
//            writer.writeFigureName(pentangle);

//writer.writerLambda();
//            Reader reader = new Reader();
//            reader.readFromFile("Figure Names.txt");
//            System.out.println(triangle);
//            triangle.rotate(1, true);

            //todo exceptions:

//            Scanner scanner = new Scanner(System.in);
//            boolean continueLoop = true;
//            do {
//                try {
//
//                    System.out.println("Please, enter numerator");
//                    int numerator = scanner.nextInt();
//
//                    System.out.println("Please, enter denominator");
//                    int denominator = scanner.nextInt();
//
//                    System.out.println(divide(numerator, denominator));
//                    continueLoop = false;
//                } catch (ArithmeticException e) {
//                    System.out.println("Exception: " + e);
//                    scanner.nextLine();
//                    System.out.println("Only non-zero parameters allowed");
//                } catch (InputMismatchException e) {
//                    System.out.println("Exception: " + e);
//                    scanner.nextLine();
//                    System.out.println("Only integer values allowed");
//                }
//                System.out.println("Try catch block finished");
//            } while (continueLoop);
//
//        }
//
//    private static int divide(int numerator, int denominator) {
//        return numerator / denominator;

            ArrayList<Figure> figuresList = new ArrayList<Figure>();
            figuresList.add(triangle);
            figuresList.add(pentangle);
//            System.out.println(figuresList);
//            Serialize serialize = new Serialize();
////            serialize.writeObjectSerialized(figuresList, "Serialized Figures.txt");
//            Figure[] figArr = new Figure[] {triangle, pentangle};
//            serialize.writeObjectSerialized(figArr, "Serialized Figures 3.txt");
//            serialize.readObjectDeserialized("Serialized Figures 3.txt");
//
//            Rotate rotate = new Rotate(triangle);
//            rotate.rotate(1, true);
//            Figure triangle2 = new Triangle(new ArrayList<Point>(Arrays.asList(new Point(2, 1), new Point(1, 2), new Point(4, 3))));
//            System.out.println(triangle2.findCentre());
//            triangle2.scale(2);

            Figure[] figArray = new Figure[2];
            figArray[0] = triangle;
            figArray[1] = pentangle;
            JSON_Serialization jsnSer = new JSON_Serialization();
//            jsnSer.serializeWithJSON(figArray, "JSON file_8.json");
//            jsnSer.deserializeWithJSON("JSON file_8.json");

            HashMap<String, Figure> figureMap = new HashMap<String, Figure>();
            figureMap.put("1 figure", triangle);
            figureMap.put("2 figure", pentangle);

            jsnSer.mapSerialization(figureMap, "JSON file_map_2.json");
            jsnSer.mapDeSerialization("JSON file_map_2.json");

//            JSON_Serialization jsnSer = new JSON_Serialization();
////            jsnSer.serializeWithJSON(figuresList, "JSON file_5.json");
////            jsnSer.deserializeWithJSON("JSON file_5.json");
//
//
//            SerializedArrayList sal = new SerializedArrayList(figuresList);
//            jsnSer.wrapperSerializeWithJSON(sal, "JSON file_4.json");
//            jsnSer.wrapperDeserializeWithJSON("JSON file_4.json");



        }

}
