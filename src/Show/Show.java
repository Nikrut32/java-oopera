package Show;

import Person.Actor;
import Person.Director;

import java.util.ArrayList;
import java.util.Scanner;

public class Show {
    public String typeOfPerformance= "базовый";
    protected String title;
    protected int duration;
    public Director director;
    public ArrayList<Actor> listOfActors;

    public Show(String title, int duration, Director director) {
        this.title = title;
        this.duration = duration;
        this.director = director;
        listOfActors = new ArrayList<>();
    }

    public String printTitleAndDuration() {
        return title + ", длительность: " + duration + " минут";
    }

    public void replaceActor(Actor newActor, Scanner scanner) {
        System.out.println("Выберите актёры из списка спектакля, которого хотите заменить: ");
        printActor();
        int numberActor = scanner.nextInt();
        listOfActors.set(numberActor - 1, newActor);

    }

    public void printActor() {
        if(listOfActors.isEmpty()) {
            System.out.println("Актёры не были добавлены на спектакль");
        }
        int count = 0;
        for (Actor actor: listOfActors) {
            System.out.println(++count + " - " + actor.toString());
        }
    }

    public String printToStringActor() {
        if(listOfActors.isEmpty()) {
            System.out.println("Актёры не были добавлены на спектакль");
        }
        int count = 0;
        String listActor = "";
        for (Actor actor: listOfActors) {
             listActor = listActor + (++count + " - " + actor.toString() + "\n");
        }
        return listActor;
    }

    public void addActor(Actor actor) {
        if(listOfActors.contains(actor)) {
            System.out.println("Этот актёр уже участвует в спектакле!");
            return;
        }
        listOfActors.add(actor);
    }

    @Override
    public String toString() {
        return "Название: " + title
                + "\n" + "Длительность: " + duration
                + "\n" + "Режиссёр: " + director
                + "\n" + "Список актёров: "
                + "\n" + printToStringActor();
    }
}
