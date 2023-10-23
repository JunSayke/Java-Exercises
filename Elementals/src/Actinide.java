// ACTINIDE WINDOW EXIST SO WHY MAKE THIS AS NESTED CLASS IN ELEMENT??!!
public abstract class Actinide extends Element implements Radioactive {
    public Actinide(int atomic_number, String symbol, String name, double atomic_weight, double melting_point, double boiling_point) {
        super(atomic_number, symbol, name, atomic_weight, melting_point, boiling_point);
    }

    // AGAIN WHY ABSTRACT?!!
    @Override
    public StateType state(float temperature) {
        if (temperature < getMeltingPoint()) {
            return StateType.solid;
        }
        if (temperature < getBoilingPoint()) {
            return StateType.liquid;
        }
        return StateType.gas;
    }

    public static class Uranium extends Actinide {
        public Uranium() {
            super(92, "U", "Uranium", 238, 1132.2, 4131);
        }

        @Override
        public int half_life() {
            return 25166;
        }
    }
}
