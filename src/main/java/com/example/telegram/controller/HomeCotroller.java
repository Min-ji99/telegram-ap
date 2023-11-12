package com.example.telegram.controller;

import com.example.telegram.util.ConfigConstants;
import com.example.telegram.util.MyTelegramBot;
import com.example.telegram.util.NotificationManager;
import com.example.telegram.util.TelegramUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeCotroller {
    @RequestMapping("/")
    public String index(HttpServletRequest request, HttpServletResponse response){
        NotificationManager notificationManager = new NotificationManager(new TelegramUtil());
        notificationManager.sendMessage();
        return "index";
    }

    @RequestMapping("/telegrambot")
    public String telegramBot(HttpServletRequest request, HttpServletResponse response) {
        MyTelegramBot myTelegramBot = new MyTelegramBot();

        myTelegramBot.sendNotification(ConfigConstants.TELEGRAM_CHAT_ID, "test 메세지");

        return "index";
    }
}
