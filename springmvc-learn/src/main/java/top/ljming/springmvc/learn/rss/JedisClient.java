package top.ljming.springmvc.learn.rss;

import redis.clients.jedis.Jedis;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class JedisClient {

    private Jedis jedis = new Jedis("localhost", 6379);

    public void pubMessage(String channel, String msg) {
       Long result = jedis.publish(channel, msg);
       System.out.println("publish result=" + result);
    }

    public void subscribe(RSSService.RedisMsgPublishListener listener, String channel) {
        jedis.subscribe(listener, channel);
    }
}
