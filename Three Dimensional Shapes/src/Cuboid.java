public class Cuboid extends Solid {
    private double height, base, length;
    // REPEATING STUFF IS NOT PRETTY AT ALL
    public Cuboid(double height, double base, double length) {
        super();
        this.height = height;
        this.base = base;
        this.length = length;
    }

    public Cuboid(int x, int y, double height, double base, double length) {
        super(x, y);
        this.height = height;
        this.base = base;
        this.length = length;
    }

    @Override
    public String toString() {
        return super.toString() + " which is a Cuboid";
    }

    @Override
    public double volume() {
        return length * base * height;
    }

    @Override
    public double surfaceArea() {
        return 2 * ( (length * base) + (base * height) + (length * height) );
    }

    public static class Cube extends Cuboid {
        public Cube(double side) {
            super(side, side, side);
        }

        public Cube(int x, int y, double side) {
            super(x, y, side, side, side);
        }

        @Override
        public String toString() {
            return super.toString() + " which is also a Cube";
        }
    }
}
