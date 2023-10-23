public class Sphere extends Solid {
    private double diameter;
    // REPEATING STUFF IS NOT PRETTY AT ALL
    public Sphere(double diameter) {
        super();
        this.diameter = diameter;
    }

    public Sphere(int x, int y, double diameter) {
        super(x, y);
        this.diameter = diameter;
    }

    @Override
    public String toString() {
        return super.toString() + " which is a Sphere";
    }

    @Override
    public double volume() {
        double radius = diameter / 2;
        return (4/3.0) * Math.PI * Math.pow(radius, 3);
    }

    @Override
    public double surfaceArea() {
        double radius = diameter / 2;
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    public double getDiameter() {
        return diameter;
    }

    public static class Hemisphere extends Sphere {
        public Hemisphere(double diameter) {
            super(diameter);
        }

        public Hemisphere(int x, int y, double diameter) {
            super(x, y, diameter);
        }

        @Override
        public String toString() {
            return super.toString() + " but only half of it";
        }

        @Override
        public double volume() {
            return super.volume() / 2;
        }

        @Override
        public double surfaceArea() {
            double radius = getDiameter() / 2;
            return 3 * Math.PI * Math.pow(radius, 2);
        }
    }
}
