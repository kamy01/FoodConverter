package com.file.converter.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Root {
    @JsonProperty("breakfast_menu")
    private Menu breakFast;
}
