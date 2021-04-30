package com.menu.converter;

import com.menu.converter.interaction.UserInteraction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MenuConverterApplication {

    public static void main(String[] args) {
        SpringApplication.run(MenuConverterApplication.class, args);
        UserInteraction userInteraction = new UserInteraction();
        userInteraction.execute();
    }
}
