package com.jxust.service;

import com.jxust.utils.CustomerException;
import com.jxust.vm.PermissionTree;

import java.util.List;

/**
 * 权限业务层接口
 */
public interface PermissionService {

    /**
     *  用权限树查询所有
     * @return
     * @throws CustomerException
     */
    List<PermissionTree> findPermissionTree() throws CustomerException;
}
