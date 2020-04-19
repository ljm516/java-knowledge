package top.ljming.learning.indepth.designpatterns.proxy;

/**
 * 实现类，被代理的类.
 *
 * @author lijm
 */
public class CoderServiceImpl implements ICoderService {
    @Override
    public void writerCode() {
        System.out.println("======本人要写好多代码======");
    }
}
