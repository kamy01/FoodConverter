package com.menu.converter.interaction;

import com.menu.converter.model.Food;
import com.menu.converter.sorter.FoodSorter;

import java.util.List;
import java.util.Scanner;

public class SortingInteraction {

    public static void sortingInteraction(List<Food> foodList) {
        Scanner in = new Scanner(System.in);
        boolean keepSorting = true;
        while (keepSorting) {
            System.out.println("Select foods sorting after name : " +
                    "type 'asc' for sorting ascending or 'desc' for sorting desc ");

            String sorting = in.next().toLowerCase().strip();

            FoodSorter.sort(foodList, sorting);

            System.out.println();
            System.out.println("After sorting " + sorting);
            foodList.forEach(System.out::println);
            System.out.println("Do you want to sort by other option? " +
                    "Type 'yes' for another try or 'no' to exit sorting ");
            String sortingAnswer = in.next().toLowerCase().strip();
            if (sortingAnswer.equalsIgnoreCase("no")) {
                keepSorting = false;
            }
        }
    }
}
