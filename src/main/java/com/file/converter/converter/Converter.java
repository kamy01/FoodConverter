package com.file.converter.converter;

import com.file.converter.model.Food;

import java.io.File;
import java.util.List;

public interface Converter {
    List<Food> getBreakfastFoodFrom(File file);
}
