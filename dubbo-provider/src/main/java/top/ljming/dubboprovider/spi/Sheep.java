package top.ljming.dubboprovider.spi;

import org.apache.dubbo.common.URL;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class Sheep implements Animal {
    @Override
    public void talk() {
        System.out.println("sheep miemiemie");
    }

    @Override
    public void run(URL url,  String s) {
        System.out.println("this is sheep run: " + s);
    }

    @Override
    public void eat(URL url) {
        System.out.println("this is sheep eat");
    }
}
