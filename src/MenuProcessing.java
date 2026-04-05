import Person.Actor;
import Person.Director;
import Person.Gender;
import Person.Person;
import Show.Ballet;
import Show.Opera;
import Show.Show;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuProcessing {
    public static final ArrayList<Show> listShow = new ArrayList<>();
    public static final ArrayList<Actor> actors = new ArrayList<>();
    public static final ArrayList<Person> musicAuthors = new ArrayList<>();
    public static final ArrayList<Person> choreographers = new ArrayList<>();
    public static final ArrayList<Director> directors = new ArrayList<>();

    public static void addAnMusicAuthor(Scanner scanner) {
        System.out.println("Ввод автора музыки!");
        System.out.print("Введите имя: ");
        String name = scanner.next();
        System.out.print("Введите фамилию: ");
        String surname = scanner.next();
        System.out.print("Введите пол, в формате (MALE или FAMALE): ");
        String gender = scanner.next();
        System.out.println("\n" + "Автор музыки успешно добавлен!");
        musicAuthors.add(new Person(name, Gender.valueOf(gender), surname));
    }

    public static void addAnActor(Scanner scanner) {
        System.out.println("Ввод актёра!");
        System.out.print("Введите имя: ");
        String name = scanner.next();
        System.out.print("Введите фамилию: ");
        String surname = scanner.next();
        System.out.print("Введите пол, в формате (MALE или FAMALE): ");
        String gender = scanner.next();
        System.out.print("Введите рост: ");
        int height = scanner.nextInt();
        Actor newActor = new Actor(name, Gender.valueOf(gender), surname, height);
        if (actors.isEmpty()) {
            actors.add(newActor);
        } else {
            for (Actor actor : actors) {
                if (actor.equals(newActor)) {
                    System.out.println("Этот актёр уже добавлен в список!" + "\n");
                    return;
                }
            }
            actors.add(newActor);
        }
        System.out.println("\n" + "Актёр был успешно добавлен!");
    }

    public static void addAnChoreographer(Scanner scanner) {
        System.out.println("Ввод хореографа!");
        System.out.print("Введите имя: ");
        String name = scanner.next();
        System.out.print("Введите фамилию: ");
        String surname = scanner.next();
        System.out.print("Введите пол, в формате (MALE или FAMALE): ");
        String gender = scanner.next();
        System.out.println("\n" + "Хореограф успешно добавлен!");
        choreographers.add(new Person(name, Gender.valueOf(gender), surname));
    }

    public static void addAnDirector(Scanner scanner) {
        System.out.println("Ввод режиссёра!");
        System.out.print("Введите имя: ");
        String name = scanner.next();
        System.out.print("Введите фамилию: ");
        String surname = scanner.next();
        System.out.print("Введите пол, в формате (MALE или FAMALE): ");
        String gender = scanner.next();
        System.out.print("Введите количество спектаклей поставленных режиссёром: ");
        int numberOfShows = scanner.nextInt();
        System.out.println("\n" + "Режиссёр успешно добавлен!");
        directors.add(new Director(name, Gender.valueOf(gender), surname, numberOfShows));
    }

    public static void createOfPerformance(Scanner scanner) {
        System.out.println("Какой спектакль вы хотите создать?"
                + "\n" + "1 - Базовый"
                + "\n" + "2 - Балет"
                + "\n" + "3 - Опера");
        int command = scanner.nextInt();
        if (command <= 0 || command > 3) {
            System.out.println("Такого варианта нет!");
            return;
        }
        System.out.println("Создание спектакля!");
        System.out.print("Введите название спектакля: ");
        String title = scanner.next();
        System.out.print("Введите длительность спектакля в минутах: ");
        int duration = scanner.nextInt();
        System.out.println("Выберите режиссёра спектакля: ");
        printDirectors();
        int numberDirector = scanner.nextInt();
        Director director = directors.get(numberDirector - 1);

        if (command == 1) {
            System.out.println("Спектакль «" + title + "» успешно создан!");
            listShow.add(new Show(title, duration, director));
        } else {
            System.out.println("Выберите музыкального автора спектакля: ");
            printMusicAuthors();
            int numberMusicAuthor = scanner.nextInt();
            scanner.nextLine();
            Person musicAuthor = musicAuthors.get(numberMusicAuthor - 1);
            System.out.println("Введите текст либретто:");
            String librettoText = scanner.nextLine();
            if (command == 2) {
                System.out.println("Выберите хореографа спектакля: ");
                printChoreographers();
                int numberChoreographer = scanner.nextInt();
                Person choreographer = musicAuthors.get(numberChoreographer - 1);
                System.out.println("Спектакль «" + title + "» успешно создан!");
                listShow.add(new Ballet(title, duration, director, musicAuthor, librettoText, choreographer));
            } else if (command == 3) {
                System.out.print("Введите количество человек в хоре: ");
                int choirSize = scanner.nextInt();
                System.out.println("Спектакль «" + title + "» успешно создан!");
                listShow.add(new Opera(title, duration, director, librettoText, musicAuthor, choirSize));
            }
        }
    }

    public static void printShow(Scanner scanner) {
        if (listShow.isEmpty()) {
            System.out.println("Спектакли не были добавлены в список!" + "\n");
            createOfPerformance(scanner);
        }
        int count = 0;
        for (Show show : listShow) {
            System.out.println(++count + " - " + show.printTitleAndDuration());
        }
    }

    public static void printActors() {
        if (actors.isEmpty()) {
            System.out.println("Актёры не были добавлены в список!" + "\n");
            return;
        }
        int count = 0;
        for (Actor actor : actors) {
            System.out.println(++count + " - " + actor.toString());
        }
    }

    public static void printActorsShow(Scanner scanner) {
        System.out.println("Выберите спектакль из списка:");
        printShow(scanner);
        int numberShow = scanner.nextInt();
        System.out.println("Список актёров спектакля:");
        listShow.get(numberShow - 1).printActor();
    }

    public static void printShowInformation(Scanner scanner) {
        System.out.println("Выберите спектакль из списка:");
        printShow(scanner);
        int numberShow = scanner.nextInt();
        System.out.println(listShow.get(numberShow - 1).toString());;
    }

    public static void printDirectors() {
        if (directors.isEmpty()) {
            System.out.println("Режиссёры не были добавлены в список!" + "\n");
            return;
        }
        int count = 0;
        for (Director director : directors) {
            System.out.println(++count + " - " + director.toString());
        }
    }

    public static void printChoreographers() {
        if (choreographers.isEmpty()) {
            System.out.println("Хореографы не были добавлены в список!"  + "\n");
            return;
        }
        int count = 0;
        for (Person choreographer : choreographers) {
            System.out.println(++count + " - " + choreographer.toString());
        }
    }

    public static void printMusicAuthors() {
        if (musicAuthors.isEmpty()) {
            System.out.println("Авторы музыки не были добавлены в список!" + "\n");
            return;
        }
        int count = 0;
        for (Person musicAuthor : musicAuthors) {
            System.out.println(++count + " - " + musicAuthor.toString());
        }
    }

    public static void printAllPerson(Scanner scanner) {
        System.out.println("Режиссёры: ");
        printDirectors();
        System.out.println("Актёры: ");
        printActors();
        System.out.println("Авторы музыки: ");
        printMusicAuthors();
        System.out.println("Хореографы: ");
        printChoreographers();
    }

    public static void printLibrettoShow(Scanner scanner) {
        System.out.println("Выберите спектакль из списка:");
        printShow(scanner);
        int numberShow = scanner.nextInt();
        if (listShow.get(numberShow - 1).typeOfPerformance.equals("базовый")) {
            System.out.println("В этом спектакле нет Либретто!");
        } else if(listShow.get(numberShow - 1).typeOfPerformance.equals("опера")) {
            Opera opera = (Opera) listShow.get(numberShow - 1);
            opera.printLibretto();
        } else if(listShow.get(numberShow - 1).typeOfPerformance.equals("балет")) {
            Ballet ballet = (Ballet) listShow.get(numberShow - 1);
            ballet.printLibretto();
        }
    }

    public static void addAnPerson(Scanner scanner) {
        System.out.println("Выберите кого вы хотите добавить в список:"
                + "\n" + "1 - Режиссёр"
                + "\n" + "2 - Актёр"
                + "\n" + "3 - Автор музыки"
                + "\n" + "4 - Хореограф");
        int command = scanner.nextInt();
        switch (command) {
            case 1:
                addAnDirector(scanner);
                break;
            case 2:
                addAnActor(scanner);
                break;
            case 3:
                addAnMusicAuthor(scanner);
                break;
            case 4:
                addAnChoreographer(scanner);
                break;
            default:
                System.out.println("Такой команды нет!" + "\n");
        }
    }

    public static void addAtActorToPerformance(Scanner scanner) {
        System.out.println("Выберите спектакль из списка:");
        printShow(scanner);
        int numberShow = scanner.nextInt();
        System.out.println("Выберите актёра из списка: ");
        printActors();
        int numberActor = scanner.nextInt();
        Actor newActor = actors.get(numberActor - 1);
        listShow.get(numberShow - 1).addActor(newActor);
    }

    public static void replaceAnActor(Scanner scanner) {
        System.out.println("Выберите спектакль из списка:");
        printShow(scanner);
        int numberShow = scanner.nextInt();
        System.out.println("Выберите нового актёра из списка: ");
        printActors();
        int numberActor = scanner.nextInt();
        Actor newActor = actors.get(numberActor - 1);
        listShow.get(numberShow - 1).replaceActor(newActor, scanner);

    }
}

