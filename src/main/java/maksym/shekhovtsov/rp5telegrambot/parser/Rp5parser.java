package maksym.shekhovtsov.rp5telegrambot.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class Rp5parser
{
  public String getWay() {

    String way = "";

    String webPage = "http://rp5.ua/%D0%9F%D0%BE%D0%B3%D0%BE%D0%B4%D0%B0_%D0%B2_%D0%A5%D0%B0%D1%80%D1%8C%D0%BA%D0%BE%D0%B2%D0%B5";

    Document document = null;
    try {
      document = Jsoup.connect(webPage).get();
    }
    catch (Exception e) {
      e.printStackTrace();
    }

    Elements element1day = document.getElementById("forecastTable_1").select("tr");

    for(Element e: element1day) {
      if (e.selectFirst("td").text().equals("направление")) {
        Element wind = e.selectFirst(".grayLittlen");
        if (wind == null) {
          wind = e.selectFirst(".grayLittled");
        }
        way = wind.html();
        System.out.println(wind.html());
      }
    }

    return way;
  }
}
