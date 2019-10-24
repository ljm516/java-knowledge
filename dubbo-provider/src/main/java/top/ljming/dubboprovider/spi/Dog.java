package top.ljming.dubboprovider.spi;

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
}
