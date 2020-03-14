package top.ljming.springmvc.learn.dao;

import org.springframework.stereotype.Repository;
import top.ljming.springmvc.learn.entity.MainShiObj;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
@Repository
public interface MainShiTestDao {

    void insert(MainShiObj obj);
}
