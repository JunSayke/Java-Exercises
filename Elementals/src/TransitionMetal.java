public abstract class TransitionMetal extends Element {
    public TransitionMetal(int atomic_number, String symbol, String name, double atomic_weight, double melting_point, double boiling_point) {
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

    public static class Titanium extends TransitionMetal {
        public Titanium() {
            super(22, "Ti", "Titanium", 47.9, 1668, 3287);
        }
    }

    public static class Gold extends TransitionMetal implements Conductive {
        public Gold() {
            super(79, "Au", "Gold", 197, 1064, 2970);
        }

        @Override
        public double percent_conductive() {
            return 0.7;
        }
    }

    public static class Zinc extends TransitionMetal implements Conductive {
        public Zinc() {
            super(30, "Zn", "Zinc", 65.4, 419.5, 907.0);
        }

        @Override
        public double percent_conductive() {
            return 0.27;
        }
    }

    public static class Iron extends TransitionMetal implements Magnetic {
        public Iron() {
            super(26, "Fe", "Iron", 55.8, 1538, 2862);
        }

        @Override
        public int magnetic_strength() {
            return 1710;
        }

        @Override
        public MagneticType magnetic_type() {
            return MagneticType.ferromagnetic;
        }
    }

    public static class Copper extends TransitionMetal implements Conductive {
        public Copper() {
            super(29, "Cu", "Copper", 63.5, 1085, 2562);
        }

        @Override
        public double percent_conductive() {
            return 1;
        }
    }

    public static class Technetium extends TransitionMetal implements Conductive, Magnetic, Radioactive  {
        public Technetium() {
            super(43, "Tc", "Technetium", 98, 2157, 4265);
        }

        @Override
        public double percent_conductive() {
            return 0.65;
        }

        @Override
        public int magnetic_strength() {
            return 270;
        }

        @Override
        public MagneticType magnetic_type() {
            return MagneticType.paramagnetic;
        }

        @Override
        public int half_life() {
            return 61;
        }
    }
}
