class Humanoid {
    private String name;
    private char gender;
    private int age;

    public Humanoid(String name, char gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public void grow(int years) {
        age += years;
    }

    public void changeName(String newName) {
        name = newName;
    }

    @Override
    public String toString() {
        return name + " is a " + gender + " aged " + age + " years.";
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}