import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Humanoid Type (1 for SuperHuman, 2 for Mutant): ");
        int humanoidType = scanner.nextInt(); // Use nextInt() to read an integer input

        System.out.print("Enter Name: ");
        String name = scanner.next();

        System.out.print("Enter Gender (M, F): ");
        char gender = scanner.next().charAt(0);

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();

        Humanoid humanoid;

        if (humanoidType == 1) {
            humanoid = new SuperHuman(name, gender, age);
        } else {
            humanoid = new Mutant(name, gender, age);
        }

        Tester.test(humanoid);
    }
}