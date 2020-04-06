package com.jxust.vm;

import java.io.Serializable;
import java.util.List;

/**
 * 用户角色
 */
public class UserRoleVM implements Serializable {

    private Integer userId;
    private List<Integer> roleIds;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<Integer> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Integer> roleIds) {
        this.roleIds = roleIds;
    }
}
