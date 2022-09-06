package com.github.m1santhrop.lovetelegrambot.command;

import org.telegram.telegrambots.meta.api.objects.Update;

public class CommandUtils {

    private CommandUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static Long getChatId(Update update) {
        return update.getMessage().getChatId();
    }
}
