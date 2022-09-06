package com.github.m1santhrop.lovetelegrambot.service;

import com.github.m1santhrop.lovetelegrambot.repository.ComplimentRepository;
import com.github.m1santhrop.lovetelegrambot.repository.entity.Compliment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComplimentServiceImpl implements ComplimentService {
    
    private final ComplimentRepository complimentRepository;

    @Autowired
    public ComplimentServiceImpl(
        ComplimentRepository complimentRepository) {
        this.complimentRepository = complimentRepository;
    }

    @Override
    public Compliment findRandomCompliment() {
        long tableSize = complimentRepository.count();

        return complimentRepository.findRandomCompliment(tableSize);
    }
}
