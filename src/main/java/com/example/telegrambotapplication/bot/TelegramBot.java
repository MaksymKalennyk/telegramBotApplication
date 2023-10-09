
package com.example.telegrambotapplication.bot;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class TelegramBot extends TelegramLongPollingBot {

    @Value("${bot.name}")
    String botName;

    @Value("${bot.token}")
    String token;

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            if ("/start".equals(messageText)) {
                startCommandReceived(chatId);
            }
        }
    }

    private void startCommandReceived(Long chatId) {
        String answer = "Hi";
        sendMessage(chatId, answer);
    }

    private void sendMessage(Long chatId, String textToSend){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(textToSend);
        sendMessage.setReplyMarkup(Menu());
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            System.out.println(e.getMessage());
        }
    }
    private ReplyKeyboardMarkup Menu(){
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        KeyboardRow buttons = new KeyboardRow();
        buttons.add("Оплата");
        buttons.add("Отримати білет");
        KeyboardRow buttonsSupport = new KeyboardRow();
        buttonsSupport.add("FAQ");
        buttonsSupport.add("Підтримка");
        List<KeyboardRow> rows = new ArrayList<>();
        rows.add(buttons);
        rows.add(buttonsSupport);
        markup.setKeyboard(rows);
        return markup;


    }
}

