package top.ljming.springmvc.learn.test.qlexpress;

import com.alibaba.fastjson.JSONObject;
import com.google.code.geocoder.Geocoder;
import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.security.InvalidKeyException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

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

    @Test
    public void test4() throws Exception {
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        String express = "!\"123\".equals(\"123\")";
        Object r = runner.execute(express, context, null, true, false);
        System.out.println(r);
    }

    @Test
    public void test5() throws Exception {
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        String express = "true";
        Object r = runner.execute(express, context, null, true, false);
        System.out.println(r);
    }

    @Test
    public void test6() throws Exception {
        String value = "aaa";

//        StringUtils.isEmpty(value);
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        runner.addFunctionOfClassMethod("是否为空", StringUtils.class.getName(), "isEmpty", new String[]{"String"}, null);
        String express = "!是否为空(\"" + value + "\")";
        System.out.println(express);
        Object r = runner.execute(express, context, null, true, false);
        System.out.println(r);

    }

    @Test
    public void test8() throws Exception {
        String express = "(\"alipay\".equals(\"alipay\") && \"wechat\".equals(\"wechat\") && (\"test@16311.com\".contains(\"163.com\") || \"170\".equals(\"170\") || \"170\".equals(\"171\")))";
        System.out.println(express);
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        Object r = runner.execute(express, context, null, true, false);
        System.out.println(r);

    }

    @Test
    public void test7() {
        Map<String, String> context = new HashMap<>();
        context.put("eventId", "1");
        context.put("ruleId", "2");
        context.put("ext_key_userId", "1234321");

        JSONObject message = JSONObject.parseObject(JSONObject.toJSONString(context));

        System.out.println(JSONObject.toJSONString(context));

        System.out.println(message.getInteger("eventId"));
        System.out.println(message.getString("ext_key_userId"));

    }

    @Test
    public void test9() throws Exception {
        String ql = "(\"河北省\".contains(\"河北\") && false)";
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        Object r = runner.execute(ql, context, null, true, false);
        System.out.println(r);
    }

}
