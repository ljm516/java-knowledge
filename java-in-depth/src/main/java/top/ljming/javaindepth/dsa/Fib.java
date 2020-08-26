package top.ljming.javaindepth.dsa;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class Fib {

    public static void main(String[] args) {
       // System.out.println(fib(5));
        //System.out.println(fib2(5));
        System.out.println(fib(5));
    }

    private static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int last1 = 1;
        int last2 = 1;
        int result = 0;
        for (int i =3; i <= n; i++) {
            result = last1 + last2;
            last2 = last1;
            last1 = result;
        }
        return result;
    }

    private static int fib2(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib2(n - 1) + fib2(n - 2);
    }

    public static int func (int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return func(n - 1) + func(n - 2);
    }

    public static int func2(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int last1 = 1;
        int last2 = 1;
        int result = 0;
        for (int i =3; i <= n; i++) {
            result = last1 + last2;
            last2 = last1;
            last1 = result;
        }
        return result;
    }

    public int[] printNumbers(int n) {
        if (n <= 0) {
            return null;
        }
        int len = (int) (Math.pow(10, n) - 1);
        int r[] = new int[len];
        while (len > 0) {
            r[len - 1] = len;
            len--;
        }
        return r;
    }

    public int minArray(int[] numbers) {
        if (null == numbers || numbers.length == 0) {
            return -1;
        }
        int targetIdx = 0;
        int len = numbers.length;
        for (int i = 0; i < len - 1; i++) {
            if (numbers[i] < numbers[i + 1]) {
                targetIdx = i + 1;
            }
        }

        return numbers[targetIdx];
    }

}

























