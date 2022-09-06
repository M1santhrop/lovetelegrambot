package com.github.m1santhrop.lovetelegrambot.job;

import com.github.m1santhrop.lovetelegrambot.service.SendRandomComplimentService;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GenerateRandomComplimentJob {
    
    private final SendRandomComplimentService sendRandomCompliments;

    @Autowired
    public GenerateRandomComplimentJob(
        SendRandomComplimentService sendRandomCompliments) {
        this.sendRandomCompliments = sendRandomCompliments;
    }

    @Scheduled(cron = "${bot.morningTime}")
    public void sendRandomComplimentInTheMorning() {
        LocalDateTime start = LocalDateTime.now();
        log.info("Send random compliments job started.");

        sendRandomCompliments.sendRandomCompliments();

        LocalDateTime end = LocalDateTime.now();
        log.info("Send random compliments job finished. Took seconds: {}", end.toEpochSecond(ZoneOffset.UTC) - start.toEpochSecond(ZoneOffset.UTC));
    }

    @Scheduled(cron = "${bot.middayTime}")
    public void sendRandomComplimentInTheMidday() {
        LocalDateTime start = LocalDateTime.now();
        log.info("Send random compliments job started.");

        sendRandomCompliments.sendRandomCompliments();

        LocalDateTime end = LocalDateTime.now();
        log.info("Send random compliments job finished. Took seconds: {}", end.toEpochSecond(ZoneOffset.UTC) - start.toEpochSecond(ZoneOffset.UTC));
    }

    @Scheduled(cron = "${bot.eveningTime}")
    public void sendRandomComplimentInTheEvening() {
        LocalDateTime start = LocalDateTime.now();
        log.info("Send random compliments job started.");

        sendRandomCompliments.sendRandomCompliments();

        LocalDateTime end = LocalDateTime.now();
        log.info("Send random compliments job finished. Took seconds: {}", end.toEpochSecond(ZoneOffset.UTC) - start.toEpochSecond(ZoneOffset.UTC));
    }

    @Scheduled(cron = "${bot.nightTime}")
    public void sendRandomComplimentInTheNight() {
        LocalDateTime start = LocalDateTime.now();
        log.info("Send random compliments job started.");

        sendRandomCompliments.sendRandomCompliments();

        LocalDateTime end = LocalDateTime.now();
        log.info("Send random compliments job finished. Took seconds: {}", end.toEpochSecond(ZoneOffset.UTC) - start.toEpochSecond(ZoneOffset.UTC));
    }
    
}
