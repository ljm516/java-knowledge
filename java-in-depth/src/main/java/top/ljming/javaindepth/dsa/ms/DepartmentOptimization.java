package top.ljming.javaindepth.dsa.ms;

/**
 * 部门优化.【智线】
 * 某公司内有 4 个项⽬目组，项⽬目组 A、B、C、D，项⽬目组A现有10⼈人，项⽬目组B现有7⼈人，项⽬目组C现 有5⼈人，项⽬目组D现有4⼈人。
 * 为了了实现跨项⽬目组协作，公司决定每⽉月从⼈人数最多的项⽬目组中抽调 3 ⼈人 出来，到其他剩下 3 组中，每组 1 ⼈人，
 * 这称之为⼀一次调整优化(亦即经过第⼀一次调整后，A组有7 ⼈人，B组有8⼈人，C组有6⼈人，D组有5⼈人)。
 * 那么请问，经过⼗十年年的优化调整后，各项⽬目组各有⼏几⼈人?
 *
 * @author lijm
 */
public class DepartmentOptimization {
    public static void main(String[] args) {
        int department[] = new int[]{10, 7, 5, 4};
        department = optimization(department, 120);
        for (int n: department) {
            System.out.println(n);
        }
    }

    private static int[] optimization(int[] department, int times) {
        if (null == department || department.length == 0 || times == 0) {
            return department;
        }
        int max;
        int maxIdx;
        times = times % 4 == 0 ? 4 : times % 4;
        while (times > 0) {
            maxIdx = -1;
            max = 0;
            for (int i = 0; i < department.length; i++) {
                if (max < department[i]) {
                    max = department[i];
                    maxIdx = i;
                }
            }
            department[maxIdx] = department[maxIdx] - 3;
            for (int j = 0; j < department.length; j++) {
                if (j != maxIdx) {
                    department[j] += 1;
                }
                System.out.print(department[j] + ",");
            }
            System.out.println();
            times--;
        }
        return department;
    }
}
