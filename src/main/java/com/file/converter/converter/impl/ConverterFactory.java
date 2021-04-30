package com.file.converter.converter.impl;

import com.file.converter.converter.Converter;
import com.file.converter.exceptions.ConverterException;
import com.file.converter.model.enums.FileExtensions;

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
