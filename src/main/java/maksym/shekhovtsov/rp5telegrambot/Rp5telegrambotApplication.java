package maksym.shekhovtsov.rp5telegrambot;

import maksym.shekhovtsov.rp5telegrambot.bot.SimpleBot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@SpringBootApplication
public class Rp5telegrambotApplication {

	public static void main(String[] args) {
		SpringApplication.run(Rp5telegrambotApplication.class, args);

    ApiContextInitializer.init();
    TelegramBotsApi botsApi = new TelegramBotsApi();

    try {
      botsApi.registerBot(new SimpleBot());
    } catch (TelegramApiException e) {
      e.printStackTrace();
    }
	}

}
