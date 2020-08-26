package top.ljming.leaning.indepth.spi;

import org.junit.Test;
import top.ljming.javaindepth.spi.SPIDemoService;

import java.util.ServiceLoader;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class SpiTest {

    @Test
    public void test() {
        ServiceLoader<SPIDemoService> serviceLoader = ServiceLoader.load(SPIDemoService.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(SPIDemoService::demo);
    }
}
