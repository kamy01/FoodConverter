package com.example.test.convertor.impl;

import com.example.test.convertor.Converter;
import com.example.test.exceptions.ConverterException;
import com.example.test.model.enums.FileExtensions;

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
