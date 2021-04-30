package com.file.converter.sorter;

import com.file.converter.model.Food;
import com.file.converter.model.enums.SortOptions;

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
