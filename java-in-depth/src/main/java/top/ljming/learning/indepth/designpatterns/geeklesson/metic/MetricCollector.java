package top.ljming.learning.indepth.designpatterns.geeklesson.metic;

import org.springframework.util.StringUtils;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class MetricCollector {

    private MetricsStorage metricsStorage;

    public MetricCollector(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
    }

    public void recordRequest(RequestInfo requestInfo) {
        if (null == requestInfo || StringUtils.isEmpty(requestInfo.getApiName())) {
            return;
        }
        metricsStorage.saveRequestInfo(requestInfo);
    }
}
