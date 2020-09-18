package top.ljming.javaindepth.designpatterns.action.po;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
@Data
public class Counter {
    private Long id;
    private String counterName;
    private JSONObject configJson;
    private Integer counterType;
}
