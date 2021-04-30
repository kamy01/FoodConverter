package com.file.converter;

import com.file.converter.interaction.UserInteraction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
        UserInteraction userInteraction = new UserInteraction();
        userInteraction.execute();
    }
}
