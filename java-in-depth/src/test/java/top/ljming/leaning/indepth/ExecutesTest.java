package top.ljming.leaning.indepth;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class ExecutesTest {

    int COUNT_BITS = Integer.SIZE - 3;  // 29
    int CAPACITY   = (1 << COUNT_BITS) - 1; // 2^29 - 1 = 536870911
    int RUNNING = -1 << COUNT_BITS; // -2^29 = -536870912

    @Test
    public void test() {
        System.out.println("RUNNING：" + RUNNING);
        int ctlof = ctlOf(RUNNING, 0);
        System.out.println("CTLOF：" + ctlof);
        AtomicInteger ctl = new AtomicInteger(ctlof);
        System.out.println("ctl:" + ctl.get());
        int wc = workerCountOf(ctl.get());
        System.out.println("wc: " + wc);

    }
    int ctlOf(int rs, int wc) {
        return rs | wc;
    }

    int workerCountOf(int c)  {
        System.out.println("capacity:" + CAPACITY);
        return c & CAPACITY;
    }

}
