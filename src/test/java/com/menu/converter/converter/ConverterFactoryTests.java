package com.menu.converter.converter;

import com.menu.converter.converter.impl.ConverterFactory;
import com.menu.converter.converter.impl.JsonConverter;
import com.menu.converter.converter.impl.XmlConverter;
import com.menu.converter.exceptions.ConverterException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ConverterFactoryTests {

    ConverterFactory factory;

    @BeforeAll
    private void before() {
        factory = new ConverterFactory();
    }

    @Test
    void givenJsonExtensionThenJsonConverterIsCreated() {
        assertThat(factory.getConvertorFor("jSoN")).isInstanceOf(JsonConverter.class);
    }

    @Test
    void givenXmlExtensionThenXmlConverterIsCreated() {
        assertThat(factory.getConvertorFor("xMl")).isInstanceOf(XmlConverter.class);
    }

    @Test
    void givenNotSupportedExtensionThenConverterExceptionIsThrown() {
        assertThatThrownBy(() -> factory.getConvertorFor("jpeg"))
                .isInstanceOf(ConverterException.class)
                .hasMessageContaining("Invalid extension for file");

    }
}
