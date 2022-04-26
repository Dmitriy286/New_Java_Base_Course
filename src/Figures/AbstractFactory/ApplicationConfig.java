package Figures.AbstractFactory;

import Figures.Figure;

public class ApplicationConfig {
    private AbstractFactory factory;
//    private Figure rectangle;
//    private Figure polygon;

    public ApplicationConfig (AbstractFactory factory) {
        this.factory = factory;
    }

    public void setTheme() {
        factory.setTheme("blue");
    }

//    public void createRectangle() {
//        this.rectangle = factory.createRectangle(
//                new ArrayList<>(Arrays.asList(new Point(1, 1),
//                new Point(3, 2), new Point(4, -3), new Point(2, -5))));
//    }
//
//    public void createPolygon() {
//        this.polygon = factory.createPolygon(new ArrayList<>(Arrays.asList(new Point(1, 1),
//                new Point(3, 2), new Point(4, -3), new Point(2, -5), new Point(7, -4))));
//    }


}
