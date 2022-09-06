package com.github.m1santhrop.lovetelegrambot.command;

import static com.github.m1santhrop.lovetelegrambot.exception.ExceptionSender.throwNotFoundUserException;
import com.github.m1santhrop.lovetelegrambot.exception.ExceptionSender;
import com.github.m1santhrop.lovetelegrambot.service.SendBotMessageService;
import com.github.m1santhrop.lovetelegrambot.service.TelegramUserService;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;

@AllArgsConstructor
public class StopCommand implements Command {

    private static final String STOP_MESSAGE = "Деактивировал вас в системе!";

    private final TelegramUserService telegramUserService;
    private final SendBotMessageService sendBotMessageService;

    @Override
    public void execute(Update update) {
        Long chatId = CommandUtils.getChatId(update);
        telegramUserService.findByChatId(chatId).ifPresentOrElse(telegramUser -> {
            telegramUser.setActive(false);
            telegramUserService.save(telegramUser);
            sendBotMessageService.sendMessage(chatId, STOP_MESSAGE);
        }, () -> throwNotFoundUserException(chatId));
    }
}
