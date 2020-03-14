package top.ljming.dubboprovider.monitor;

import lombok.Data;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
@Data
public class MonitorRule {
    private Integer ruleId;
    private Integer intervalValue;
    private Integer intervalUnit;
}
