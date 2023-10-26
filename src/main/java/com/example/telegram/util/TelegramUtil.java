package com.example.telegram.util;

import com.example.telegram.dto.TelegramMessage;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan
public class TelegramUtil {
/*    private String token = System.getProperty("notification.token");

    private String chatId = System.getProperty("notification.chatId");*/



    public void sendMessage(String content) {
        System.out.println("### token : "+ ConfigConstants.TELEGRAM_TOKEN);

        String url = "https://api.telegram.org/bot" + ConfigConstants.TELEGRAM_TOKEN + "/sendMessage";

        try {
            TelegramMessage telegramMessage = new TelegramMessage(ConfigConstants.TELEGRAM_CHAT_ID, content);
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
