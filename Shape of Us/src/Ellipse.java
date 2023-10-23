import java.lang.Math;

public class Ellipse extends Shape {
    // TODO implement Ellipse
    private double a;
    private double b;

    public Ellipse(double a, double b, String color) {
        super(color);
        this.a = a;
        this.b = b;
    }

    @Override
    public double area() {
        return Math.PI * a * b;
    }

    @Override
    public double perimeter() {
        return Math.PI * ((3 * (a+b)) - Math.sqrt((a + 3*b) * (b + 3*a)));
    }

    @Override
    public String toString() {
        return super.toString() + " which is also an Ellipse";
    }

    public static class Circle extends Ellipse {
        // TODO implement Circle
        public Circle(double radius, String color) {
            // TODO call super()
            super(radius, radius, color);
        }

        @Override
        public String toString() {
            return super.toString() + " which is also a Circle";
        }
    }
}