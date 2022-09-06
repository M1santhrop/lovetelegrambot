package com.github.m1santhrop.lovetelegrambot.service;

import com.github.m1santhrop.lovetelegrambot.repository.entity.TelegramUser;
import java.util.List;
import java.util.Optional;

public interface TelegramUserService {
    void save(TelegramUser telegramUser);
    Optional<TelegramUser> findByChatId(Long chatId);
    List<TelegramUser> findByActive(Boolean active);
}
