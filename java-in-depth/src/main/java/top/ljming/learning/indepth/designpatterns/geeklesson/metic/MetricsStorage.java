package top.ljming.learning.indepth.designpatterns.geeklesson.metic;

import java.util.List;
import java.util.Map;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public interface MetricsStorage {
    void saveRequestInfo(RequestInfo requestInfo);

    List<RequestInfo> getRequestInfos(String apiName, long startTimeMillis, long endTimeMillis);

    Map<String, List<RequestInfo>> getRequestInfos(long startTimeMillis, long endTimeMills);
}
