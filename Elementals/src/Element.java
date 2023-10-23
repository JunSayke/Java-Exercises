// Also put Actinide and Uranium as inner class here - HMMMMM??
public abstract class Element implements Comparable<Element> {
    private int atomic_number;
    private String symbol;
    private String name;
    private double atomic_weight;
    private double melting_point;
    private double boiling_point;

    @Override
    public int compareTo(Element o) {
        return Double.compare(atomic_weight, o.atomic_weight);
    }

    public Element(int atomic_number, String symbol, String name, double atomic_weight, double melting_point, double boiling_point) {
        this.atomic_number = atomic_number;
        this.symbol = symbol;
        this.name = name;
        this.atomic_weight = atomic_weight;
        this.melting_point = melting_point;
        this.boiling_point = boiling_point;
    }
    // I DON'T UNDERSTAND WHY THE INSTRUCTION MENTIONED THIS AS AN ABSTRACT??
    public abstract StateType state(float temperature);
    // GETTER FOR CONVENIENCE DON'T CARE IF I HAVEN'T USED SOME OF THESE INTELLIJ
    public int getAtomicNumber() {
        return atomic_number;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public double getAtomicWeight() {
        return atomic_weight;
    }

    public double getMeltingPoint() {
        return melting_point;
    }

    public double getBoilingPoint() {
        return boiling_point;
    }
    // SETTER FOR CONVENIENCE DON'T CARE IF I HAVEN'T USED SOME OF THESE INTELLIJ
    protected void setAtomicNumber(int atomic_number) {
        this.atomic_number = atomic_number;
    }

    protected void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setAtomicWeight(double atomic_weight) {
        this.atomic_weight = atomic_weight;
    }

    protected void setMeltingPoint(double melting_point) {
        this.melting_point = melting_point;
    }

    protected void setBoilingPoint(double boiling_point) {
        this.boiling_point = boiling_point;
    }

    @Override
    public String toString() {
        return atomic_number + " " + name + " (" + symbol + ")";
    }
}
