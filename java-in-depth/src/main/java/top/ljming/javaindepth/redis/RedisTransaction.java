package top.ljming.javaindepth.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

import java.util.List;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class RedisTransaction {

    private static JedisConnector jedisConnector = new JedisConnector();

    public static void main(String[] args) {
        Jedis jedis = jedisConnector.getConnector();
        Transaction jtx = jedis.multi();
        jtx.set("books", "java");
        jtx.incr("books"); // 这里执行对字符串进行++，失败
        jtx.set("learn", "redis");

        List<Object> execResultList = jtx.exec(); // 上面只是把命令入队，这里才是执行
        for (Object o : execResultList) {
            System.out.println("exec res: " + o);
        }
        jtx.close();

        Response<String> rsp = jtx.get("books");
        String books = rsp.get();
        System.out.println("books: " + books);

        rsp = jtx.get("books");
        String learn = rsp.get();
        System.out.println("learn: " + learn);

        // jtx.discard();
        jedisConnector.close();

    }
}
