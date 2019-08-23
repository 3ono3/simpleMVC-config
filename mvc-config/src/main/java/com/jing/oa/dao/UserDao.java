package com.jing.oa.dao;


import com.jing.oa.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author GuoJingyuan
 * @date 2019/8/12
 */
public interface UserDao {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByAccountAndPassword(@Param(value = "account") String account, @Param(value = "password") String password);
}