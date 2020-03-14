package top.ljming.springmvc.learn.dao;

import org.springframework.stereotype.Repository;
import top.ljming.springmvc.learn.entity.PhoneInfo;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
@Repository
public interface PhoneInfoDao {

    void insert(PhoneInfo phoneInfo);
}
