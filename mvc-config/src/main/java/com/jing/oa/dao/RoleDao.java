package com.jing.oa.dao;

import com.jing.oa.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author GuoJingyuan
 * @date 2019/8/27
 */
public interface RoleDao {

    List<Role> getUserRoles(@Param("userId") String userId);

    int deleteByPrimaryKey(String id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}
