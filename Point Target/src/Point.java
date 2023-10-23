import java.util.Comparator;

public class Point implements Comparable<Point> {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")" ;
    }

    @Override
    public int compareTo(Point o) {
        int res = Integer.compare(o.y, y);
        if (res == 0) {
            res = Integer.compare(x, o.x);
        }
        return res;
    }

    public static class pointSortByNearestFromTarget implements Comparator<Point> {
        Point target;
        public pointSortByNearestFromTarget(Point target) {
            this.target = target;
        }

        @Override
        public int compare(Point o1, Point o2) {
            double o1_diff = Math.sqrt(Math.pow(target.x - o1.x, 2) + Math.pow(target.y - o1.y, 2));
            double o2_diff = Math.sqrt(Math.pow(target.x - o2.x, 2) + Math.pow(target.y - o2.y, 2));
            return Double.compare(Math.abs(o1_diff), Math.abs(o2_diff));
        }
    }
}