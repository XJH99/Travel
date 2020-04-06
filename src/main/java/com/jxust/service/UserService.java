package com.jxust.service;

import com.jxust.bean.User;
import com.jxust.utils.CustomerException;

import java.util.List;

/**
 * 用户业务层接口
 */
public interface UserService {
    /**
     * id来查询用户
     * @param id
     * @return
     */
    User findById(Integer id) throws CustomerException;

    /**
     * 查询所有的用户
     * @return
     */
    List<User> findAll() throws CustomerException;

    /**
     * 保存或更新用户
     * @param user
     * @throws CustomerException
     */
    void saveOrUpdate(User user) throws CustomerException;

    /**
     * 通过id删除
     * @param id
     * @throws CustomerException
     */
    void deleteById(Integer id) throws CustomerException;

    /**
     * 用户角色授权
     * @param userId
     * @param roleIds
     * @throws CustomerException
     */
    void setRoles(Integer userId,List<Integer> roleIds) throws CustomerException;
}
