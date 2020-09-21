package com.pet.survery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.pet.survery.filter")
public class SurveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SurveryApplication.class, args);
    }

}
