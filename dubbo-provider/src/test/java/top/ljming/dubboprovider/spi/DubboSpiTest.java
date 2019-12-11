package top.ljming.dubboprovider.spi;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 扩展点注解测试
     * @SPI注解，可以通过传入value参数，设置接口的默认实现类
     */
    @Test
    public void testSPI() {
        ExtensionLoader<Animal> extensionLoader = ExtensionLoader.getExtensionLoader(Animal.class);
        Animal animal = extensionLoader.getDefaultExtension();
        animal.talk(); // 这里应该是dog，因为Animal类的默认扩展实现类是Dog
    }

    /**
     * 扩展点自适应注册测试
     * @Adaptive注解可以标记在类、接口、枚举类和方法上。
     */
    @Test
    public void testAdaptive() {
        ExtensionLoader<Animal> extensionLoader = ExtensionLoader.getExtensionLoader(Animal.class);
        Animal animal = extensionLoader.getAdaptiveExtension();
        Map<String, String> keyPair = new HashMap<>();
        keyPair.put("name", "sheep");
        URL url = new URL("dobbo", "localhost", 1111, keyPair);
        animal.run(url, "dog");
    }

    /**
     * 扩展点自动激活注解测试
     */
    @Test
    public void testActivate() {
        ExtensionLoader<Animal> extensionLoader = ExtensionLoader.getExtensionLoader(Animal.class);
        Map<String, String> keyPair = new HashMap<>();
        keyPair.put("impl", "dog,sheep");
        keyPair.put("dog", "dog");
        URL url = new URL("dobbo", "localhost", 1111, keyPair);
        List<Animal> animalList = extensionLoader.getActivateExtension(url, "impl", "default");
        for (Animal animal : animalList) {
            animal.eat(url);
        }
    }
}
