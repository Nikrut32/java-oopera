import People.Actor;
import People.Director;

import java.util.ArrayList;

public class Show {
    public String title;
    public int duration;
    public Director director;
    public ArrayList<Actor> listOfActors;

    public Show(String title, ArrayList<Actor> listOfActors, Director director, int duration) {
        this.title = title;
        this.listOfActors = listOfActors;
        this.director = director;
        this.duration = duration;
    }
}
