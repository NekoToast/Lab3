import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;


public class ThreadScrapper {
    public static void main(String[] args) throws IOException, InterruptedException {
        String url = "http://scraping.pro/web-scraper-test-drive/";
        System.out.println(("Scrapping from "+ url));

        Document doc = Jsoup.connect(url).get();
        final Elements scrapNames = doc.select("a.scr_name");
        final Elements columnNames = doc.select("td:eq(0)");
        final Elements commentsList = doc.select("div.commententry");

        Thread thread = new Thread(){
            public void run(){
                for (Element name : scrapNames) {
                    System.out.println(" Scrapping program name: " + name.text());
                }
            }
        };


        Thread thread2 = new Thread(){
            public void run(){
                for (Element rating : columnNames) {
                    System.out.println(" Scrapping column names: " + rating.ownText());
                }
            }
        };


        Thread thread3 = new Thread(){
            public void run(){
                for (Element comments : commentsList) {
                    System.out.println(" Scrapping comments from site: " + comments.text());
                }
            }
        };

        thread.start();
        Thread.sleep(500);
        thread2.start();
        Thread.sleep(500);
        thread3.start();
    }
}