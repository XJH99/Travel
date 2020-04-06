package com.jxust.service.impl;

import com.jxust.bean.Permission;
import com.jxust.bean.Role;
import com.jxust.dao.RoleMapper;
import com.jxust.service.RoleService;
import com.jxust.utils.CustomerException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    /**
     * 查询所有的角色
     * @return
     * @throws CustomerException
     */
    @Override
    public List<Role> findAll() throws CustomerException {
        return roleMapper.findAll();
    }

    /**
     * 保存或更新角色
     * @param role
     * @throws CustomerException
     */
    @Override
    public void saveOrUpdate(Role role) throws CustomerException {
        if (role.getId() != null) {
            //携带id过来，更新角色
            roleMapper.update(role);
        }else {
            //判断角色名是否重复
            Role roleName = roleMapper.findByRoleName(role.getRoleName());
            if (roleName != null) {
                throw new CustomerException("该角色名已被占用");
            }else {
                roleMapper.save(role);
            }
        }
    }

    /**
     * 通过id删除
     * @param id
     * @throws CustomerException
     */
    @Override
    public void deleteById(Integer id) throws CustomerException {
        Role role = roleMapper.findById(id);
        if (role == null) {
            throw new CustomerException("删除的角色不存在");
        }
        roleMapper.deleteById(id);
    }

    /**
     * 角色授权
     * @param roleId
     * @param permissionIds
     * @throws CustomerException
     */
    @Override
    public void authorization(Integer roleId, List<Integer> permissionIds) throws CustomerException {
        Role role = roleMapper.findById(roleId);
        List<Permission> permissions = role.getPermissions();
        List<Integer> oldPermissions = new ArrayList<>();
        for (Permission permission: permissions) {
            //将该角色所拥有的权限放入新的集合中
            oldPermissions.add(permission.getId());
        }

        //遍历新权限集合，如果旧权限中不包含新权限id就添加到角色-权限桥表中
        for (Integer permissionId:permissionIds) {
            if (!oldPermissions.contains(permissionId)) {
                roleMapper.addPermissionToRole(roleId,permissionId);
            }
        }

        //遍历旧权限集合，如果新权限中不包含旧权限的id，就将它删除
        for (Integer permissionId:oldPermissions) {
            if (!permissionIds.contains(permissionId)) {
                roleMapper.deleteRolePermission(roleId,permissionId);
            }
        }

    }
}
