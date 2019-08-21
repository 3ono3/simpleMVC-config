package com.jing.oa.dao;


import com.jing.oa.model.User;

/**
 * @author GuoJingyuan
 * @date 2019/8/12
 */
public interface UserDao {
    int insert(User record);

    int insertSelective(User record);
}