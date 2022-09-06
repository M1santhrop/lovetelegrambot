package com.github.m1santhrop.lovetelegrambot.service;

import com.github.m1santhrop.lovetelegrambot.bot.LoveTelegramBot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
@Service
public class SendBotMessageServiceImpl implements SendBotMessageService {
    
    private final LoveTelegramBot loveTelegramBot;

    @Autowired
    public SendBotMessageServiceImpl(
        LoveTelegramBot loveTelegramBot) {
        this.loveTelegramBot = loveTelegramBot;
    }

    @Override
    public void sendMessage(Long chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);
        sendMessage.enableHtml(true);

        try {
            loveTelegramBot.execute(sendMessage);
            log.info("Message: \"{}\" sent to chat: {}", message, chatId);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
