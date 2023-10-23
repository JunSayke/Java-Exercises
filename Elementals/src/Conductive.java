interface Conductive {
    double percent_conductive();
}

interface Magnetic {
    int magnetic_strength();
    MagneticType magnetic_type();
}

interface Radioactive {
    int half_life();
    // NOICE DEFAULT KEYWORD
    default void radiate() {
        System.out.println(this + " emitting radiation");
    }
}

// ENUM FOR THE WIN
enum MagneticType {
    ferromagnetic, paramagnetic;
}

enum StateType {
    solid, liquid, gas;
}

