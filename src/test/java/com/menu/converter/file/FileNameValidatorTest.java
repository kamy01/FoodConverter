package com.menu.converter.file;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FileNameValidatorTest {

    @Test
    void givenWrongFileNameThenReturnsFalse() {
        assertThat(FileNameValidator.isValid("menus.xml")).isFalse();
    }

    @Test
    void givenCorrectFileNameThenReturnsTrue() {
        assertThat(FileNameValidator.isValid("menu.json")).isTrue();
    }
}
