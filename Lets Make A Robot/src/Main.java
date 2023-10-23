import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int robotType, x, y;
        char direction;
        Robot someRobot;
        System.out.print("Enter Robot type (1 - Vacuum, 2 - Car): ");
        robotType = sc.nextInt();
        System.out.print("Enter position x: ");
        x = sc.nextInt();
        System.out.print("Enter position y: ");
        y = sc.nextInt();
        System.out.print("Enter initial direction (N, E, W, S): ");
        sc.nextLine();
        direction = sc.nextLine().charAt(0);
        if (robotType == 1) {
            someRobot = new VacuumRobot(direction, x, y);
        } else {
            someRobot = new CarRobot(direction, x, y);
        }
        Tester.test(someRobot);
    }
}