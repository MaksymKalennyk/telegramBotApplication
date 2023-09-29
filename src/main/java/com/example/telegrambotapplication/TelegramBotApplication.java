package com.example.telegrambotapplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class TelegramBotApplication {

    private static final Logger log = LoggerFactory.getLogger(TelegramBotApplication.class);

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        try {
            log.info("Registering bot...");
            telegramBotsApi.registerBot(new SimpleBot());
        } catch (TelegramApiRequestException e) {
            log.error("Failed to register bot(check internet connection / bot token or make sure only one instance of bot is running).", e);
        }
        log.info("Telegram bot is ready to accept updates from user......");
    }
}


