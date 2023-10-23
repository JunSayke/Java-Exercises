public abstract class Solid {
    private int x, y;
    /* I THINK THIS IS UNNECESSARY SINCE I COULD JUST USE THE
    OTHER CONSTRUCTOR WHEN CALLING THE SUPER FROM ITS SUBCLASSES
    AND SET THE DEFAULT FROM THEIR TO AVOID REPEATING STUFF
    */
    public Solid() {
        this(50, 50);
    }

    public Solid(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "A solid at (" + x + ", " + y + ")";
    }

    public abstract double volume();
    public abstract double surfaceArea();
}