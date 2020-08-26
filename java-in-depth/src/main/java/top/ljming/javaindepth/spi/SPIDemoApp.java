package top.ljming.javaindepth.spi;

import java.util.ServiceLoader;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class SPIDemoApp {
    public static void main(String[] args) {
        ServiceLoader<SPIDemoService> serviceLoader = ServiceLoader.load(SPIDemoService.class);
        for (SPIDemoService service : serviceLoader) {
            service.demo();
        }
    }
}
