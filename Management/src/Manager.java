public class Manager extends Employee {
    public Manager(String name, int age, double salary) {
        super(name, age, salary);
    }

    public void giveRaise(Employee employee, double salaryIncrease) {
        if (salaryIncrease < 0) {
            System.out.println("Invalid increase");
            return;
        }
        employee.setSalary(employee.getSalary() + salaryIncrease);
        if (employee != this) {
            this.setSalary(this.getSalary() + (salaryIncrease/2));
        }
    }

    @Override
    public String toString() {
        return "Mgr. " + super.toString();
    }
}
