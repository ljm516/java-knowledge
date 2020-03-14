package top.ljming.springmvc.learn.transaction;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import top.ljming.springmvc.learn.dao.MainShiTestDao;
import top.ljming.springmvc.learn.entity.MainShiObj;

import javax.annotation.Resource;

/**
 * 事务传播方式.
 *
 * @author lijm
 */
@Component
public class ConsumerServiceImpl implements ConsumerService {

    @Resource
    private ProviderService providerService;

    @Resource
    private MainShiTestDao mainShiTestDao;

    /*
    1. Required: 支持当前事务，如果没有就新建
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void requiredHasTransactional(MainShiObj msObj) {
        // 这里有事务，那么被调用者就支持当前事务，这里抛出异常，事务将会回滚
        providerService.testRequiredNoException(msObj);
        throw new RuntimeException();
    }

    @Override
    public void requiredNoTransactional(MainShiObj msObj) {
        // 这里没有事务，那么被调用者就会新建事务，被调用这抛出异常，事务将会回滚
        providerService.testRequiredHasException(msObj);
    }

    /*
    2. Supports: 支持当前事务，如果没有就不以事务的方式运行
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void supportHasTransaction(MainShiObj msObj) {
        // 这里有事务，那么调用者就支持当前事务，这里抛异常，事务将会回滚
        providerService.testSupportNoException(msObj);
        throw new RuntimeException();
    }

    @Override
    public void supportNoTransaction(MainShiObj msObj) {
        // 这里没有事务，那么被调用者将不以事务方式进行，被调用者异常，与事务无关
        providerService.testSupportHasException(msObj);
    }

    /*
    3. Mandatory: 支持当前事务，如果当前没事务就抛异常
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void mandatoryHasTransaction(MainShiObj msObj) {
        // 这里有事务，那么调用者就支持当前事务，这里抛异常，事务将会回滚
        providerService.testMandatoryNoException(msObj);
        throw new RuntimeException();
    }

    @Override
    public void mandatoryNoTransaction(MainShiObj msObj) {
        // 这里没有事务，被调用者将会抛异常
        // org.springframework.transaction.IllegalTransactionStateException:
        // No existing transaction found for transaction marked with propagation 'mandatory'
        providerService.testMandatoryHasException(msObj);
    }

    /*
    4. Requires_new: 无论当前是否有事务，都会新起一个事务
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void requiredNewHasTransaction(MainShiObj msObj) {
        // 这里有事务，被调用者会新起一个事务，这里抛异常不影响被调用者的事务
        providerService.testRequiredNewNoException(msObj);
        throw new RuntimeException();
    }

    @Override
    public void requiredNewNoTransaction(MainShiObj msObj) {
        // 这里没有事务，被调用者新起一个事务，被调用者抛异常，被调用者的事务回滚
        providerService.testRequiredNewHasException(msObj);
    }

    /*
    5. Not_support: 不支持事务，如果当前存在事务，就将事务挂起不以事务的方式运行
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void notSupportHasTransaction(MainShiObj msObj) {
        // 这里有事务，但是事务传播方式为不支持，所以被调用者不以事务方式执行，这里抛异常对事务不影响
        providerService.testNotSupportNoException(msObj);
        throw new RuntimeException();
    }

    @Override
    public void notSupportNoTransaction(MainShiObj msObj) {
        // 这里没有事务，所以被调用者不以事务方式执行，被调用者抛异常对事务不影响
        providerService.testNotSupportHasException(msObj);
    }

    /*
    6. Never: 不支持事务，有事务就抛异常
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void neverHasTransaction(MainShiObj msObj) {
        // 这里有事务，被调用者会抛异常
        //org.springframework.transaction.IllegalTransactionStateException:
        // Existing transaction found for transaction marked with propagation 'never'
        providerService.testNeverNoException(msObj);
        throw new RuntimeException();
    }

    @Override
    public void neverNoTransaction(MainShiObj msObj) {
        // 这里没有异常，以非事务的方式执行
        providerService.testNeverHasException(msObj);
    }

    /*
    7. Nested: 如果当前存在事务，就在当前事务中再新起一个事务（内嵌）
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void nestedHasTransaction(MainShiObj msObj) {
        mainShiTestDao.insert(msObj);
        msObj.setA(1001);

        //1. 这里有事务，被调用者在当前事务内部新起一个事务，这里抛异常，会影响内层事务。
        //providerService.testNestedNoException(msObj);
//        throw new RuntimeException();

        // 2. 这里有事务，被调用者在当前事务内部新起一个事务。内层事务抛异常，不会影响外层事务
        providerService.testNestedHasException(msObj);
    }

}
