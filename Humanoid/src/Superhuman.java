class SuperHuman extends Humanoid {
    private int strength;

    public SuperHuman(String name, char gender, int age) {
        super("Super " + name, gender, age);
    }

    public void increaseStrength(int amount) {
        strength += amount;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public String toString() {
        return super.toString() + " Strength: " + strength + ".";
    }
}