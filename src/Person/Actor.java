package Person;

import java.util.Objects;

public class Actor extends Person{
    public double height;

    public Actor(String name, Gender gender, String surname, double height) {
        super(name, gender, surname);
        this.height = height;
    }

    @Override
    public String toString() {
        return surname + " " + name + " (рост: " + height + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return Objects.equals(height, actor.height)
                && Objects.equals(name, actor.name)
                && Objects.equals(gender, actor.gender)
                && Objects.equals(surname, actor.surname);
    }

    @Override
    public int hashCode() {
        int hash = 17;
        if (name != null) hash += name.hashCode();
        hash *= 31;
        if (gender != null) hash += gender.hashCode();
        hash *= 31;
        if (surname != null) hash += surname.hashCode();
        hash *= 31;
        hash += Objects.hashCode(height);
        return hash;
    }


}
