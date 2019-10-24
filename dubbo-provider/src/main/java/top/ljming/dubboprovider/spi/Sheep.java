package top.ljming.dubboprovider.spi;

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
}
