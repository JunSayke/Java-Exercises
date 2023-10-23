import java.util.HashSet;
import java.util.Set;
class VacuumRobot extends Robot {
    private int totalUnitsCleaned;
    private Set<String> visitedLocations;

    public VacuumRobot(char direction, int xLocation, int yLocation) {
        super("Vacuum", direction, xLocation, yLocation);
        totalUnitsCleaned = 0;
        visitedLocations = new HashSet<>();
        visitedLocations.add(getLocationKey(xLocation, yLocation));
    }

    @Override
    public void move(int steps) {
        super.move(steps);

        String locationKey = getLocationKey(getXLocation(), getYLocation());

        if (!visitedLocations.contains(locationKey)) {
            visitedLocations.add(locationKey);
            totalUnitsCleaned += steps;
        }
    }

    public int getTotalUnitsCleaned() {
        return totalUnitsCleaned;
    }

    @Override
    public String toString() {
        return super.toString() + " It has cleaned " + totalUnitsCleaned + " units so far.";
    }

    private String getLocationKey(int x, int y) {
        return x + "," + y;
    }
}