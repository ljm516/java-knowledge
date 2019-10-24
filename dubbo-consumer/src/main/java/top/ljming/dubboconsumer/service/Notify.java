package top.ljming.dubboconsumer.service;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public interface Notify {
    void onreturn(String msg, Integer id);
    void onthrow(Throwable t, Integer id);
}
