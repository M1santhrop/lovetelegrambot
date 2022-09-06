package com.github.m1santhrop.lovetelegrambot.command;

import com.github.m1santhrop.lovetelegrambot.exception.ExceptionSender;
import com.github.m1santhrop.lovetelegrambot.repository.entity.Compliment;
import com.github.m1santhrop.lovetelegrambot.repository.entity.TelegramUser;
import com.github.m1santhrop.lovetelegrambot.service.ComplimentService;
import com.github.m1santhrop.lovetelegrambot.service.SendBotMessageService;
import com.github.m1santhrop.lovetelegrambot.service.TelegramUserService;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;

@AllArgsConstructor
public class GenerateComplimentCommand implements Command {

    private final TelegramUserService telegramUserService;
    private final ComplimentService complimentService;
    private final SendBotMessageService sendBotMessageService;

    @Override
    public void execute(Update update) {
        Long chatId = CommandUtils.getChatId(update);
        TelegramUser telegramUser = telegramUserService.findByChatId(chatId).orElseThrow(
            () -> ExceptionSender.throwNotFoundUserException(chatId));

        if (Boolean.FALSE.equals(telegramUser.getActive())) {
            sendBotMessageService.sendMessage(chatId,
                "Вы не активированы в системе. Используйте команду /start для активации.");
        } else {
            Compliment randomCompliment = complimentService.findRandomCompliment();
            sendBotMessageService.sendMessage(chatId, randomCompliment.getDescription());
        }
    }
}
