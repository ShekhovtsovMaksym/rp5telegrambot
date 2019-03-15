package maksym.shekhovtsov.rp5telegrambot;

import maksym.shekhovtsov.rp5telegrambot.bot.SimpleBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;

@Configuration
@EnableScheduling
@SpringBootApplication
public class Rp5telegramBotApplication
{

  @Autowired
  SimpleBot simpleBot;

  @Autowired
  TelegramBotsApi telegramBotsApi;

  public static void main(String[] args)
  {
    ApiContextInitializer.init();

    SpringApplication.run(Rp5telegramBotApplication.class, args);
  }

  @Bean
  public TelegramBotsApi getTelegramBotsApi() {
    return new TelegramBotsApi();
  }
}
