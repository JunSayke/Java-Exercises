public class Cone extends Solid {
    private double diameter, height, slant;
    // REPEATING STUFF IS NOT PRETTY AT ALL
    public Cone(double diameter, double height) {
        super();
        this.diameter = diameter;
        this.height = height;
        this.slant = Math.sqrt(Math.pow(diameter/2, 2) + Math.pow(height, 2));
    }

    public Cone(int x, int y, double diameter, double height) {
        super(x, y);
        this.diameter = diameter;
        this.height = height;
        this.slant = Math.sqrt(Math.pow(diameter/2, 2) + Math.pow(height, 2));
    }

    @Override
    public String toString() {
        return super.toString() + " which is a Cone";
    }

    @Override
    public double volume() {
        double radius = diameter / 2;
        return (1/3.0) * Math.PI * Math.pow(radius, 2) * height;
    }

    @Override
    public double surfaceArea() {
        double radius = diameter / 2;
        return Math.PI * radius * (slant + radius);
    }
}
