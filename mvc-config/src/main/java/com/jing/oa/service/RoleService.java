package com.jing.oa.service;

import com.jing.oa.dao.RoleDao;
import com.jing.oa.model.Role;
import com.jing.oa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GuoJingyuan
 * @date 2019/8/27
 */
@Service
public class RoleService {
    @Autowired
    private RoleDao roleDao;

    public List<Role> getUserRoles(User user) {
        return roleDao.getUserRoles(user.getId());
    }

    public int deleteByPrimaryKey(String id){
        return roleDao.deleteByPrimaryKey(id);
    }

    public int insert(Role record){
        return roleDao.insert(record);
    }

    public int insertSelective(Role record) {
        return roleDao.insertSelective(record);
    }

    public Role selectByPrimaryKey(String id) {
        return roleDao.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Role record) {
        return roleDao.updateByPrimaryKey(record);
    }

    public int updateByPrimaryKey(Role record) {
        return roleDao.updateByPrimaryKeySelective(record);
    }
}
