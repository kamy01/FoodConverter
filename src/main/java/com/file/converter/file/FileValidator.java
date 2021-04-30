package com.file.converter.file;

public class FileValidator {
    public static boolean isFileValid(String filename) {
        return filename.matches("menu\\.(json|xml)$");
    }
}
