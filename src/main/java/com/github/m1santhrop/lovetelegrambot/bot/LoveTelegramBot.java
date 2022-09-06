package com.github.m1santhrop.lovetelegrambot.bot;

import com.github.m1santhrop.lovetelegrambot.command.CommandContainer;
import com.github.m1santhrop.lovetelegrambot.service.ComplimentService;
import com.github.m1santhrop.lovetelegrambot.service.ComplimentServiceImpl;
import com.github.m1santhrop.lovetelegrambot.service.SendBotMessageService;
import com.github.m1santhrop.lovetelegrambot.service.SendBotMessageServiceImpl;
import com.github.m1santhrop.lovetelegrambot.service.TelegramUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

@Component
@Slf4j
public class LoveTelegramBot extends TelegramLongPollingBot {

    private static final String COMMAND_PREFIX = "/";

    @Value("${bot.username}")
    private String username;

    @Value("${bot.token}")
    private String token;

    private final CommandContainer commandContainer;

    @Autowired
    public LoveTelegramBot(TelegramUserService telegramUserService, ComplimentService complimentService) {
        this.commandContainer = new CommandContainer(telegramUserService, new SendBotMessageServiceImpl(this), complimentService);
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        String userName = receiveUserName(update.getMessage().getFrom());
        log.info("Received message: \"{}\" from {}", update.getMessage().getText(), userName);

        if (update.hasMessage() && update.getMessage().hasText()) {
            String text = update.getMessage().getText().trim();
            if (text.startsWith(COMMAND_PREFIX)) {
                String commandName = text.split("\\s")[0].toLowerCase();
                commandContainer.findCommand(commandName).execute(update);
            } else {
                commandContainer.getUnknownCommand().execute(update);
            }
        } else {
            commandContainer.getUnknownCommand().execute(update);
        }
    }

    private String receiveUserName(User user) {
        return (user.getUserName() == null) ? user.getLastName() + " " + user.getFirstName()
            : user.getUserName();
    }
}
