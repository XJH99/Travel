package com.jxust.service.impl;

import com.jxust.dao.PermissionMapper;
import com.jxust.service.PermissionService;
import com.jxust.utils.CustomerException;
import com.jxust.vm.PermissionTree;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;

    /**
     * 查询权限树
     * @return
     * @throws CustomerException
     */
    @Override
    public List<PermissionTree> findPermissionTree() throws CustomerException {
        return permissionMapper.findPermissionTree();
    }
}
