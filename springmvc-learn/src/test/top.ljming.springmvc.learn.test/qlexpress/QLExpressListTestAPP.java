package top.ljming.springmvc.learn.test.qlexpress;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import org.junit.Test;

public class QLExpressListTestAPP {

    private ExpressRunner runner = new ExpressRunner();
    private DefaultContext<String, Object> context = new DefaultContext<String, Object>();

    /**
     * 集合操作.
     *
     * @throws Exception Exception
     */
    @Test
    public void shorthandTest() throws Exception {
        String express = "map=NewMap(1:1, 2:2); return map.get(1) + map.get(2)";
        Object r = runner.execute(express, context, null, false, false);
        System.out.println(r);

        express = "list=NewList(1,2,3); return list.get(1) + list.get(2);";
        r = runner.execute(express, context, null, false, false);
        System.out.println(r);

        express = "arr=[1,2,3];return arr[1] + arr[2];";
        r = runner.execute(express, context, null, false, false);
        System.out.println(r);
    }

    @Test
    public void foreachTest() throws Exception {
        String express = "Map map = new HashMap();\n"
                + "map.put(\"a\", \"a_value\");\n"
                + "map.put(\"b\", \"b_value\");\n"
                + "keySet=map.keySet();\n"
                + "objArr=keySet.toArray();\n"
                + "for (i=0;i<objArr.length;i++){\n"
                + "key=objArr[i];\n"
                + "System.out.print(map.get(key));\n"
                + "}";
        Object r = runner.execute(express, context, null, false, false);
        System.out.println(r);
    }
}
