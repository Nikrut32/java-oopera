package Person;

public class Person {
    public String name;
    public String surname;
    public Gender gender;

    public Person(String name, Gender gender, String surname) {
        this.name = name;
        this.gender = gender;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return surname + " " + name;
    }
}
