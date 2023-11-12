package com.example.telegram.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(ConfigManager.class);

    @Override
    public void init() throws ServletException {
        InputStream telegram_is = null;

        try {
            logger.info("ConfigConstatns Init Start..!!!");

            Properties telegram_prop = new Properties();
            telegram_is = getServletContext().getResourceAsStream("/WEB-INF/config/application.properties");
            telegram_prop.load(telegram_is);

            ConfigConstants.TELEGRAM_TOKEN = telegram_prop.getProperty("notification.token");
            ConfigConstants.TELEGRAM_CHAT_ID = telegram_prop.getProperty("notification.chat.id");
        } catch (Exception e) {
            logger.error("error", e);
        } finally {
            try{
                telegram_is.close();
            }catch (IOException e){
                logger.error("error", e);
            }
        }
    }
}
