package top.ljming.learning.sdk.callback;

import lombok.Data;

/**
 * 定义更新结果.
 *
 * @author ljming
 */
@Data
public class UpdateResult {
    private UpdateStatus status;
    private int updateCounts;
}

