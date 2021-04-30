package com.menu.converter.converter.impl;

import com.menu.converter.converter.Converter;
import com.menu.converter.exceptions.ConverterException;
import com.menu.converter.model.enums.FileExtensions;

public class ConverterFactory {

    public Converter getConvertorFor(String extension) {
        switch (FileExtensions.valueOf(extension.toUpperCase())) {
            case JSON:
                return new JsonConverter();
            case XML:
                return new XmlConverter();
            default:
                throw new ConverterException("Invalid extension for file. Only json/xml supported");
        }
    }
}
