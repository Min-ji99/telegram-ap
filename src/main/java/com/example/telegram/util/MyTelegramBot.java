package com.example.telegram.util;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyTelegramBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "java_telegram_api_bot";
    }

    @Override
    public String getBotToken() {
        return ConfigConstants.TELEGRAM_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {

    }

    public void sendNotification(String chatId, String text) {
        SendMessage sendMessage = new SendMessage(chatId, text) ;

        try{
            execute(sendMessage);
        } catch(TelegramApiException e) {
            e.printStackTrace();
        }

    }
}
