package com.example.test.convertor;

import com.example.test.model.Food;

import java.io.File;
import java.util.List;

public interface Converter {
    List<Food> getBreakfastFoodFrom(File file);
}
