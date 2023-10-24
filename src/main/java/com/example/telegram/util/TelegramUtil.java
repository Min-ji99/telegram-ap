package com.example.telegram.util;

import com.example.telegram.dto.TelegramMessage;
import com.google.gson.Gson;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Configuration
public class TelegramUtil {
    private String token = System.getProperty("notification.token");

    private String chatId = System.getProperty("notification.chatId");


    public void sendMessage(String content) {
        System.out.println("### token : "+token);
        System.out.println("### chatId : "+chatId);

        String url = "https://api.telegram.org/bot" + token + "/sendMessage";

        try {
            TelegramMessage telegramMessage = new TelegramMessage(chatId, content);
            String param = new Gson().toJson(telegramMessage);

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);

            HttpEntity<String> entity = new HttpEntity<>(param, headers);
            restTemplate.postForEntity(url, entity, String.class);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
