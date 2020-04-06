package com.jxust.service;

import com.jxust.bean.Role;
import com.jxust.utils.CustomerException;

import java.util.List;

/**
 * 角色业务层接口
 */
public interface RoleService {

    /**
     * 查询所有的角色
     * @return
     * @throws CustomerException
     */
    List<Role> findAll() throws CustomerException;

    /**
     * 保存或更新角色
     * @param role
     * @throws CustomerException
     */
    void saveOrUpdate(Role role) throws CustomerException;

    /**
     * 通过id来删除
     * @param id
     * @throws CustomerException
     */
    void deleteById(Integer id) throws CustomerException;

    /**
     * 给角色授权
     * @param roleId
     * @param permissionIds
     * @throws CustomerException
     */
    void authorization(Integer roleId,List<Integer> permissionIds) throws CustomerException;
}
