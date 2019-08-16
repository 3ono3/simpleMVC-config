package com.jing.oa.service;

import com.jing.oa.dao.UserDao;
import com.jing.oa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public int insert(User user) {
        return userDao.insert(user);
    }
}
