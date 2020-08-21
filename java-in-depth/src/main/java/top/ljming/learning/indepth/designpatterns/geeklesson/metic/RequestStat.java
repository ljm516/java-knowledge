package top.ljming.learning.indepth.designpatterns.geeklesson.metic;

import lombok.Data;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
@Data
public class RequestStat {

    private double maxResponseTime;
    private double minResponseTime;
    private double avgResponseTime;
    private double p999ResponseTime;
    private double p99ResponseTime;
    private long count;
    private long tps;
}
