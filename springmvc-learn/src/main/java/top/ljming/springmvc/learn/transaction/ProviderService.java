package top.ljming.springmvc.learn.transaction;

import top.ljming.springmvc.learn.entity.MainShiObj;

/**
 * 事务传播方式.
 *
 * @author lijm
 */
public interface ProviderService {

    void testRequiredHasException(MainShiObj msObj);

    void testRequiredNoException(MainShiObj msObj);

    void testSupportHasException(MainShiObj msObj);

    void testSupportNoException(MainShiObj msObj);

    void testMandatoryHasException(MainShiObj msObj);

    void testMandatoryNoException(MainShiObj msObj);

    void testRequiredNewHasException(MainShiObj msObj);

    void testRequiredNewNoException(MainShiObj msObj);

    void testNotSupportHasException(MainShiObj msObj);

    void testNotSupportNoException(MainShiObj msObj);

    void testNeverHasException(MainShiObj msObj);

    void testNeverNoException(MainShiObj msObj);

    void testNestedHasException(MainShiObj msObj);

    void testNestedNoException(MainShiObj msObj);

}
