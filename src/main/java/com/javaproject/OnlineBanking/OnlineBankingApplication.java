package com.javaproject.OnlineBanking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.javaproject.OnlineBanking.model")
@ComponentScan(basePackages = {"com.javaproject.OnlineBanking.controller", "com.javaproject.OnlineBanking.service", "com.javaproject.OnlineBanking.repository"})
public class OnlineBankingApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineBankingApplication.class, args);
    }
}