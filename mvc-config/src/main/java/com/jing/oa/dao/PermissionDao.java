package com.jing.oa.dao;

import com.jing.oa.model.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author GuoJingyuan
 * @date 2019/8/27
 */
public interface PermissionDao {

    List<Permission> getRolePermissions(@Param("roleId") String roleId);

    List<Permission> getUserPermissions(@Param("userId") String userId);

    int deleteByPrimaryKey(String id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}
