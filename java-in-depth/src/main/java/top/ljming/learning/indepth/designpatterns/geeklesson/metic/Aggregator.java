package top.ljming.learning.indepth.designpatterns.geeklesson.metic;

import java.util.List;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class Aggregator {

    public static RequestStat aggregate(List<RequestInfo> requestInfos, long durationInMillis) {
        double maxRespTime = Double.MIN_VALUE;
        double minRespTime = Double.MAX_VALUE;
        double aveRespTime = -1;
        double p999RespTime = -1;
        double p99RespTime = -1;
        double sumRespTime = 0;
        long count = 0;
        for (RequestInfo requestInfo : requestInfos) {
            ++count;
            double respTime = requestInfo.getResponseTime();
            if (maxRespTime < respTime) {
                maxRespTime = respTime;
            }
            if (minRespTime > respTime) {
                minRespTime = respTime;
            }
            sumRespTime += respTime;
        }
        if (count != 0) {
            aveRespTime = sumRespTime / count;
        }
        long tps = count / durationInMillis * 1000;
        requestInfos.sort((o1, o2) -> {
            double diff = o1.getResponseTime() - o2.getResponseTime();
            return Double.compare(diff, 0.0);

        });
        int idx999 = (int) (count * 0.9999);
        int idx99 = (int) (count * 0.99);
        if (count != 0) {
            p99RespTime = requestInfos.get(idx99).getResponseTime();
            p999RespTime = requestInfos.get(idx999).getResponseTime();
        }
        RequestStat requestStat = new RequestStat();
        requestStat.setMaxResponseTime(maxRespTime);
        requestStat.setMinResponseTime(minRespTime);
        requestStat.setAvgResponseTime(aveRespTime);
        requestStat.setP999ResponseTime(p999RespTime);
        requestStat.setP99ResponseTime(p99RespTime);
        requestStat.setCount(count);
        requestStat.setTps(tps);

        return requestStat;
    }
}
