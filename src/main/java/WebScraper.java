import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
public class WebScraper {
    public static void main(String[] args) throws IOException {
        String url = "http://www.filmweb.pl/ranking/netflix";
        System.out.println(("Scrapping from "+ url));

        Document doc = Jsoup.connect(url).get();
        Elements filmLinks = doc.select("a.film__link");

            for (Element link : filmLinks) {
                System.out.println(" Film link:" + link.attr("abs:href") + ", film title: " + link.text());
        }

    }

}