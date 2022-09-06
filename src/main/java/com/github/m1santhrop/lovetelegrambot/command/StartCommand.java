package com.github.m1santhrop.lovetelegrambot.command;

import com.github.m1santhrop.lovetelegrambot.repository.entity.TelegramUser;
import com.github.m1santhrop.lovetelegrambot.service.SendBotMessageService;
import com.github.m1santhrop.lovetelegrambot.service.TelegramUserService;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;

@AllArgsConstructor
public class StartCommand implements Command {

    private static final String START_MESSAGE =
        "Привет. Я Love Telegram Bot. Я умею генерировать комплименты, а также отправлять их по расписанию. "
            + "\n" + "Активировал вас в системе!";

    private final TelegramUserService telegramUserService;
    private final SendBotMessageService sendBotMessageService;

    @Override
    public void execute(Update update) {
        Long chatId = CommandUtils.getChatId(update);
        telegramUserService.findByChatId(chatId).ifPresentOrElse(telegramUser -> {
                telegramUser.setActive(true);
                telegramUserService.save(telegramUser);
            },
            () -> {
                TelegramUser newTelegramUser = new TelegramUser();
                newTelegramUser.setChatId(chatId);
                newTelegramUser.setActive(true);
                telegramUserService.save(newTelegramUser);
            }
        );
        sendBotMessageService.sendMessage(chatId, START_MESSAGE);
    }
}
