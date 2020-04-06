package com.jxust.dao;

import com.jxust.bean.Permission;
import com.jxust.utils.CustomerException;
import com.jxust.vm.PermissionTree;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 权限mapper接口
 */
@Mapper
public interface PermissionMapper {
    /**
     * 通过角色id来查询权限信息
     * @param roleId
     * @return
     * @throws CustomerException
     */
    List<Permission> findByRoleId(Integer roleId) throws CustomerException;


    /**
     *  用权限树查询所有
     * @return
     * @throws CustomerException
     */
    List<PermissionTree> findPermissionTree() throws CustomerException;

    /**
     * 用父权限id查对应的子权限
     * @param id
     * @return
     * @throws CustomerException
     */
    List<Permission> findByParentId(Integer id) throws CustomerException;
}
