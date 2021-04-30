package com.example.test.interaction;

import com.example.test.convertor.impl.MenuConverter;
import com.example.test.model.Food;

import java.util.List;
import java.util.Scanner;

import static com.example.test.interaction.FileNameExtractor.getValidFilename;
import static com.example.test.interaction.SortingInteraction.sortingInteraction;

public class UserInteraction {
    public void execute() {
        boolean exit = false;
        Scanner in = new Scanner(System.in);
        do {
            String fileName = getValidFilename();
            if (!fileName.isEmpty()) {

                MenuConverter menuConverter = new MenuConverter();
                List<Food> foodList = menuConverter.getConvertedFoodFrom(fileName);

                System.out.println("Current file data");
                foodList.forEach(System.out::println);
                System.out.println();

                sortingInteraction(foodList);

                System.out.println("Do you want to convert another file or exit? " +
                        "Type 'yes' for another file or 'no' to exit application ");
                String nextStep = in.next();
                if (nextStep.equalsIgnoreCase("no")) {
                    exit = true;
                }
            } else {
                exit = true;
            }
        }
        while (!exit);
    }


}
