package com.jing.oa.service;

import com.jing.oa.common.CustomerException;
import com.jing.oa.common.ResultCodeEnum;
import com.jing.oa.dao.UserDao;
import com.jing.oa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author GuoJingyuan
 * @date 2019/8/12
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public int insert(User user){
        return userDao.insert(user);
    }

    public User selectById(String id) {
        return userDao.selectByPrimaryKey(id);
    }

    public User loginVerify(String account, String password) throws CustomerException {
        User user = userDao.selectByAccountAndPassword(account, password);
        if (user == null) {
            throw new CustomerException(ResultCodeEnum.LOGIN_ERROR);
        }
        return user;
    }

}
