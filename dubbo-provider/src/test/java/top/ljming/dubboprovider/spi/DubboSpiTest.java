package top.ljming.dubboprovider.spi;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class DubboSpiTest {

    @Test
    public void test() {
        ExtensionLoader<Animal> extensionLoader = ExtensionLoader.getExtensionLoader(Animal.class);
        Animal dog = extensionLoader.getExtension("dog");
        dog.talk();

        Animal sheep = extensionLoader.getExtension("sheep");
        sheep.talk();
    }
}
