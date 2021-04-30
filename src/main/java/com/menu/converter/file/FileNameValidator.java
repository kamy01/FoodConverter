package com.menu.converter.file;

public class FileNameValidator {
    public static boolean isValid(String filename) {
        return filename.matches("menu\\.(json|xml)$");
    }
}
