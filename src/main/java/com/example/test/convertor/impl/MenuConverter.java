package com.example.test.convertor.impl;

import com.example.test.convertor.Converter;
import com.example.test.file.FileSelector;
import com.example.test.model.Food;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.List;

public class MenuConverter {

    public List<Food> getConvertedFoodFrom(String fileName) {

        File file = FileSelector.getFile(fileName);
        Converter converter = new ConverterFactory()
                .getConvertorFor(FilenameUtils.getExtension(fileName));
        return converter.getBreakfastFoodFrom(file);
    }


}
