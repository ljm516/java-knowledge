package top.ljming.javaindepth.designpatterns.geeklesson.single;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 单例模式.
 *
 * 要实现一个单例模式，需要关注的点:
 * 1. 构造函数要是private的，这样才能避免外部通过new访问。
 * 2. 考虑对象创建时的线程安全问题。
 * 3. 考虑是否支持延迟加载
 * 4. 考虑getInstance()性能是否高（是否加锁）
 * @author ljming
 */
public class Singleton {

    private Singleton() {}

    /*
    饿汉式:
    不支持延迟加载
    private static final Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }
     */


    /*
    懒汉式:
    支持延迟加载
    锁粒度太大
    private static Singleton instance;
    public synchronized static Singleton getInstance() {
        if (null == instance) {
            instance = new Singleton();
        }
        return instance;
    }
     */

    /*
    双重检查:
    支持延迟加载
    并发度高
    有可能发生指令重排序，导致instance实例不是一个可用的实例
    private static Singleton instance;
    public static Singleton getInstance() {
        if (null == instance) {
            synchronized (Singleton.class) {
                if (null == instance) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
     */

    /*
    双重检测+volatile关键字
    private volatile static Singleton instance;
    public static Singleton getInstance() {
        if (null == instance) {
            synchronized (Singleton.class) {
                if (null == instance) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
     */

    /*
    静态内部类:
    支持延迟加载
    线程安全
    private static class SingletonHolder {
        private static final Singleton instance = new Singleton();
    }
    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }
     */

    public enum Single {
        INSTANCE;
        private AtomicInteger id = new AtomicInteger(0);

        public long getId() {
            return id.incrementAndGet();
        }
    }
}

