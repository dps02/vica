package com.vicahydrate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.vicahydrate.model") // Add this if the error persists
@EnableJpaRepositories("com.vicahydrate.repository")
public class VicaHydrateApplication {
    public static void main(String[] args) {
        SpringApplication.run(VicaHydrateApplication.class, args);
    }
}