package com.jxust.vm;

import com.jxust.bean.Permission;

import java.io.Serializable;
import java.util.List;

/**
 * 权限树
 */
public class PermissionTree extends Permission implements Serializable {

    private List<Permission> children;

    public List<Permission> getChildren() {
        return children;
    }

    public void setChildren(List<Permission> children) {
        this.children = children;
    }
}
