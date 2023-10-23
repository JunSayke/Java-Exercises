public abstract class PostTransitionMetal extends Element {
    public PostTransitionMetal(int atomic_number, String symbol, String name, double atomic_weight, double melting_point, double boiling_point) {
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

    public static class Tin extends PostTransitionMetal {
        public Tin() {
            super(50, "Sn", "Tin", 118.7, 231.9, 2602);
        }
    }

    public static class Aluminum extends PostTransitionMetal implements Conductive {
        public Aluminum() {
            super(13, "Al", "Aluminum", 27, 660.3, 2470);
        }

        @Override
        public double percent_conductive() {
            return 0.61;
        }
    }
}
