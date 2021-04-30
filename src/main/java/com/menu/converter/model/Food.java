package com.menu.converter.model;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@XmlRootElement(name = "foods")
public class Food {

    private String name;
    private String price;
    private String description;
    private double calories;


}
