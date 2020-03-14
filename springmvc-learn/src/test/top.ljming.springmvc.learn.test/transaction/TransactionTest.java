package top.ljming.springmvc.learn.test.transaction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.ljming.springmvc.learn.entity.MainShiObj;
import top.ljming.springmvc.learn.transaction.ConsumerService;

import javax.annotation.Resource;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-server.xml"})
public class TransactionTest {

    @Resource
    private ConsumerService consumerService;

    @Test
    public void testRequired() {
//        consumerService.requiredHasTransactional(new MainShiObj(999, 999, 99));
//        consumerService.requiredNoTransactional(new MainShiObj(1000, 1000, 1000));

//        consumerService.supportHasTransaction(new MainShiObj(999, 999, 99));
//        consumerService.supportNoTransaction(new MainShiObj(1000, 1000, 1000));

//        consumerService.mandatoryHasTransaction(new MainShiObj(999, 999, 99));
//        consumerService.mandatoryNoTransaction(new MainShiObj(1000, 1000, 1000));

//        consumerService.requiredNewHasTransaction(new MainShiObj(999, 999, 99));
//        consumerService.requiredNewNoTransaction(new MainShiObj(1000, 1000, 1000));

//        consumerService.notSupportHasTransaction(new MainShiObj(999, 999, 99));
//        consumerService.notSupportNoTransaction(new MainShiObj(1000, 1000, 1000));

//        consumerService.neverHasTransaction(new MainShiObj(999, 999, 99));
//        consumerService.neverNoTransaction(new MainShiObj(1000, 1000, 1000));
        consumerService.nestedHasTransaction(new MainShiObj(1000, 1000, 1000));

    }
}
