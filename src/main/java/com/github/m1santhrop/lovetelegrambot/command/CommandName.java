package com.github.m1santhrop.lovetelegrambot.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CommandName {
    
    START("/start"),
    STOP("/stop"),
    GENERATE_COMPLIMENT("/compliment"),
    HELP("/help");
    
    private final String name;
}
