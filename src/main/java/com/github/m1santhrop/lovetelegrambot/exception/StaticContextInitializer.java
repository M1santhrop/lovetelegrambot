package com.github.m1santhrop.lovetelegrambot.exception;

import com.github.m1santhrop.lovetelegrambot.service.SendBotMessageService;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StaticContextInitializer {
    
    private final SendBotMessageService sendBotMessageService;
    
    @Autowired
    public StaticContextInitializer(
        SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @PostConstruct
    public void init() {
        ExceptionSender.setSendBotMessageService(sendBotMessageService);
    }
}
