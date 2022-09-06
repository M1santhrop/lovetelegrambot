package com.github.m1santhrop.lovetelegrambot.service;

public interface SendBotMessageService {
    void sendMessage(Long chatId, String message);
}
