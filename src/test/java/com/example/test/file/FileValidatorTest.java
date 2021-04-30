package com.example.test.file;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FileValidatorTest {

    @Test
    void givenWrongFileNameThenReturnsFalse() {
        assertThat(FileValidator.isFileValid("menus.xml")).isFalse();
    }

    @Test
    void givenCorrectFileNameThenReturnsTrue() {
        assertThat(FileValidator.isFileValid("menu.json")).isTrue();
    }
}
