public class Customer extends Person {
    public Customer(String name, int age) {
        super(name, age);
    }

    @Override
    public void performTask() {
        System.out.println(getName() + " is browsing through");
    }

    public void speak(Employee employee) {
        if (employee instanceof Developer) {
            Manager manager = ((Developer) employee).getProjectManager();
            if (getAge() > employee.getAge() && manager != null) {
                System.out.println("Can I see your manager " + manager.getName() + "?");
                return;
            }
        }
        System.out.println("Oh, hello, " + employee.getName() + ". Can you assist me?");
    }
}
