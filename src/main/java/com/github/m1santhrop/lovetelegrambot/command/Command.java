package com.github.m1santhrop.lovetelegrambot.command;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface Command {
    void execute(Update update);
}
