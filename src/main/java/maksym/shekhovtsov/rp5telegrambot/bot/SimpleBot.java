package maksym.shekhovtsov.rp5telegrambot.bot;

import maksym.shekhovtsov.rp5telegrambot.parser.Rp5parser;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SimpleBot extends TelegramLongPollingBot
{

  long chatId;

  long myId = 469109141L;

  @Override
  public void onUpdateReceived(Update update)
  {

    Rp5parser parser = new Rp5parser();

    if (update.hasMessage() && update.getMessage().hasText()) {

      chatId = update.getMessage().getChatId();

      SendMessage message = new SendMessage()
          .setChatId(chatId)
          .setText(parser.getWay());
      try {
        execute(message);
      } catch (TelegramApiException e) {
        e.printStackTrace();
      }
    }
  }

  public void sendRandomMessage() throws Exception
  {
    String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";

    String apiToken = "my_bot_api_token";
    String chatId = "@my_channel_name";
    String text = "Hello world!";

    urlString = String.format(urlString, apiToken, chatId, text);

    URL url = new URL(urlString);
    URLConnection conn = url.openConnection();

    StringBuilder sb = new StringBuilder();
    InputStream is = new BufferedInputStream(conn.getInputStream());
    BufferedReader br = new BufferedReader(new InputStreamReader(is));
    String inputLine = "";
    while ((inputLine = br.readLine()) != null)
    {
      sb.append(inputLine);
    }
    String response = sb.toString();
    // Do what you want with response
  }

  @Override
  public String getBotUsername()
  {
    return "SimpleMaksymBot";
  }

  @Override
  public String getBotToken()
  {
    return "689824969:AAGYbGwztJUh0Vwu1rAbyHdMNy45mHndicI";
  }
}
