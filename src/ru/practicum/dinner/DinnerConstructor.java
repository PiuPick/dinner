package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dinnerMenu = new HashMap<>();
    Random random = new Random();

    ArrayList<ArrayList<String>> combiningDishes(int numberOfCombos, ArrayList<String> dishTypes) {
        ArrayList<ArrayList<String>> comboDishes = new ArrayList<>(numberOfCombos);

        for (int i = 0; i < numberOfCombos; i++) {
            ArrayList<String> comboDish = new ArrayList<>(dishTypes.size());

            for (String dishType : dishTypes) {
                ArrayList<String> namesDishType = dinnerMenu.get(dishType);
                String nameDish = namesDishType.get(random.nextInt(namesDishType.size()));

                comboDish.add(nameDish);
            }
            comboDishes.add(comboDish);
        }

        return comboDishes;
    }

    void addDinner(String dishType, String dishName) {
        ArrayList<String> namesDish;

        if (dinnerMenu.containsKey(dishType)) {
            namesDish = dinnerMenu.get(dishType);
        } else {
            namesDish = new ArrayList<>();
        }

        namesDish.add(dishName);
        dinnerMenu.put(dishType, namesDish);
    }

    boolean checkType(String type) {
        return dinnerMenu.containsKey(type);
    }
}
