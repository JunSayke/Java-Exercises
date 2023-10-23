import java.util.ArrayList;
import java.util.List;

public abstract class Alloy {
    private String name;
    private List<Element> elements;

    public Alloy(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Element> getElements() {
        return elements;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setElements(List<Element> elements) {
        this.elements = elements;
    }

    public static class Steel extends Alloy implements Magnetic {
        public Steel() {
            super("Steel");
            List<Element> elements = new ArrayList<>();
            elements.add(new TransitionMetal.Iron());
            elements.add(new TransitionMetal.Copper());
            setElements(elements);
        }

        @Override
        public int magnetic_strength() {
            return 1950;
        }

        @Override
        public MagneticType magnetic_type() {
            return MagneticType.ferromagnetic;
        }
    }

    @Override
    public String toString() {
        return name;
    }

    public static class Bronze extends Alloy {
        public Bronze() {
            super("Bronze");
            List<Element> elements = new ArrayList<>();
            elements.add(new PostTransitionMetal.Tin());
            elements.add(new TransitionMetal.Copper());
            setElements(elements);
        }
    }

    public static class Brass extends Alloy implements Conductive {
        public Brass() {
            super("Brass");
            List<Element> elements = new ArrayList<>();
            elements.add(new TransitionMetal.Copper());
            elements.add(new TransitionMetal.Zinc());
            setElements(elements);
        }

        @Override
        public double percent_conductive() {
            return 0.28;
        }
    }
}

