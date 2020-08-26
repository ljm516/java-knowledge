package top.ljming.javaindepth.designpatterns.geeklesson.metic;

import java.util.List;
import java.util.Map;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class RedisMetricsStorage implements MetricsStorage{
    @Override
    public void saveRequestInfo(RequestInfo requestInfo) {

    }

    @Override
    public List<RequestInfo> getRequestInfos(String apiName, long startTimeMillis, long endTimeMillis) {
        return null;
    }

    @Override
    public Map<String, List<RequestInfo>> getRequestInfos(long startTimeMillis, long endTimeMills) {
        return null;
    }
}
