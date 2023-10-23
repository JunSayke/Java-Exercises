class CarRobot extends Robot {
    public CarRobot(char direction, int xLocation, int yLocation) {
        super("Car", direction, xLocation, yLocation);
    }

    // Euclidean Distance Huhh!!??
    public double calculateSeconds(int x, int y) {
        int dx = x - getXLocation();
        int dy = y - getYLocation();
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }
}