package Show;

import Person.Director;
import Person.Person;

public class Opera extends MusicalShow{

    protected int choirSize;

    public Opera(String title, int duration, Director director, String librettoText,
                 Person musicAuthor, int choirSize) {
        super(title, duration, director, librettoText, musicAuthor);
        this.choirSize = choirSize;
        typeOfPerformance = "опера";
    }

    @Override
    public String toString() {
        return "\n" + "Название: " + title
                + "\n" + "Длительность: " + duration
                + "\n" + "Музыкальный автор:" + musicAuthor
                + "\n" + "Режиссёр: " + director
                + "\n" + "Колличество человек в хоре: " + choirSize
                + "\n" + "Список актёров: "
                + "\n" + printToStringActor()
                + "\n" + "Текст либретто: " + librettoText;
    }
}
