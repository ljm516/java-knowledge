package top.ljming.dubboprovider.spi;

import org.apache.dubbo.common.extension.SPI;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
@SPI
public interface Animal {
    void talk();
}
