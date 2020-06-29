package top.ljming.learning.indepth.concurrent;

/**
 * ThreadLocalMap.
 *
 * @author ljming
 */
public class ThreadLocalMapSample {


    private static ThreadLocal<String> parameterHodler = new ThreadLocal<>();


    public static String get() {
        return parameterHodler.get();
    }

    public static void set(String value) {
        parameterHodler.set(value);
    }
}
