package top.ljming.springmvc.learn.test.qlexpress;


import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import top.ljming.springmvc.learn.qlexpress.JoinOperator;
import top.ljming.springmvc.learn.qlexpress.QLUser;

public class QLExpressFunctionTestAPP {

    private ExpressRunner runner = new ExpressRunner();
    private DefaultContext<String, Object> context = new DefaultContext<String, Object>();

    /**
     * 定义函数.
     *
     * @throws Exception Exception
     */
    @Test
    public void functionTest() throws Exception {
        String express = "function add(int a, int b) {\n"
                + " return a + b;\n" +
                "};\n\n"
                + "function sub(int a, int b){\n"
                + " return a - b;\n"
                + "};\n\n"
                + "a=10;\n"
                + "return add(a, 4) + sub(a, 9);";
        Object r = runner.execute(express, context, null, true, false);
        System.out.println(r);
    }

    /**
     * 替换关键字.
     *
     * @throws Exception Exception
     */
    @Test
    public void replaceKeywordTest() throws Exception {
        runner.addOperatorWithAlias("如果", "if", null);
        runner.addOperatorWithAlias("则", "then", null);
        runner.addOperatorWithAlias("否则", "else", null);
        String express = "如果(1>2){return 10;}否则{return 5}";

        Object r = runner.execute(express, context, null, true, false);
        System.out.println(r);
    }

    /**
     * 添加操作.
     *
     * @throws Exception Exception
     */
    @Test
    public void addOperatorTest() throws Exception {
        runner.addOperator("join", new JoinOperator());
        Object r = runner.execute("1 join 2 join 3", context, null, false, false);
        System.out.println(r);
    }

    /**
     * 替换操作符.
     *
     * @throws Exception Exception
     */
    @Test
    public void replaceOperatorTest() throws Exception {
        runner.replaceOperator("+", new JoinOperator());
        Object r = runner.execute("1+2+3", context, null, false, false);
        System.out.println(r);
    }

    @Test
    public void addFunctionTest() throws Exception {
        runner.addFunction("join", new JoinOperator());
        Object r = runner.execute("join(1,2,3)", context, null, false, false);
        System.out.println(r);
    }

    @Test
    public void macroTest() throws Exception {
        runner.addMacro("计算平均成绩", "(语文+数学+英语)/3.0");
        runner.addMacro("是否优秀", "计算平均成绩>90");
        context.put("语文", 89);
        context.put("数学", 99);
        context.put("英语", 95);

        Boolean result = (Boolean) runner.execute("是否优秀", context, null, false, false);
        System.out.println(result);
    }

    @Test
    public void bindObjectMethodTest() throws Exception {
        runner.addFunctionOfClassMethod("取绝对值", Math.class.getName(), "abs", new String[]{"double"}, null);
        runner.addFunctionOfClassMethod("转换为大写", QLUser.class.getName(), "upper", new String[]{"String"}, null);
        runner.addFunctionOfClassMethod("是否为空", StringUtils.class.getName(), "isEmpty", new String[]{"String"}, null);
        runner.addFunctionOfServiceMethod("打印", System.out, "println", new String[]{"String"}, null);
        runner.addFunctionOfServiceMethod("任意包含", new QLUser(), "anyContains", new Class[]{String.class, String.class}, null);

        String express = "取绝对值(-10);转换为大写(\"hello world\");打印(\"cnm\");任意包含(\"hello world\", \"w\");是否为空(\"\")";
        Object r = runner.execute(express, context, null, false, false);
        System.out.println(r);

    }

    @Test
    public void testNull() throws Exception {
        String express = "() && 1=1";
        Object r = runner.execute(express, context, null, false, false);
        System.out.println(r);
    }

    @Test
    public void test() throws Exception {
        String express = "(\"\\u4E30\\u5DE2\\u6843\\u6E90\\u5C4593\\u53F7302\\u5BA4\\\\\".contains(\"\\u542F\\u822A\\u56FD\\u96453\\u671F\")";
        Object r = runner.execute(express, context, null, false, false);
        System.out.println(r);
    }

    @Test
    public void testError() throws Exception {
        String a = StringEscapeUtils.escapeJava("abc") ;
        String b = StringEscapeUtils.escapeJava("abc");

        String express = "\""+ a + "\"" +  ".contains(" + "\""+ b + "\")";
        System.out.println(express);
        Object r = runner.execute(express, context, null, false, false);
        System.out.println(r);

    }
}


