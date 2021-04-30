package com.file.converter.file;

import com.file.converter.exceptions.FileException;

import java.io.File;
import java.net.URL;

public class FileSelector {

    public static File getFile(String fileName) {
        ClassLoader classLoader = FileSelector.class.getClassLoader();
        URL url = classLoader.getResource(fileName);
        File file;
        if (url != null) {
            file = new File(url.getFile());
        } else {
            throw new FileException("File not found");
        }
        return file;
    }
}
