package top.ljming.javaindepth.nio;

import java.nio.ByteBuffer;

/**
 * nio的理解.
 *
 * @author lijm
 */
public class NIOApplication {

    private ByteBuffer byteBuffer;


    public static void main(String[] args) {
        System.out.println(100 + 1024 - 100 % 1024);
    }
}
