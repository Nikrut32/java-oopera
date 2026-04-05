package Show;

import Person.Director;
import Person.Person;

public class Ballet extends MusicalShow{
    public Person choreographer;

    public Ballet(String title, int duration, Director director,
                  Person musicAuthor, String librettoText, Person choreographer) {
        super(title, duration, director, librettoText, musicAuthor);
        typeOfPerformance = "балет";
        this.choreographer = choreographer;
    }

    @Override
    public String toString() {
        return "Название: " + title
                + "\n" + "Длительность: " + duration
                + "\n" + "Музыкальный автор:" + musicAuthor
                + "\n" + "Режиссёр: " + director
                + "\n" + "Хореограф: " + choreographer
                + "\n" + "Список актёров: "
                + "\n" + printToStringActor()
                + "\n" + "Текст либретто: " + librettoText;
    }
}
