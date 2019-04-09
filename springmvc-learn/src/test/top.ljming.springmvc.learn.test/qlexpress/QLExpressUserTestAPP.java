package top.ljming.springmvc.learn.test.qlexpress;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import org.junit.Test;
import top.ljming.springmvc.learn.qlexpress.QLUser;

public class QLExpressUserTestAPP {

    private ExpressRunner runner = new ExpressRunner();
    private DefaultContext<String, Object> context = new DefaultContext<String, Object>();

    @Test
    public void test1() throws Exception {
        String express = "import top.ljming.springmvc.learn.qlexpress.QLUser;"
                + "QLUser user = new QLUser();"
                + "user.setId(1); user.setName(\"小明\");"
                + "return user.getName();";
        String r = (String) runner.execute(express, null, null, false, false);
        System.out.println(r);
    }

    @Test
    public void test2() throws Exception {
        String express = "首字母大写(\"abcd\")";
        runner.addFunctionOfClassMethod("首字母大写", QLUser.class.getName(), "firstToUpper", new String[]{"String"}, null);
        String r = (String) runner.execute(express, null, null, false, false);
        System.out.println(r);
    }

    @Test
    public void test3() throws Exception {
        String express = "user.setId(1); user.setName(\"小明\");"
                + "return user.getName();";
        context.put("user", new QLUser());
        String r = (String) runner.execute(express, context, null, false, false);
        System.out.println(r);
    }

    /**
     * 别名.
     *
     * @throws Exception Exception
     */
    @Test
    public void test4() throws Exception {
        String express = "user.setName(\"小明\");"
                + "定义别名 userName user.name;"
                + "return userName;";
        context.put("user", new QLUser());

        runner.addOperatorWithAlias("定义别名", "alias", null);
        String r = (String) runner.execute(express, context, null, false, false);
        System.out.println(r);
    }

    /**
     * 替换关键字.
     *
     * @throws Exception Exception
     */
    @Test
    public void test5() throws Exception {
        String express  = "user.setName(\"小明\");"
                + "定义宏 userName {user.name};"
                + "return userName;";
        context.put("user", new QLUser());
        runner.addOperatorWithAlias("定义宏", "macro", null);
        String r = (String) runner.execute(express, context, null, false, false);
        System.out.println(r);
    }

    @Test
    public void test6() {

    }
}
