package com.jing.oa.dao;


import com.jing.oa.model.User;
import org.springframework.stereotype.Repository;

public interface UserDao {
    int insert(User record);

    int insertSelective(User record);
}