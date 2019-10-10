import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @link http://webmagic.io/docs/zh/
 */
public class DouBanRepoPageProcessor implements PageProcessor {


    public class Result {
        String title;
        String author;
        String num;
        String time;

        public Result(String title, String author, String num, String time) {
            this.title = title;
            this.author = author;
            this.num = num;
            this.time = time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }


    String url = "https://www.douban.com/group/baoanzufang/discussion?start=";

    int currentStep = 0;

    int step = 25;

    private Site site = Site.me()
            .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:66.0)Gecko/20100101 Firefox/66.0")
            .setRetryTimes(3).setSleepTime(1000);

    List<Result> lists = new ArrayList<>();


    @Override
    public void process(Page page) {

        List<Selectable> nodes = page.getHtml().xpath("//table[@class='olt']/tbody/tr[@class!='th']").nodes();

        lists.addAll(
                nodes.stream()
                        .filter(s -> s.xpath("//tr/td[1]/a/text()").toString().contains("女生"))
                        .map(s -> new Result(s.xpath("//tr/td[1]/a/text()").toString(), s.xpath("//tr/td[2]/a/text()").toString(),
                                s.xpath("//tr/td[3]/text()").toString(), s.xpath("//tr/td[4]/text()").toString()))
                         .collect(Collectors.toList()));

        currentStep = currentStep + step;

        if (currentStep > 400) {
            System.err.println(JSON.toJSONString(lists, SerializerFeature.PrettyFormat));

            return;
        }
        page.addTargetRequest(url + currentStep);


    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
//        System.setProperty("javax.net.debug", "all");
        Spider.create(new DouBanRepoPageProcessor())
                .addUrl("https://www.douban.com/group/baoanzufang/discussion?start=0")
                .thread(5).run();
    }


}