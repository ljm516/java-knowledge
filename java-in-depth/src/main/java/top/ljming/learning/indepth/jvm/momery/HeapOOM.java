package top.ljming.learning.indepth.jvm.momery;

import java.util.ArrayList;
import java.util.List;

/**
 * java堆内存溢出测试.
 * VM args: -Xms20m -Mmx20m -XX:+HeapDumpOnOutOfMemoryError
 *
 * @author lijm
 */
public class HeapOOM {

    private static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> oomObjectList = new ArrayList<OOMObject>();
        while (true) {
            oomObjectList.add(new OOMObject());
        }
    }
}
