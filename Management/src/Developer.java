public class Developer extends Employee {
    private Manager projectManager;

    public Developer(String name, int age, double salary) {
        super(name, age, salary);
    }

    public Manager getProjectManager() {
        return projectManager;
    }

    protected void setProjectManager(Manager projectManager) {
        if (this.projectManager != null) {
            System.out.println(getName() + " already has a manager");
            return;
        }
        this.projectManager = projectManager;
    }

    public void removePM() {
        projectManager = null;
    }

    @Override
    public void birthday() {
        super.birthday();
        if (projectManager != null) {
            projectManager.giveRaise(this, getSalary() * 0.05);
        }
    }

    @Override
    public void performTask() {
        System.out.println(getName() + " is coding");
    }

    @Override
    public String toString() {
        if (projectManager != null) {
            return super.toString() + " [" + projectManager.getName() + "]";
        }
        return super.toString();
    }
}
