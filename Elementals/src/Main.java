import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
// SPAGHETTI CODE
public class Main {
    public static void main(String[] args) {
        List<Element> elements = new ArrayList<>();
        List<Alloy> alloys = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String input;
        do {
            System.out.print("Enter element/alloy: ");
            input = sc.nextLine();
            switch (input) {
                case "Copper":
                    elements.add(new TransitionMetal.Copper());
                    break;
                // TODO add more cases here
                case "Titanium":
                    elements.add(new TransitionMetal.Titanium());
                    break;
                case "Gold":
                    elements.add(new TransitionMetal.Gold());
                    break;
                case "Zinc":
                    elements.add(new TransitionMetal.Zinc());
                    break;
                case "Iron":
                    elements.add(new TransitionMetal.Iron());
                    break;
                case "Technetium":
                    elements.add(new TransitionMetal.Technetium());
                    break;
                case "Tin":
                    elements.add(new PostTransitionMetal.Tin());
                    break;
                case "Aluminum":
                    elements.add(new PostTransitionMetal.Aluminum());
                    break;
                case "Uranium":
                    elements.add(new Actinide.Uranium());
                    break;
                case "Steel":
                    alloys.add(new Alloy.Steel());
                    break;
                case "Brass":
                    alloys.add(new Alloy.Brass());
                    break;
                case "Bronze":
                    alloys.add(new Alloy.Bronze());
                    break;
            }
        } while (!input.equals("DONE"));

        int ctr;
        do {
            ctr = 0;
            System.out.print("Enter action: ");
            input = sc.nextLine();
            switch (input){
                case "Radiate":
                    // TODO Radiate here
                    for (Element e : elements) {
                        if (e instanceof Radioactive) {
                            Radioactive r = (Radioactive) e;
                            r.radiate();
                            System.out.println(e + "'s half-life: " + r.half_life());
                            ctr++;
                        }
                    }
                    if (ctr <= 0) {
                        System.out.println("No radioactive materials present");
                    }
                    break;
                case "Magnetize":
                    // TODO Magnetize here
                    for (Element e : elements) {
                        if (e instanceof Magnetic) {
                            Magnetic m = (Magnetic) e;
                            System.out.println(e + " is " + m.magnetic_type() + " with strength of " + m.magnetic_strength());
                            ctr++;
                        }
                    }
                    for (Alloy a : alloys) {
                        if (a instanceof Magnetic) {
                            Magnetic m = (Magnetic) a;
                            System.out.println(a + " is " + m.magnetic_type() + " with strength of " + m.magnetic_strength());
                            ctr++;
                        }
                    }
                    if (ctr <= 0) {
                        System.out.println("No magnetic materials present");
                    }
                    break;
                case "Conduct":
                    // TODO Conduct here
                    for (Element e : elements) {
                        if (e instanceof Conductive) {
                            Conductive c = (Conductive) e;
                            // SPENT HOURS DEBUGGING JUST FOR THE HIDDEN TEST CASE 7 MISTAKE TO BE THE FORMATTING!!!???
                            System.out.printf("%s conductivity is %.1f%%\n", e, c.percent_conductive() * 100);
                            ctr++;
                        }
                    }
                    for (Alloy a : alloys) {
                        if (a instanceof Conductive) {
                            Conductive c = (Conductive) a;
                            // BACK TO C PRINTF SHESSHH!!
                            System.out.printf("%s conductivity is %.1f%%\n", a, c.percent_conductive() * 100);
                            ctr++;
                        }
                    }
                    if (ctr <= 0) {
                        System.out.println("No conductive materials present");
                    }
                    break;
                case "Alloy Components":
                    // TODO Alloy here
                    for (Alloy a : alloys) {
                        System.out.print(a + " consists of ");
                        List<Element> alloyElements = a.getElements();
                        for (int i = 0; i < alloyElements.size(); i++) {
                            Element e = alloyElements.get(i);
                            if (i < alloyElements.size() - 1) {
                                // COMMA AND SPACE
                                System.out.print(e.getName() + ", ");
                            } else {
                                System.out.println(e.getName());
                            }
                        }
                    }
                    if (alloys.isEmpty()) {
                        System.out.println("No alloys present");
                    }
                    break;
                case "Get State":
                    System.out.print("Enter temperature: ");
                    double temp = sc.nextDouble();
                    sc.nextLine(); // This is to clear the newline
                    // TODO print state of elements
                    for (Element e : elements) {
                        System.out.println(e + " is " + e.state((float) temp)); // HMMM FLOAT OR DOUBLE?!!
                    }
                    break;
                case "Sort by Weight":
                    Collections.sort(elements);
                    for (Element e : elements) {
                        System.out.println(e + " = " + e.getAtomicWeight());
                    }
                    if (elements.isEmpty()) {
                        System.out.println("No elements present");
                    }
                    break;
            }
        } while (!input.equals("DONE"));
    }
}