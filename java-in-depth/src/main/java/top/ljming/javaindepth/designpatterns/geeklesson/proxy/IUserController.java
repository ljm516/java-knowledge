package top.ljming.javaindepth.designpatterns.geeklesson.proxy;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public interface IUserController {
    void login(String phone, String pwd);
    void register(String phone, String pwd);
}
