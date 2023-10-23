class Robot {
    private String name;
    private char direction;
    private int xLocation;
    private int yLocation;

    public Robot(String name, char direction, int xLocation, int yLocation) {
        this.name = name;
        this.direction = direction;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
    }

    public void turnClockwise() {
        switch (direction) {
            case 'N':
                direction = 'E';
                break;
            case 'E':
                direction = 'S';
                break;
            case 'S':
                direction = 'W';
                break;
            case 'W':
                direction = 'N';
                break;
        }
    }

    public void turnCounterclockwise() {
        switch (direction) {
            case 'N':
                direction = 'W';
                break;
            case 'W':
                direction = 'S';
                break;
            case 'S':
                direction = 'E';
                break;
            case 'E':
                direction = 'N';
                break;
        }
    }

    public void move(int steps) {
        switch (direction) {
            case 'N':
                yLocation += steps;
                break;
            case 'E':
                xLocation += steps;
                break;
            case 'S':
                yLocation -= steps;
                break;
            case 'W':
                xLocation -= steps;
                break;
        }
    }

    public String toString() {
        return name + " faces " + direction + " and is located at coordinates (" + xLocation + ", " + yLocation + ").";
    }

    // Getter and setter methods for the properties
    public String getName() {
        return name;
    }

    public char getDirection() {
        return direction;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public void setXLocation(int xLocation) {
        this.xLocation = xLocation;
    }

    public void setYLocation(int yLocation) {
        this.yLocation = yLocation;
    }

    public int getXLocation() {
        return xLocation;
    }

    public int getYLocation() {
        return yLocation;
    }
}