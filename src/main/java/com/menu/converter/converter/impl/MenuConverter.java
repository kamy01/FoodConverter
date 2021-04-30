package com.menu.converter.converter.impl;

import com.menu.converter.converter.Converter;
import com.menu.converter.file.InputStreamSelector;
import com.menu.converter.model.Food;
import org.apache.commons.io.FilenameUtils;

import java.io.InputStream;
import java.util.List;

public class MenuConverter {

    public List<Food> getConvertedFoodFrom(String fileName) {

        InputStream inputStream = InputStreamSelector.getInputStreamFrom(fileName);
        Converter converter = new ConverterFactory()
                .getConvertorFor(FilenameUtils.getExtension(fileName));
        return converter.getBreakfastFoodFrom(inputStream);
    }


}
