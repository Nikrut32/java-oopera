package Person;

public class Director extends Person {
    public int numberOfShows;

    public Director(String name, Gender gender, String surname, int numberOfShows) {
        super(name, gender, surname);
        this.numberOfShows = numberOfShows;
    }
}
