package com.surinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan(basePackages = "com.surinder")
@EnableAutoConfiguration
@Configuration
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        System.out.println("Hello, Docker with Maven!");
    }

    @GetMapping("/greet")
    public String greet(){
        return "Hello";
    }
    @GetMapping("/")
    public String entry(){
        return "<h1>Hello! from Docker for Maven</h1><h3> Welcome to your landing page</h3>";
    }
}
