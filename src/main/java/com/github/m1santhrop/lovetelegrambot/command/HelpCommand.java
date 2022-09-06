package com.github.m1santhrop.lovetelegrambot.command;

import static com.github.m1santhrop.lovetelegrambot.command.CommandName.*;
import static com.github.m1santhrop.lovetelegrambot.command.CommandName.HELP;
import static com.github.m1santhrop.lovetelegrambot.command.CommandName.START;
import static com.github.m1santhrop.lovetelegrambot.command.CommandName.STOP;
import static com.github.m1santhrop.lovetelegrambot.command.CommandUtils.*;
import com.github.m1santhrop.lovetelegrambot.service.SendBotMessageService;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;

@AllArgsConstructor
public class HelpCommand implements Command {

    private static final String HELP_MESSAGE = String.format("✨<b>Доступные команды</b>✨\n\n"
            + "%s - начать работу с ботом\n"
            + "%s - приостановить работу с ботом\n\n"
            + "%s - получить случайный комплимент\n"
            + "%s - получить помощь в работе с ботом\n",
        START.getName(), STOP.getName(), GENERATE_COMPLIMENT.getName(), HELP.getName());

    private final SendBotMessageService sendBotMessageService;

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(getChatId(update), HELP_MESSAGE);
    }
}
