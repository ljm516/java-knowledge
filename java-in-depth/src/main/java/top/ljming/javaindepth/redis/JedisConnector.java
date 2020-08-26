package top.ljming.javaindepth.redis;

import redis.clients.jedis.Jedis;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class JedisConnector {

    private volatile Jedis jedis = null;
    private final Object lock = new Object();

    Jedis getConnector() {
        if (null == jedis) {
            synchronized (lock) {
                if (null == jedis) {
                    return new Jedis("127.0.0.1", 6379);
                }
            }
        }
        return jedis;
    }

    void close() {
        jedis.close();
    }
}