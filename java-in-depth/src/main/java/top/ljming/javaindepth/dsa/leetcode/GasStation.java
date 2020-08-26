package top.ljming.javaindepth.dsa.leetcode;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total = 0;
        int curr = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            total += gas[i] - cost[i];
            curr += gas[i] - cost[i];

            if (curr < 0) {
                start = i + 1;
                curr = 0;
            }
        }

        return total >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        GasStation gs = new GasStation();
        System.out.println(gs.canCompleteCircuit(gas, cost));
    }
}
