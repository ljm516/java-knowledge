package top.ljming.springmvc.learn.transaction;

import top.ljming.springmvc.learn.entity.MainShiObj;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public interface ConsumerService {

    void requiredHasTransactional(MainShiObj msObj);

    void requiredNoTransactional(MainShiObj msObj);

    void supportHasTransaction(MainShiObj msObj);

    void supportNoTransaction(MainShiObj msObj);

    void mandatoryHasTransaction(MainShiObj msObj);

    void mandatoryNoTransaction(MainShiObj msObj);

    void requiredNewHasTransaction(MainShiObj msObj);

    void requiredNewNoTransaction(MainShiObj msObj);

    void notSupportHasTransaction(MainShiObj msObj);

    void notSupportNoTransaction(MainShiObj msObj);

    void neverHasTransaction(MainShiObj msObj);

    void neverNoTransaction(MainShiObj msObj);

    void nestedHasTransaction(MainShiObj msObj);

}
