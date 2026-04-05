import java.awt.*;
import java.util.Scanner;

public class Theatre {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вас приветствует приложение по управлению работы театра!");
        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if(command == 1) {
                MenuProcessing.addAnPerson(scanner);
            } else if (command == 2) {
                MenuProcessing.printAllPerson(scanner);
            } else if (command == 3) {
                MenuProcessing.createOfPerformance(scanner);
            } else if (command == 4) {
                MenuProcessing.addAtActorToPerformance(scanner);
            } else if (command == 5) {
                MenuProcessing.printActorsShow(scanner);
            } else if (command == 6) {
                MenuProcessing.replaceAnActor(scanner);
            } else if (command == 7) {
                MenuProcessing.printLibrettoShow(scanner);
            } else if (command == 8) {
                MenuProcessing.printShowInformation(scanner);
            } else if (command == 9) {
                System.out.println("Работа программы успешно завершена, хорошего вам дня :)");
                break;
            } else {
                System.out.println("Такой команды нет!");
            }
        }

    }

    public static void printMenu() {
        System.out.println("\n" + "-".repeat(45));
        System.out.println("Введите команду из списка: ");
        System.out.println("1 - ввод участников театра");
        System.out.println("2 - вывод полного списка участников театра ");
        System.out.println("3 - создание спектакля");
        System.out.println("4 - ввод актёров на спектакль");
        System.out.println("5 - вывод списка актёров спектакля");
        System.out.println("6 - замена актёра спектакля");
        System.out.println("7 - вывод текста Либретто спектакля");
        System.out.println("8 - вывод всей информации по спектаклю");
        System.out.println("9 - выход");
        System.out.println("-".repeat(45));
    }
}
