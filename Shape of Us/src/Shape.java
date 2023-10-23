// Add Comparable and Comparator interface implementation here

import java.util.Comparator;

public abstract class Shape implements Comparable<Shape> {
    String color;

    public int compareTo(Shape that) {
        return this.area() < that.area() ? -1 : this.area() == that.area() ? 0 : 1;
    }


    public Shape(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "A shape that is color " + color;
    }

    public abstract double area();
    public abstract double perimeter();

    public static class ShapeColorComparator implements Comparator<Shape> {
        public int compare(Shape o1, Shape o2) {
            int res = o1.color.compareTo(o2.color);
            if (res == 0) {
                res = o2.compareTo(o1);
            }
            return res;
        }
    }
    public static class ShapeAreaComparator implements Comparator<Shape> {
        public int compare(Shape o1, Shape o2) {
            return o2.compareTo(o1);
        }
    }
    public static class ShapePerimeterComparator implements Comparator<Shape> {
        public int compare(Shape o1, Shape o2) {
            return Double.compare(o2.perimeter(), o1.perimeter());
        }
    }
}