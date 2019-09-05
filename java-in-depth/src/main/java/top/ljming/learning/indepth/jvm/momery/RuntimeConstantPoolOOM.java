package top.ljming.learning.indepth.jvm.momery;

import java.util.ArrayList;
import java.util.List;

/**
 * 运行时常量池内存溢出异常.
 *
 * vm args: -XX:PermSize=10m -XX:MaxPermSize=10  在jdk1.8已经被移除了
 *
 * @author lijm
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        int i = 0;
        while (true) {
            list.add(String.valueOf(i).intern());
        }
    }
}
