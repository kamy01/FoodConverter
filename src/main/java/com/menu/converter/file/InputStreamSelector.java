package com.menu.converter.file;

import java.io.InputStream;

public class InputStreamSelector {

    public static InputStream getInputStreamFrom(String fileName) {
        return InputStreamSelector.class.getResourceAsStream("/" +fileName);
    }
}
