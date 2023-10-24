package com.example.telegram.util;

import org.springframework.stereotype.Component;

@Component
public class NotificationManager {
    private final TelegramUtil telegramUtil;

    public NotificationManager(TelegramUtil telegramUtil){
        this.telegramUtil = telegramUtil;
    }

    public void sendMessage() {
        String contents = generateMesage();
        telegramUtil.sendMessage(contents);
    }

    private String generateMesage() {
        StringBuilder sb = new StringBuilder();

        sb.append("[Notification]").append(System.getProperty("line.separator"))
                .append("[Message] : ").append("테스트 메시지 !!! ");

        return sb.toString();
    }
}
