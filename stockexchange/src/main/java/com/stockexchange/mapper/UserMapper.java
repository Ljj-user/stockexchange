package com.stockexchange.mapper;

import com.stockexchange.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Package: com.stockexchange.mapper
 * ClassName: UserMapper
 * Description 用户数据操作
 *
 * @author
 * @Create 2023/11/17/ 20:44
 * @Version 1.0
 */
@Mapper
public interface UserMapper {
    // 根据用户名查询用户
    @Select("select * from user where userName = #{userName}")
    User findByUserName(String userName);

    // 向数据库添加用户
    // TODO 股票列表？？？
    @Insert("insert into user(userName, password, balance, cashBalance)" +
            " values(#{username}, #{password}, #{balance}, #{cashBalance}) ")
    void regedit(String userName, String password, double balance, double cashBalance);

    // 通过userId查询用户信息，返回一个User类型对象
    @Select("select * from user where userId = #{id}")
    User findUserId(Integer userId);

}
