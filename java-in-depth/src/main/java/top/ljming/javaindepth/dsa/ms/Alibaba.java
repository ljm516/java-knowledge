package top.ljming.javaindepth.dsa.ms;

import top.ljming.javaindepth.dsa.domain.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 阿里机试题.
 *
 * @author ljming
 */
public class Alibaba {

    int count = 0;
    ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Tree six = new Tree(null, null, 6);
        Tree five = new Tree(six, null, 5);
        Tree three = new Tree(null, five, 3);
        Tree four = new Tree(null, null, 4);
        Tree two = new Tree(null, four, 2);
        Tree root = new Tree(two, three, 1);

        Alibaba alibaba = new Alibaba();
        alibaba.leftestNode(root);

        int[] arr = {5, 3, 8, 18, 11, 12, 15};
        System.out.println(alibaba.maxBenifit(arr));

        alibaba.printABC();
    }

    /**
     * 1、一个二叉树，打印从左边能看到的第一个节点。
     * 输入： 树的根节点
     * 1
     * / \
     * 2     3
     * \     \
     * 4     5
     * /
     * 6
     * 输出： 1、2、4、6
     */
    public void leftestNode(Tree root) {
        if (null == root) {
            return;
        }
        Queue<Tree> q1 = new LinkedList<>();
        Queue<Tree> q2 = new LinkedList<>();
        Map<Tree, Boolean> leftMap = new HashMap<>(16);
        q1.offer(root);
        leftMap.put(root, true);

        while (!q1.isEmpty() || !q2.isEmpty()) {
            while (!q1.isEmpty()) {
                Tree r = q1.poll();
                if (leftMap.get(r)) {
                    System.out.println(r.value);
                }
                if (r.left != null) {
                    boolean isLeftNode = q2.isEmpty() ? true : false;
                    q2.offer(r.left);
                    leftMap.put(r.left, isLeftNode);
                }
                if (r.right != null) {
                    boolean isLeftNode = q2.isEmpty() ? true : false;
                    q2.offer(r.right);
                    leftMap.put(r.right, isLeftNode);
                }
            }
            while (!q2.isEmpty()) {
                Tree r = q2.poll();
                if (leftMap.get(r)) {
                    System.out.println(r.value);
                }
                if (r.left != null) {
                    boolean isLeftNode = q1.isEmpty() ? true : false;
                    q1.offer(r.left);
                    leftMap.put(r.left, isLeftNode);
                }
                if (r.right != null) {
                    boolean isLeftNode = q1.isEmpty() ? true : false;
                    q1.offer(r.right);
                    leftMap.put(r.right, isLeftNode);
                }
            }
        }
    }

    /**
     * 股民小陈在炒股，假定证券交易机构规定一天每人最多可以买入和卖出各2次，且必须按照“先买入——再卖出——再买入——再卖出”的顺序操作。
     * 现已知一只股票股价的变化曲线，写一个程序计算股民一天最大的收益。
     * 测试举例：
     * 输入：股价数组 {5, 3, 8, 18, 11, 12, 15}，数组总长度不超过100
     * 返回：收益最大值 19
     */
    public int maxBenifit(int[] arr) {
        int idx = 0;
        int maxBenifit = 0;
        int temBenifit = 0;
        int nextStartIdx = 0;
        for (; idx < arr.length - 1; idx++) {
            // arr[idx + 1] - arr[idx] 有可能为负数，递推公式: max = Math.max(arr[idx + 1] - arr[idx]) + (arr[idx] - arr[idx - 1], 0)
            temBenifit = Math.max(temBenifit + arr[idx + 1] - arr[idx], 0);
            if (temBenifit >= maxBenifit) {
                maxBenifit = temBenifit;
                nextStartIdx = idx + 1;
            }

        }
        if (nextStartIdx == arr.length - 1) {
            return maxBenifit;
        }
        int secondMaxBenifit = 0;
        temBenifit = 0;
        for (; nextStartIdx < arr.length - 1; nextStartIdx++) {
            // arr[idx + 1] - arr[idx] 有可能为负数，递推公式: max = Math.max(arr[idx + 1] - arr[idx]) + (arr[idx] - arr[idx - 1], 0)
            temBenifit = Math.max(temBenifit + arr[nextStartIdx + 1] - arr[nextStartIdx], 0);
            secondMaxBenifit = Math.max(temBenifit, secondMaxBenifit);
        }
        if (secondMaxBenifit > 0) {
            maxBenifit += secondMaxBenifit;
        }
        return maxBenifit;
    }

    /**
     * 三个线程交替打印a、b、c ,输出 abcabcabc
     */
    public void printABC() {

        Thread printA = new Thread(() -> {
            try {
                lock.lock();
                while (count % 3 == 0) {
                    System.out.println("a");
                    count++;
                }
            } catch (Exception e) {
                //
            } finally {
                lock.unlock();
            }
        });
        Thread printB = new Thread(() -> {
            try {
                lock.lock();
                while (count % 3 == 1) {
                    System.out.println("b");
                    count++;
                }
            } catch (Exception e) {
                //
            } finally {
                lock.unlock();
            }
        });
        Thread printC = new Thread(() -> {
            try {
                lock.lock();
                while (count % 3 == 2) {
                    System.out.println("c");
                    count++;
                }
            } catch (Exception e) {
                //
            } finally {
                lock.unlock();
            }
        });

        printA.start();
        printB.start();
        printC.start();

        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            System.out.println("异常退出");
        }
    }


}
