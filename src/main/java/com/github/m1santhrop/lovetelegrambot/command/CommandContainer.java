package com.github.m1santhrop.lovetelegrambot.command;

import static com.github.m1santhrop.lovetelegrambot.command.CommandName.*;
import com.github.m1santhrop.lovetelegrambot.service.ComplimentService;
import com.github.m1santhrop.lovetelegrambot.service.SendBotMessageService;
import com.github.m1santhrop.lovetelegrambot.service.TelegramUserService;
import com.google.common.collect.ImmutableMap;

public class CommandContainer {

    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;

    public CommandContainer(TelegramUserService telegramUserService,
        SendBotMessageService sendBotMessageService, ComplimentService complimentService) {
        this.commandMap = ImmutableMap.<String, Command>builder()
            .put(START.getName(), new StartCommand(telegramUserService, sendBotMessageService))
            .put(STOP.getName(), new StopCommand(telegramUserService, sendBotMessageService))
            .put(GENERATE_COMPLIMENT.getName(), new GenerateComplimentCommand(telegramUserService, complimentService, sendBotMessageService))
            .put(HELP.getName(), new HelpCommand(sendBotMessageService))
            .build();

        this.unknownCommand = new UnknownCommand(sendBotMessageService);
    }

    public Command findCommand(String commandName) {
        return commandMap.getOrDefault(commandName, unknownCommand);
    }

    public Command getUnknownCommand() {
        return unknownCommand;
    }
}