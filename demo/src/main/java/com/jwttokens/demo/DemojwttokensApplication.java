package com.jwttokens.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class DemojwttokensApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemojwttokensApplication.class, args);
    }

}