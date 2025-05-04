package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine().trim();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine().trim();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine().trim();

        dc.addDinner(dishType, dishName); // добавьте новое блюдо
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");

        String nextItem;
        ArrayList<String> dishTypes = new ArrayList<>();

        // реализуйте ввод типов блюд
        while (true) {
            nextItem = scanner.nextLine().trim();
            if (dc.checkType(nextItem)) {
                dishTypes.add(nextItem);
            } else if (nextItem.isEmpty()) {
                break;
            } else {
                System.out.println("Такого типа блюда нет. Введите существующий тип:");
            }
        }

        // сгенерируйте комбинации блюд и выведите на экран
        ArrayList<ArrayList<String>> comboDishes = dc.combiningDishes(numberOfCombos, dishTypes);
        for (int i = 0; i < comboDishes.size(); i++) {
            System.out.printf("Комбо %d%n", i + 1);
            System.out.println(comboDishes.get(i));
        }
    }
}
