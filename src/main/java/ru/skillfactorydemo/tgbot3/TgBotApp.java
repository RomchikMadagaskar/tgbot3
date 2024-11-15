package ru.skillfactorydemo.tgbot3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class TgBotApp {
    public static void main(String[] args) {
        SpringApplication.run(TgBotApp.class, args);
    }
}