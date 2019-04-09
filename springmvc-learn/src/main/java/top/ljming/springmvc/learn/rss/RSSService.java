package top.ljming.springmvc.learn.rss;

import redis.clients.jedis.JedisPubSub;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class RSSService implements Runnable {

    private JedisClient client = new JedisClient();

    @Override
    public void run() {
        client.subscribe(new RedisMsgPublishListener(), "helloWorld");
    }

    public class RedisMsgPublishListener extends JedisPubSub {
        @Override
        public void onMessage(String channel, String message) {

            System.out.println("channel:" + channel + "receives message :" + message);
        }

        @Override
        public void onPMessage(String pattern, String channel, String message) {

        }

        @Override
        public void onPSubscribe(String pattern, int subscribedChannels) {

        }

        @Override
        public void onPUnsubscribe(String pattern, int subscribedChannels) {

        }

        @Override
        public void onSubscribe(String channel, int subscribedChannels) {
            System.out.println("channel:" + channel + "is been subscribed:" + subscribedChannels);
        }

        @Override
        public void onUnsubscribe(String channel, int subscribedChannels) {
            System.out.println("channel:" + channel + "is been unsubscribed:" + subscribedChannels);
        }
    }
}
