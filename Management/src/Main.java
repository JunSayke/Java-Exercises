import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Person> persons = new ArrayList<Person>();
        String input, name, name2;
        int age, ctr;
        double salary;
        boolean valid;
        while (true){
            Person p = null;
            System.out.print("Enter person type: ");
            input = sc.nextLine();
            if (input.equals("DONE")) {
                break;
            }
            switch (input.charAt(0)) {
                case 'c':
                    System.out.print("Enter customer name: ");
                    name = sc.nextLine();
                    System.out.print("Enter customer age: ");
                    age = sc.nextInt();
                    // TODO add new Customer in persons here
                    p = new Customer(name, age);
                    break;
                case 'e':
                    System.out.print("Enter employee name: ");
                    name = sc.nextLine();
                    System.out.print("Enter employee age: ");
                    age = sc.nextInt();
                    System.out.print("Enter employee salary: ");
                    salary = sc.nextDouble();
                    // TODO add new Employee in persons here
                    p = new Employee(name, age, salary);
                    break;
                // TODO add more cases for other Person subclasses here
                case 'm':
                    System.out.print("Enter manager name: ");
                    name = sc.nextLine();
                    System.out.print("Enter manager age: ");
                    age = sc.nextInt();
                    System.out.print("Enter manager salary: ");
                    salary = sc.nextDouble();

                    p = new Manager(name, age, salary);
                    break;
                case 'd':
                    System.out.print("Enter developer name: ");
                    name = sc.nextLine();
                    System.out.print("Enter developer age: ");
                    age = sc.nextInt();
                    System.out.print("Enter developer salary: ");
                    salary = sc.nextDouble();

                    p = new Developer(name, age, salary);
                    break;
                default:
                    System.out.println("Invalid operation");
            }
            if (p != null) {
                persons.add(p);
            }
            sc.nextLine();
        }
        while (true) {
            System.out.print("Enter action: ");
            input = sc.nextLine();
            valid = false;
            ctr = 0;
            switch (input) {
                case "DONE":
                    return;
                case "Birthday":
                    System.out.print("Whose birthday? ");
                    name = sc.nextLine();
                    // TODO find name and call birthday
                    for (Person p : persons) {
                        if (p.getName().equals(name)) {
                            p.birthday();
                            valid = true;
                            break;
                        }
                    }
                    if (!valid) {
                        System.out.println("Invalid input");
                    }
                    break;
                case "Assign PM":
                    System.out.print("Select developer: ");
                    name = sc.nextLine();
                    System.out.print("Select manager: ");
                    name2 = sc.nextLine();
                    // TODO find developer "name" and manager "name2" and assign PM
                    for (Person p : persons) {
                        if (p instanceof Developer && p.getName().equals(name)) {
                            if (name2.equals("NULL")) {
                                ((Developer) p).removePM();
                                valid = true;
                                break;
                            }
                            for (Person p2 : persons) {
                                if (p2 instanceof Manager && p2.getName().equals(name2)) {
                                    ((Developer) p).setProjectManager((Manager) p2);
                                    valid = true;
                                    break;
                                }
                            }
                        }
                    }
                    if (!valid) {
                        System.out.println("Invalid input");
                    }
                    break;
                // TODO add more action cases here
                case "Perform Task":
                    for (Person p : persons) {
                        p.performTask();
                    }
                    break;
                case "Give Raise":
                    System.out.print("Enter manager: ");
                    name = sc.nextLine();
                    System.out.print("Enter employee: ");
                    name2 = sc.nextLine();
                    System.out.print("Enter increase: ");
                    salary = sc.nextDouble();
                    sc.nextLine();
                    for (Person p : persons) {
                        if (p instanceof Manager && p.getName().equals(name)) {
                            for (Person p2 : persons) {
                                if (p2 instanceof Employee && p2.getName().equals(name2)) {
                                    ((Manager) p).giveRaise((Employee) p2, salary);
                                    valid = true;
                                    break;
                                }
                            }
                        }
                    }
                    if (!valid) {
                        System.out.println("Invalid input");
                    }
                    break;
                case "Customer Speak":
                    System.out.print("Select customer: ");
                    name = sc.nextLine();
                    System.out.print("Select employee: ");
                    name2 = sc.nextLine();
                    for (Person p : persons) {
                        if (p instanceof Customer && p.getName().equals(name)) {
                            for (Person p2 : persons) {
                                if (p2 instanceof Employee && p2.getName().equals(name2)) {
                                    ((Customer) p).speak((Employee) p2);
                                    valid = true;
                                    break;
                                }
                            }
                        }
                    }
                    if (!valid) {
                        System.out.println("Invalid input");
                    }
                    break;
                case "Person List":
                    for (Person p : persons) {
                        System.out.println(p);
                        ctr++;
                    }
                    if (ctr > 0) {
                        System.out.println("Total Count: " + ctr);
                    } else {
                        System.out.println("No persons in list");
                    }
                    break;
                case "Developer List":
                    for (Person p : persons) {
                        if (p instanceof Developer) {
                            System.out.println(p);
                            ctr++;
                        }
                    }
                    if (ctr > 0) {
                        System.out.println("Total Count: " + ctr);
                    } else {
                        System.out.println("No developers in list");
                    }
                    break;
                case "Manager List":
                    for (Person p : persons) {
                        if (p instanceof Manager) {
                            System.out.println(p);
                            ctr++;
                        }
                    }
                    if (ctr > 0) {
                        System.out.println("Total Count: " + ctr);
                    } else {
                        System.out.println("No managers in list");
                    }
                    break;
                case "Employee List":
                    for (Person p : persons) {
                        if (p instanceof Employee) {
                            System.out.println(p);
                            ctr++;
                        }
                    }
                    if (ctr > 0) {
                        System.out.println("Total Count: " + ctr);
                    } else {
                        System.out.println("No employees in list");
                    }
                    break;
                case "Customer List":
                    for (Person p : persons) {
                        if (p instanceof Customer) {
                            System.out.println(p);
                            ctr++;
                        }
                    }
                    if (ctr > 0) {
                        System.out.println("Total Count: " + ctr);
                    } else {
                        System.out.println("No customers in list");
                    }
                    break;
                default:
                    System.out.println("Invalid action");
            }
        }
    }

}