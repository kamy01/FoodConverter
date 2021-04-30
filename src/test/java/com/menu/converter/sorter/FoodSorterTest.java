package com.menu.converter.sorter;

import com.menu.converter.model.Food;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FoodSorterTest {

    private List<Food> foods = new ArrayList<>();

    @BeforeEach
    private void before() {
        foods.add(new Food("Belgian Waffles", "21.4$", "Belgian desc", 222));
        foods.add(new Food("Homestyle Breakfas", "23.4$", "Homestyle desc", 2122));
        foods.add(new Food("waffle", "2222.4$", "What desc", 22222));
        foods.add(new Food("apple", "23.4$", "apple desc", 22));

    }

    @AfterEach
    private void after() {
        foods.clear();
    }

    @Test
    void givenFoodsAndSortAscFirstElementIsApple() {
        FoodSorter.sort(foods, "AsC");
        assertThat(foods.get(0).getName()).isEqualTo("apple");
    }

    @Test
    void givenFoodsAndSortDescFirstElementIsWaffle() {
        FoodSorter.sort(foods, "DeSc");
        assertThat(foods.get(0).getName()).isEqualTo("waffle");
    }
}
