package com.example.test.file;

public class FileValidator {
    public static boolean isFileValid(String filename) {
        return filename.matches("menu\\.(json|xml)$");
    }
}
