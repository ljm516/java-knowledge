package top.ljming.dubboprovider.spi;


import org.apache.dubbo.common.URL;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class Dog implements Animal {
    @Override
    public void talk() {
        System.out.println("dog wangwangwang");
    }

    @Override
    public void run(URL url, String s) {
        System.out.println("this is dog run: " + s);
    }

    @Override
    public void eat(URL url) {
        System.out.println("this is dog eat");
    }
}
