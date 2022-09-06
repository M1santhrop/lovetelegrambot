package com.github.m1santhrop.lovetelegrambot.service;

import com.github.m1santhrop.lovetelegrambot.repository.TelegramUserRepository;
import com.github.m1santhrop.lovetelegrambot.repository.entity.TelegramUser;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelegramUserServiceImpl implements TelegramUserService {
    
    private TelegramUserRepository telegramUserRepository;

    @Autowired
    public TelegramUserServiceImpl(
        TelegramUserRepository telegramUserRepository) {
        this.telegramUserRepository = telegramUserRepository;
    }

    @Override
    public void save(TelegramUser telegramUser) {
        telegramUserRepository.save(telegramUser);
    }

    @Override
    public Optional<TelegramUser> findByChatId(Long chatId) {
        return telegramUserRepository.findByChatId(chatId);
    }

    @Override
    public List<TelegramUser> findByActive(Boolean active) {
        return telegramUserRepository.findByActive(active);
    }
}
