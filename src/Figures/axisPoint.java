package Figures;

public class axisPoint extends Point {

    private String axis;

    public axisPoint(double x, double y) {
        super(x, y);

        if (x == 0 && y == 0) {
            this.axis = "I'm center";
        }
        else if (x == 0) {
            this.axis = "I'm y point";
        }
        else if (y == 0) {
            this.axis = "I'm x point";
        }
        else {
            this.axis = "???????";
        }
    }
        @Override
        public String toString() {
            return "I'm axis point";
        }



}
