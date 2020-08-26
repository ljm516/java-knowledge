package top.ljming.javaindepth.designpatterns.geeklesson.proxy;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class UserController implements IUserController {
    @Override
    public void login(String phone, String pwd) {
        System.out.println("phone: " + phone + "; pwd: " + pwd);
    }

    @Override
    public void register(String phone, String pwd) {

    }
}
