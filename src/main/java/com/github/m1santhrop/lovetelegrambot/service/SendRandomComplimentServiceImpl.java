package com.github.m1santhrop.lovetelegrambot.service;

import com.github.m1santhrop.lovetelegrambot.repository.entity.Compliment;
import com.github.m1santhrop.lovetelegrambot.repository.entity.TelegramUser;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendRandomComplimentServiceImpl implements SendRandomComplimentService {

    private final TelegramUserService telegramUserService;
    private final ComplimentService complimentService;
    private final SendBotMessageService sendBotMessageService;

    @Autowired
    public SendRandomComplimentServiceImpl(
        TelegramUserService telegramUserService,
        ComplimentService complimentService,
        SendBotMessageService sendBotMessageService) {
        this.telegramUserService = telegramUserService;
        this.complimentService = complimentService;
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void sendRandomCompliments() {
        List<TelegramUser> activeUsers = telegramUserService.findByActive(true);

        Compliment randomCompliment = complimentService.findRandomCompliment();

        activeUsers.forEach(
            telegramUser -> sendBotMessageService.sendMessage(telegramUser.getChatId(),
                randomCompliment.getDescription()));
    }
}
