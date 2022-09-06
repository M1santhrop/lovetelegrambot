package com.github.m1santhrop.lovetelegrambot.exception;

import com.github.m1santhrop.lovetelegrambot.service.SendBotMessageService;
import javax.ws.rs.NotFoundException;

public class ExceptionSender {

    private static final String NOT_FOUND_USER_MESSAGE = "Вас нет в базе данных. Зарегистрируйтесь в системе с помощью команды /start";

    private static SendBotMessageService sendBotMessageService;

    public static void setSendBotMessageService(SendBotMessageService sendBotMessageService) {
        ExceptionSender.sendBotMessageService = sendBotMessageService;
    }

    private ExceptionSender() {
    }

    public static NotFoundException throwNotFoundUserException(Long chatId) {
        sendBotMessageService.sendMessage(chatId, NOT_FOUND_USER_MESSAGE);
        throw  new NotFoundException(String.format("There is no user with this chatId = %s in the database", chatId));
    }
}
