package top.ljming.javaindepth.jvm.momery;

/**
 * 测试java虚拟机栈出现StackOverflowError.
 *
 * vm args: -Xss128k
 *
 * @author lijm
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength ++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF sof = new JavaVMStackSOF();
        try {
            sof.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length: " + sof.stackLength);
            throw e;
        }
    }
}
