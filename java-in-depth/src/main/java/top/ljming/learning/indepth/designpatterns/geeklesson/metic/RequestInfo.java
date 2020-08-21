package top.ljming.learning.indepth.designpatterns.geeklesson.metic;

import lombok.Data;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
@Data
public class RequestInfo {
    private String apiName;
    private double responseTime;
    private long timestamp;

    public RequestInfo(String apiName, double responseTime, long timestamp) {
        this.apiName = apiName;
        this.responseTime = responseTime;
        this.timestamp = timestamp;
    }
}
