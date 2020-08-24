import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
    public static void main(String[] args){
        //Jsoup이용하여 http://www.cgv.co.kr/movies/ 크롤링
        String url = "http://www.cgv.co.kr/movies/";
        Document doc = null;

        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e){
            e.printStackTrace();
        }
        //select를 이용하여 원하는 태그 선택
        Elements element = doc.select("div.sect-movie-chart");

        System.out.println("========================================================");

        //Iterator를 사용하여 하나씩 값 가져오기
        Iterator<Element> rank = element.select("strong.rank").iterator();
        Iterator<Element> title = element.select("strong.title").iterator();
        Iterator<Element> percent = element.select("strong.percent").iterator();
        Iterator<Element> txt_info = element.select("span.txt-info").iterator();



        System.out.println("http://www.cgv.co.kr/movies/ 사이트 크롤링 예제");
        while (rank.hasNext()) {
            System.out.println(rank.next().text()+"\t"+title.next().text()+"\t"+percent.next().text()+"\t"+txt_info.next().text());
        }

        System.out.println("=======================================================");
    }
}
