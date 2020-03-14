package top.ljming.springmvc.learn.transaction;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.ljming.springmvc.learn.dao.MainShiTestDao;
import top.ljming.springmvc.learn.entity.MainShiObj;

import javax.annotation.Resource;

/**
 * Required: 支持当前事务，如果没有就新建事务.
 *
 * @author lijm
 */
@Component
public class ProviderServiceImpl implements ProviderService {

    @Resource
    private MainShiTestDao mainShiTestDao;


    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void testRequiredHasException(MainShiObj msObj) {
        mainShiTestDao.insert(msObj);
        throw new RuntimeException();
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void testRequiredNoException(MainShiObj msObj) {
        mainShiTestDao.insert(msObj);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS)
    public void testSupportHasException(MainShiObj msObj) {
        mainShiTestDao.insert(msObj);
        throw new RuntimeException();
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS)
    public void testSupportNoException(MainShiObj msObj) {
        mainShiTestDao.insert(msObj);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
    public void testMandatoryHasException(MainShiObj msObj) {
        mainShiTestDao.insert(msObj);
        throw new RuntimeException();
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
    public void testMandatoryNoException(MainShiObj msObj) {
        mainShiTestDao.insert(msObj);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void testRequiredNewHasException(MainShiObj msObj) {
        mainShiTestDao.insert(msObj);
        throw new RuntimeException();
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void testRequiredNewNoException(MainShiObj msObj) {
        mainShiTestDao.insert(msObj);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NOT_SUPPORTED)
    public void testNotSupportHasException(MainShiObj msObj) {
        mainShiTestDao.insert(msObj);
        throw new RuntimeException();
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NOT_SUPPORTED)
    public void testNotSupportNoException(MainShiObj msObj) {
        mainShiTestDao.insert(msObj);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NEVER)
    public void testNeverHasException(MainShiObj msObj) {
        mainShiTestDao.insert(msObj);
        throw new RuntimeException();
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NEVER)
    public void testNeverNoException(MainShiObj msObj) {
        mainShiTestDao.insert(msObj);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NESTED)
    public void testNestedHasException(MainShiObj msObj) {
        mainShiTestDao.insert(msObj);
        throw new RuntimeException();
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NESTED)
    public void testNestedNoException(MainShiObj msObj) {
        mainShiTestDao.insert(msObj);
    }
}
