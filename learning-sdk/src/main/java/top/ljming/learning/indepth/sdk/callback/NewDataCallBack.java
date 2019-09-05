package top.ljming.learning.indepth.sdk.callback;

/**
 * 有新数据插入，进行回调.
 *
 * @author ljming.
 */
public interface NewDataCallBack {
    public void doCallBack(UpdateResult result);
    public void doException(Exception e);
}
