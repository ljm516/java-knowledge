package top.ljming.springmvc.learn.test.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.ljming.springmvc.learn.dao.MainShiTestDao;
import top.ljming.springmvc.learn.entity.MainShiObj;

import javax.annotation.Resource;

/**
 * mybatis一级缓存和二级缓存.
 *
 * @author lijm
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-server.xml"})
public class MybatisCacheTest {
    @Resource
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void testFirstCache() {
        SqlSession session  = sqlSessionFactory.openSession();

        MainShiTestDao mstDao = session.getMapper(MainShiTestDao.class);
        // 第一次获取
        MainShiObj msObj = mstDao.selectOne(10);
        System.out.println(msObj);

        session.commit(); // 执行commit操作，清除一级缓存

        // 第二次获取
        MainShiObj msObj2 = mstDao.selectOne(10);
        System.out.println(msObj2);

        System.out.println(msObj == msObj2);

        session.close();
    }

    @Test
    public void testSecondCache() {
        // 第一次查询
        SqlSession session1  = sqlSessionFactory.openSession();
        MainShiTestDao mstDao1 = session1.getMapper(MainShiTestDao.class);
        MainShiObj msObj1 = mstDao1.selectById(10);
        System.out.println(msObj1);

        session1.commit(); // 执行commit操作，清除一级缓存
        session1.close();

        // 第二次查询
        SqlSession session2 = sqlSessionFactory.openSession();
        MainShiTestDao mstDao2 = session2.getMapper(MainShiTestDao.class);
        MainShiObj msObj2 = mstDao2.selectById(10);
        System.out.println(msObj2);
        session2.commit();
        session2.close();

        System.out.println(msObj1 == msObj2);
    }
}
