package com.keysoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.keysoft")
public class BuckTrackerJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuckTrackerJpaApplication.class,args);
    }
}
