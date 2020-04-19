package top.ljming.learning.indepth.designpatterns.adapter;

/**
 * computer适配器类，实现computer类.
 *
 * @author lijm
 */
public class ComputerAdapter implements Computer {

    private Dominate dominate;

    @Override
    public void work() {
        dominate.cost();
        System.out.println("computer working");
    }
}
