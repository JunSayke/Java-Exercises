import java.lang.Math;

public class Triangle extends Shape {
    // TODO implement Triangle
    private double base;
    private double height;
    private double a;
    private double c;

    public Triangle(double base, double height, double a, double c, String color) {
        super(color);
        this.base = base;
        this.height = height;
        this.a = a;
        this.c = c;
    }

    @Override
    public double area() {
        if (base == height && height == a && a == c)
            return Math.sqrt(3)/4 * Math.pow(a, 2);
        return base * height / 2;
    }

    @Override
    public double perimeter() {
        return a + base + c;
    }

    @Override
    public String toString() {
        return super.toString() + " which is also a Triangle";
    }

    public static class EquilateralTriangle extends Triangle {
        // TODO implement EquilateralTriangle
        public EquilateralTriangle(double side, String color) {
            super(side, side, side, side, color);
        }

        @Override
        public String toString() {
            return super.toString() + " which is also an Equilateral Triangle";
        }
    }
}