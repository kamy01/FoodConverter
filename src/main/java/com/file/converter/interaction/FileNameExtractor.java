package com.file.converter.interaction;

import com.file.converter.file.FileValidator;
import org.apache.logging.log4j.util.Strings;

import java.util.Scanner;

public class FileNameExtractor {

    public static String getValidFilename() {
        Scanner in = new Scanner(System.in);
        boolean validFile;
        String fileName;
        int count = 0;
        do {
            System.out.println("Please write the filename (eg: menu.json)");
            fileName = in.next().toLowerCase().strip();
            validFile = FileValidator.isFileValid(fileName);
            if (!validFile) {
                System.out.println("Wrong file name. Expected menu.json/menu.xml");
            }
            count++;
            if (count == 3) {
                fileName = Strings.EMPTY;
                System.out.println("Wrong file name 3 times. Exiting the program");
            }
        } while (!validFile && count < 3);
        return fileName;
    }
}
