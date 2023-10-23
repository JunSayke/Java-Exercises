class Mutant extends Humanoid {
    private boolean hasSuperpowers;

    public Mutant(String name, char gender, int age) {
        super("Mutant " + name, gender, age);
    }

    public void gainPower() {
        hasSuperpowers = true;
    }

    public boolean getHasSuperpowers() {
        return hasSuperpowers;
    }

    @Override
    public String toString() {
        return super.toString() + " Has superpowers: " + hasSuperpowers + ".";
    }
}