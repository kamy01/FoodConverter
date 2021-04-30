package com.file.converter.converter.impl;

import com.file.converter.converter.Converter;
import com.file.converter.file.FileSelector;
import com.file.converter.model.Food;
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
