package com.github.m1santhrop.lovetelegrambot.repository;

import com.github.m1santhrop.lovetelegrambot.repository.entity.TelegramUser;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelegramUserRepository extends JpaRepository<TelegramUser, Long> {
    Optional<TelegramUser> findByChatId(Long chatId);
    List<TelegramUser> findByActive(Boolean active);
}
