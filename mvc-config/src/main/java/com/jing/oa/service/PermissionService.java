package com.jing.oa.service;

import com.jing.oa.dao.PermissionDao;
import com.jing.oa.model.Permission;
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
public class PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    public List<Permission> getRolePermissions(Role role) {
        return permissionDao.getRolePermissions(role.getId());
    }

    public List<Permission> getUserPermissions(User user) {
        return permissionDao.getUserPermissions(user.getId());
    }

    public int deleteByPrimaryKey(String id) {
        return permissionDao.deleteByPrimaryKey(id);
    }

    public int insert(Permission record) {
        return permissionDao.insert(record);
    }

    public int insertSelective(Permission record) {
        return permissionDao.insertSelective(record);
    }

    public Permission selectByPrimaryKey(String id) {
        return permissionDao.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Permission record) {
        return permissionDao.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Permission record) {
        return permissionDao.updateByPrimaryKey(record);
    }
}
