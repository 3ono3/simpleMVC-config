package com.jing.oa.model;

import java.io.Serializable;

/**
 * 角色类
 * @author GuoJingyuan
 * @date 2019/8/27
 */
public class Role implements Serializable {
    private String id;

    private String roleName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }
}
