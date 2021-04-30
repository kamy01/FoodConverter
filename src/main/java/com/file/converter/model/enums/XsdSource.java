package com.file.converter.model.enums;

public enum XsdSource {
    MENU("menu.xsd"),
    UNKNOWN("unknown");
    private String source;

    XsdSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return source;
    }
}
