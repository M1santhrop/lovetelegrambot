package com.github.m1santhrop.lovetelegrambot.command;

import com.github.m1santhrop.lovetelegrambot.service.SendBotMessageService;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;

@AllArgsConstructor
public class UnknownCommand implements Command {

    private static final String UNKNOWN_MESSAGE = "Не понимаю вас \uD83D\uDE1F, напишите /help чтобы узнать что я понимаю.";

    private final SendBotMessageService sendBotMessageService;

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(CommandUtils.getChatId(update), UNKNOWN_MESSAGE);
    }
}
