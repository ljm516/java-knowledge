package top.ljming.learning.indepth.thread;

/**
 * 描述线程中断.
 *
 * @author lijm
 */
    public class ThreadInterrupt {

        public static void main(String[] args) throws InterruptedException {
            //testInterrupt();
            testSleepInterrupt();
        }

        public static void testSleepInterrupt() throws InterruptedException {
            Thread t = new Thread(() -> {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println(Thread.currentThread().getName() + " exit");
                        break;
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        // sleep被中断抛出异常，中断标志位被清除，所有线程不会退出
                        System.out.println("Interrupted when sleep");
                        // 要保证sleep被中断，线程退出，需要设置中断标志
                        Thread.currentThread().interrupt();
                    }
                    Thread.yield();
                }
            });
            t.start();
            Thread.sleep(2000);
            t.interrupt();
        }

        public static void testInterrupt() throws InterruptedException {
            Thread t = new Thread(() -> {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println(Thread.currentThread().getName() + " exit");
                        break;
                    }
                    Thread.yield();
                }
            });

            t.start();
            Thread.sleep(2000);
            t.interrupt(); // 执行interrupt方法，设置中断标志位
        }
    }
