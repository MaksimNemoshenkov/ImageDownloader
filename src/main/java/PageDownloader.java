import org.jsoup.Jsoup;

import java.io.IOException;

public class PageDownloader {


    public String getPage(String url) {
        String html = "";
        try{
            html = Jsoup.connect(url).get().html();
        }catch (IOException e){
            e.printStackTrace();
        }
        return html;
    }
}
