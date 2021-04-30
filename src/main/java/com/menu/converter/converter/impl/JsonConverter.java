package com.menu.converter.converter.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.menu.converter.converter.Converter;
import com.menu.converter.converter.impl.utils.MapperUtils;
import com.menu.converter.model.Food;
import com.menu.converter.model.Root;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public class JsonConverter implements Converter {

    public List<Food> getBreakfastFoodFrom(InputStream inputStream) {
        ObjectMapper objectMapper = MapperUtils.getMapper();
        final List<Food> foods = new ArrayList<>();
        Root root = null;
        try {
            root = objectMapper.readValue(inputStream, Root.class);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        if (root != null && root.getBreakFast() != null) {
            Optional.ofNullable(root.getBreakFast().getFood()).ifPresent(foods::addAll);
        }
        return foods;
    }

}
