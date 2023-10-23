import java.util.Scanner;
// SPAGHETTI CODE COMMENCE
public class Main {
    public static void main(String[] args) {
        Solid solid = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter solid: ");
        String option = sc.nextLine();
        int x, y = 0;
        double height, base, length, side, diameter;
        System.out.print("Enter x: ");
        x = sc.nextInt();
        // TODO get y
        if (x != -1) {
            System.out.print("Enter y: ");
            y = sc.nextInt();
        }
        switch (option) {
            case "Cuboid":
                System.out.print("Enter height: ");
                height = sc.nextDouble();
                System.out.print("Enter base: ");
                base = sc.nextDouble();
                System.out.print("Enter length: ");
                length = sc.nextDouble();
                // This nextLine is to rid the next line made by the previous scan
                // Do this in the future as well, before getting a String input
                sc.nextLine();
                if (x != -1) {
                    solid = new Cuboid(x, y, height, base, length);
                } else {
                    solid = new Cuboid(height, base, length);
                }
                break;
            // Add other cases for other shapes here
            case "Cube":
                System.out.print("Enter side: ");
                side = sc.nextDouble();
                if (x != -1) {
                    solid = new Cuboid.Cube(x, y, side);
                } else {
                    solid = new Cuboid.Cube(side);
                }
                break;
            case "Sphere":
                System.out.print("Enter diameter: ");
                diameter = sc.nextDouble();
                if (x != -1) {
                    solid = new Sphere(x, y, diameter);
                } else {
                    solid = new Sphere(diameter);
                }
                break;
            case "Hemisphere":
                System.out.print("Enter diameter: ");
                diameter = sc.nextDouble();
                if (x != -1) {
                    solid = new Sphere.Hemisphere(x, y, diameter);
                } else {
                    solid = new Sphere.Hemisphere(diameter);
                }
                break;
            case "Cone":
                System.out.print("Enter base diameter: ");
                diameter = sc.nextDouble();
                System.out.print("Enter height: ");
                height = sc.nextDouble();
                if (x != -1) {
                    solid = new Cone(x, y, diameter, height);
                } else {
                    solid = new Cone(diameter, height);
                }
                break;
            default:
                System.out.println("Not a shape");
        }

        // This assert simply states that by the time the switch is done,
        // the shape should already be assigned to a particular shape
        // and is therefore not null anymore
        assert solid != null;
        System.out.println(solid);
        System.out.print("Surface Area is ");
        System.out.format("%.2f", solid.surfaceArea());
        System.out.print("\nVolume is ");
        System.out.format("%.2f", solid.volume());
    }
}