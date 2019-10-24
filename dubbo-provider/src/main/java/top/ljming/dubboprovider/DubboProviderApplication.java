package top.ljming.dubboprovider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"top.ljming.dubboprovider"})
@EnableDubbo(scanBasePackages = "top.ljming")
public class DubboProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboProviderApplication.class, args);
        System.out.println("start finished");
    }

}
