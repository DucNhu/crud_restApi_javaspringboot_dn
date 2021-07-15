package com.example.api_authen;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiAuthenApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ApiAuthenApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Run code success");
    }
}
