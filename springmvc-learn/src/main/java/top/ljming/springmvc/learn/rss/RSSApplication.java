package top.ljming.springmvc.learn.rss;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class RSSApplication {

    private static RSSService rssService = new RSSService();

    public static void main(String[] args) throws InterruptedException {
        rssService.run();
        Thread.currentThread().join();
    }
}
