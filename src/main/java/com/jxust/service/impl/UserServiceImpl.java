package com.jxust.service.impl;

import com.jxust.bean.Role;
import com.jxust.bean.User;
import com.jxust.dao.UserMapper;
import com.jxust.dao.UserRoleMapper;
import com.jxust.service.UserService;
import com.jxust.utils.CustomerException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户业务实现类
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRoleMapper userRoleMapper;

    /**
     * id来查询用户
     * @param id
     * @return
     */
    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    /**
     * 保存或更新用户
     * @param user
     * @throws CustomerException
     */
    @Override
    public void saveOrUpdate(User user) throws CustomerException {
        if (user.getId() != null) {
            userMapper.update(user);
        }else {
            //判断用户名是否被占用
            User user1 = userMapper.findByUsername(user.getUsername());
            if (user1 != null) {
                throw new CustomerException("该用户名已被占用");
            }else {
                userMapper.save(user);
            }
        }
    }

    /**
     * id删除用户
     * @param id
     * @throws CustomerException
     */
    @Override
    public void deleteById(Integer id) throws CustomerException {
        User user = userMapper.findById(id);
        if (user == null) {
            throw new CustomerException("删除的用户不存在");
        }
        userMapper.deleteById(id);
    }

    /**
     * 设置用户角色的权限
     * @param userId
     * @param roleIds
     * @throws CustomerException
     */
    @Override
    public void setRoles(Integer userId, List<Integer> roleIds) throws CustomerException {
        User user = userMapper.findById(userId);
        //获取到当前用户所具有的角色
        List<Role> roles = user.getRoles();
        //将当前用户角色的每个id都放到新的list集合之中
        List<Integer> oldRoles =new ArrayList<>();
        for (Role role:roles) {
            oldRoles.add(role.getId());
        }
        //遍历新的角色id，如果旧的id中不包含新id就添加
        for (Integer roleId: roleIds) {
            if (!oldRoles.contains(roleId)) {
                userRoleMapper.addRoleToUser(userId,roleId);
            }
        }
        //依次判断老的角色是否存在于roleIds中，如果不存在则删除
        for (Integer roleId: oldRoles) {
            if (!roleIds.contains(roleId)) {
                userRoleMapper.deleteUserRole(userId,roleId);
            }
        }

    }
}
