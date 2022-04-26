package Figures;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;

@JsonAutoDetect
public class Point implements Serializable {
    protected double x;
    protected double y;

    public Point() {
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "Point: " + this.getX() + "; " + this.getY();
    }

    public String toPrintableString() {
        return "(" + this.getX() + "; " + this.getY() + ")";
    }

}
