package Show;

import Person.Director;
import Person.Person;

public class MusicalShow extends Show{
    public Person musicAuthor;
    protected String librettoText;

    public MusicalShow(String title, int duration, Director director, String librettoText, Person musicAuthor) {
        super(title, duration, director);
        this.librettoText = librettoText;
        this.musicAuthor = musicAuthor;
    }


    public void printLibretto() {
        System.out.println("Текст либретто: " + librettoText);
    }
}
