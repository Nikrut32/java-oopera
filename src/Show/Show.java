package Show;

import Person.Actor;
import Person.Director;

import java.util.Scanner;
import java.util.ArrayList;

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

    public void replaceActor(Actor newActor, String surnameActor, Scanner scanner) {
        ArrayList<Integer> indexOfMatches = new ArrayList<>();
        for(int i = 0; i < listOfActors.size(); i++) {
            if(listOfActors.get(i).surname.equals(surnameActor)) {
                indexOfMatches.add(i);
            }
        }

        if(indexOfMatches.isEmpty()) {
            System.out.println("Актёра с такой фамилией нет в спектакле!");
        } else if(indexOfMatches.size() == 1) {
            listOfActors.set(indexOfMatches.getFirst(), newActor);
            System.out.println("Актёр успешно заменен!");
        } else {
            System.out.println("В списке несколько актёров с такой фамилией!");
            System.out.println("Введите дополнительно имя актёра: ");
            String name = scanner.next();
            for(int index: indexOfMatches) {
                if(listOfActors.get(index).name.equals(name)) {
                    listOfActors.set(index, newActor);
                    System.out.println("Актёр успешно заменен!");
                } else {
                    System.out.println("Актёра с такой фамилией и именем нет в спектакле!");
                    return;
                }
            }
        }
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
