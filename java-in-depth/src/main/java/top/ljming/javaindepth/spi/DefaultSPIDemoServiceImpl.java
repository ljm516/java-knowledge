package top.ljming.javaindepth.spi;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class DefaultSPIDemoServiceImpl implements SPIDemoService {
    @Override
    public void demo() {
        System.out.println("default");
    }
}
