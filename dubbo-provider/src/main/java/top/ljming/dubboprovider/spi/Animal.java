package top.ljming.dubboprovider.spi;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

/**
 * 描述类的功能.
 * SPI注解，有一个value属性，通过传入这个值，设置该接口的默认实现类。
 *
 * @author lijm
 */
@SPI(value = "dog")
public interface Animal {
    void talk();

    /**
     * 如果Adaptive注解中没有key参数，
     * 则默认会把类名转换成key，Animal类就会转化成animal。
     * 如果url参数中没有animal这个参数，则会取默认值，也就是spi的默认实现。
     */
    @Adaptive(value = {"name"})
    void run(URL url, String s);

    /**
     * 可以标记在类，接口，枚举类和方法上。主要使用在有多个扩展点实现、需要根据不同条件被激活的场景中。
     * @param url url
     */
    @Activate(group = "default", value = {"dog", "sheep"})
    void eat(URL url);
}
