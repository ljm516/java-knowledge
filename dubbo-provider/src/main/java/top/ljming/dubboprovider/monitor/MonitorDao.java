package top.ljming.dubboprovider.monitor;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
@Repository
public interface MonitorDao {

    List<MonitorRule> queryall();

    MonitorRule getOne(int id);
}
