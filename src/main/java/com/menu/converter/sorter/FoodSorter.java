package com.menu.converter.sorter;

import com.menu.converter.model.Food;
import com.menu.converter.model.enums.SortOptions;

import java.util.Comparator;
import java.util.List;

public class FoodSorter {

    public static void sort(List<Food> foodList, String sortOrder) {
        if (SortOptions.DESC.toString().equalsIgnoreCase(sortOrder)) {
            foodList.sort(Comparator.comparing(Food::getName, String.CASE_INSENSITIVE_ORDER).reversed());
        } else {
            foodList.sort(Comparator.comparing(Food::getName, String.CASE_INSENSITIVE_ORDER));
        }
    }
}
