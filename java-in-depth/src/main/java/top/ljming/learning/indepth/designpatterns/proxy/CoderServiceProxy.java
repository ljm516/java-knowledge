package top.ljming.learning.indepth.designpatterns.proxy;

/**
 * 代理类.
 *
 * @author lijm
 */
public class CoderServiceProxy implements ICoderService{

    private ICoderService coderService;

    public CoderServiceProxy(ICoderService coderService) {
        this.coderService = coderService;
    }

    @Override
    public void writerCode() {
        System.out.println("写代码之前先设计");
        coderService.writerCode();
        System.out.println("写完再自测");
    }
}
