package org.crawlers;
import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
public class Main {
    public static void main(String[] args) throws Exception {
        final int MAX_CRAWL_DEPTH = 10;
        final int NUMBER_OF_CRAWLERS = 12;
        final String CRAWL_STORAGE = "./data";
        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(CRAWL_STORAGE);
        config.setFollowRedirects(false);
        config.setMaxDepthOfCrawling(MAX_CRAWL_DEPTH);
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);
        controller.addSeed("https://www.google.com/");
        controller.start(Crawler.class, NUMBER_OF_CRAWLERS);
    }
}