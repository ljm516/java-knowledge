package top.ljming.mybatisLearn;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import top.ljming.mybatisLearn.getstart.MybatisStartMapper;
import top.ljming.mybatisLearn.getstart.User;

import java.io.IOException;
import java.io.InputStream;

public class MybatisLearnApplication {

    private static SqlSessionFactory sqlSessionFactory = null;

    public static void main(String[] args) throws IOException {
        initMybatisConfig();
        myBatisStart();
    }

    /**
     * 读取 config 文件，创建 sqlSessionFactory
     * @throws IOException
     */
    synchronized static void initMybatisConfig() throws IOException {
        if (sqlSessionFactory == null) {
            String resource = "mybatis-config.xml";
            InputStream is = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        }
    }

    static void myBatisStart() {
        SqlSession session = sqlSessionFactory.openSession();
        session.commit(true);
        MybatisStartMapper startMapper = session.getMapper(MybatisStartMapper.class);
        User user = startMapper.selectUserById(11);
        System.out.println(user.toString());

//        User newUser = new User();
//        newUser.setAge(18);
//        newUser.setUsername("shaniu");
//        newUser.setCellPhone("15997411123");
//        newUser.setGender("nv");
//
//        startMapper.insertUser(user);
        session.close();
    }

}
