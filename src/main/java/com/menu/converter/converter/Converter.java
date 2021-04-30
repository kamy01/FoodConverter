package com.menu.converter.converter;

import com.menu.converter.model.Food;

import java.io.InputStream;
import java.util.List;

public interface Converter {
    List<Food> getBreakfastFoodFrom(InputStream inputStream);
}
