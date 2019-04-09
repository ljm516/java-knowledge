package top.ljming.springmvc.learn.test.qlexpress;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import org.junit.Test;

public class QLExpressBaseTestAPP {

    private ExpressRunner runner = new ExpressRunner();

    /**
     * 算术运算.
     *
     * @throws Exception Exception
     */
    @Test
    public void test1() throws Exception {
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();

        context.put("a", 1);
        context.put("b", 2);
        context.put("c", 3);

        String express = "a+b*c";
        Object r = runner.execute(express, context, null, true, true);
        System.out.println(r);
    }

    /**
     * 测试循环.
     *
     * @throws Exception Exception
     */
    @Test
    public void test2() throws Exception {
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        String express = "int n=10;int sum=0;int i=0;for(i=0;i<n;i++){sum=sum+i;}return sum";
        Object r = runner.execute(express, context, null, true, true);
        System.out.println(r);
    }

    /**
     * 三目运算.
     *
     * @throws Exception Exception
     */
    @Test
    public void test3() throws Exception {
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        String express = "a=1;b=2;bigger=a>b?a:b;";
        Object r = runner.execute(express, context, null, true, false);
        System.out.println(r);
    }
}
