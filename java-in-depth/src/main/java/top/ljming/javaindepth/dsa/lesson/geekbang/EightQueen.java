package top.ljming.javaindepth.dsa.lesson.geekbang;

/**
 * 八皇后问题.
 * <p>
 * 我们有一个 8x8 的棋盘，希望往里放 8 个棋子（皇后），每个棋子所在的行、列、对角线都不能有另一个棋子。
 *
 * @author lijm
 */
public class EightQueen {

    int result[] = new int[8];

    public void solution() {
        cal(0);

    }

    private void cal(int row) {
        if (row == 8) {
            print();
            return;
        }
        for (int col = 0; col < 8; ++col) {
            if (isOk(row, col)) {
                result[row] = col;
                cal(row + 1);
            }
        }
    }

    private boolean isOk(int row, int column) {
        int leftup = column - 1;
        int rightup = column + 1;
        for (int i = row - 1; i >= 0; --i) {
            if (result[i] == column) {
                return false;
            }
            if (leftup >= 0) {
                if (result[i] == leftup) {
                    return false;
                }
            }
            if (rightup < 8) {
                if (result[i] == rightup) {
                    return false;
                }
            }
            --leftup;
            ++rightup;
        }
        return true;
    }

    private void print() {
        for (int row = 0; row < 8; ++row) {
            for (int col = 0; col < 8; ++col) {
                if (result[row] == col) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        EightQueen eightQueen = new EightQueen();
        eightQueen.solution();
    }
}
