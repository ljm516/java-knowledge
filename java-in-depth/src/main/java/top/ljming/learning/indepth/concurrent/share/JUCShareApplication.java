package top.ljming.learning.indepth.concurrent.share;

import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import sun.net.www.protocol.file.FileURLConnection;
import top.ljming.learning.indepth.dsa.domain.Tree;
import top.ljming.learning.indepth.dsa.leetcode.S;
import top.ljming.learning.indepth.thread.ThreadPool;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Function;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class JUCShareApplication {

    public void sampleOfExecutors() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 60,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(1024), new ThreadPoolExecutor.CallerRunsPolicy());

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        System.out.println("c: " + System.currentTimeMillis() + "\n");
        executor.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("s: " + System.currentTimeMillis());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("e: " + System.currentTimeMillis() + "\n");
            }
        }, 1000, 2000, TimeUnit.MILLISECONDS);
    }

    public void sampleOfCountDownLatch() {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        System.out.println("s: " + System.currentTimeMillis());
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println("current: " + Thread.currentThread().getName() + " e: " + System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("over: " + System.currentTimeMillis());
    }

    public void sampleOfSemaphore() {
        Semaphore semaphore = new Semaphore(5);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    Thread.sleep(2000);
                    System.out.println("current: " + Thread.currentThread().getName() + ", e:" + System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            });
        }
    }

    public void sampleOfCyclicBarrier() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, () -> System.out.println("完成一次计数"));
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                try {
                    cyclicBarrier.await();
                    System.out.println("current: " + Thread.currentThread().getName() + " e:" + System.currentTimeMillis());
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public void sampleOfExecute() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                        System.out.println("current: " + Thread.currentThread().getName() + " e: " + System.currentTimeMillis());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        System.out.println("main over, e: " + System.currentTimeMillis());
    }

    public void sampleOfSubmit() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Future<?> withoutResultFuture = executorService.submit(() -> System.out.println("this is Runnable task without result"));

        List<Future<String>> specifiedFutureList = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            Future<String> withSpecifiedResultFuture = executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("this is Runnable task with specified result");
                }
            }, "hello world");
            specifiedFutureList.add(withSpecifiedResultFuture);
        }

        List<Future<Integer>> futureList = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            int r = i;
            Future<Integer> future = executorService.submit(() -> {
                System.out.println("this is Callable task");
                return r;
            });
            futureList.add(future);
        }
        System.out.println("-----------------取结果-----------------");
        try {
            System.out.println("without Result: " + withoutResultFuture.get());
            for (Future<String> future : specifiedFutureList) {
                System.out.println("specified Result: " + future.get());
            }
            for (Future<Integer> future: futureList) {
                System.out.println("with Result: " + future.get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public void sampleOfFutureException () {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<Integer> future = executorService.submit(() -> {
            System.out.println("this is Callable task");
            throw new RuntimeException();
        });
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public void sampleOfInvokeAll() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Callable<Integer>> taskList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int r = i;
            taskList.add(() -> {
                if (r % 2 == 0) {
                    Thread.sleep(3000);
                }
                System.out.println("current: " + Thread.currentThread().getName());
                return r;
            });
        }
        try {
            List<Future<Integer>> futureList = executorService.invokeAll(taskList, 2000, TimeUnit.MILLISECONDS);
            for (Future<Integer> future : futureList) {
                System.out.println("invoke all r: " + future.get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public void sampleOfInvokeAny() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Callable<Integer>> taskList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int r = i;
            taskList.add(() -> {
                if (r % 2 == 0) {
                    Thread.sleep(3000);
                }
                System.out.println("current: " + Thread.currentThread().getName());
                return r;
            });
        }
        try {
            Integer r = executorService.invokeAny(taskList, 2000, TimeUnit.MILLISECONDS);
            System.out.println("invoke any r: " + r);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JUCShareApplication share = new JUCShareApplication();
        share.sampleOfInvokeAny();
    }
}
