package com.jxust.dao;

import com.jxust.bean.User;
import com.jxust.utils.CustomerException;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户mapper接口
 */
@Mapper
public interface UserMapper {
    /**
     * 通过id来查询用户
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
     * 添加新的用户
     * @param user
     * @throws CustomerException
     */
    void save(User user) throws CustomerException;

    /**
     * 更新用户
     * @param user
     * @throws CustomerException
     */
    void update(User user) throws CustomerException;

    /**
     * 用户名来查询用户
     * @param username
     * @return
     * @throws CustomerException
     */
    User findByUsername(String username) throws CustomerException;

    /**
     * 通过id删除
     * @param id
     * @throws CustomerException
     */
    void deleteById(Integer id) throws CustomerException;




}
