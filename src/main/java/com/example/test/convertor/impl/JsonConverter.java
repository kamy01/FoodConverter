package com.example.test.convertor.impl;

import com.example.test.convertor.Converter;
import com.example.test.convertor.impl.utils.MapperUtils;
import com.example.test.model.Food;
import com.example.test.model.Root;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public class JsonConverter implements Converter {

    public List<Food> getBreakfastFoodFrom(File file) {
        ObjectMapper objectMapper = MapperUtils.getMapper();
        final List<Food> foods = new ArrayList<>();
        Root root = null;
        try {
            root = objectMapper.readValue(file, Root.class);

        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        if (root != null && root.getBreakFast() != null) {
            Optional.ofNullable(root.getBreakFast().getFood()).ifPresent(foods::addAll);
        }
        return foods;
    }

}
