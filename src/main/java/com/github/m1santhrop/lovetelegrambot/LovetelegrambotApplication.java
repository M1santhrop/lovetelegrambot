package com.github.m1santhrop.lovetelegrambot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LovetelegrambotApplication {

	public static void main(String[] args) {
		SpringApplication.run(LovetelegrambotApplication.class, args);
	}

}
