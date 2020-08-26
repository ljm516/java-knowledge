package top.ljming.javaindepth.dsa.ms;

/**
 * 百元买百鸡为题，公鸡5元一只，母鸡3元一只，小鸡1元3只。要买100只鸡，可行的方案.
 *
 * @author ljming
 */
public class BuyChickens {

    int cockNum = 0;
    int henNum = 0;
    int chickNum = 0;

    int totalNum = 100;
    int money = 100;

    private void buy() {
        if (totalNum <= 0 || money <= 0) {
            System.out.println("公鸡: " + cockNum + ";母鸡: " + henNum + "; 小鸡: " + chickNum);
            return;
        }
        // 买小鸡
        if (totalNum >= 3) {
            chickNum += 3;
            money -= 1;
            totalNum -= 3;
            buy();
        }
        // 买母鸡
        if (money >= 3 && totalNum >= 1) {
            henNum += 1;
            money -= 3;
            totalNum -= 1;
            buy();
        }
        // 买公鸡
        if (money >= 5 && totalNum >= 1) {
            cockNum += 1;
            money -= 5;
            totalNum -= 1;
            buy();
        }

    }

    public static void main(String[] args) {
        BuyChickens buyChickens = new BuyChickens();
        buyChickens.buy();
    }

}
