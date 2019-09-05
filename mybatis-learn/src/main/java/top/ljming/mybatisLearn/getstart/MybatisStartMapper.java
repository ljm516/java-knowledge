package top.ljming.mybatisLearn.getstart;

import org.apache.ibatis.annotations.Select;

public interface MybatisStartMapper {
    @Select("select * from user where id = #{id}")
    User selectUserById(int id);

    User insertUser(User user);
}
