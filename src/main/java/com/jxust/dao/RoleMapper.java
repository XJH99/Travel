package com.jxust.dao;

import com.jxust.bean.Role;
import com.jxust.utils.CustomerException;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色mapper接口
 */
@Mapper
public interface RoleMapper {

    /**
     * 通过用户id来查询角色信息
     * @param userId
     * @return
     * @throws CustomerException
     */
    List<Role> findByUserId(Integer userId) throws CustomerException;

    /**
     * 查询所有的角色
     * @return
     * @throws CustomerException
     */
    List<Role> findAll() throws CustomerException;

    /**
     * 添加角色
     * @param role
     * @throws CustomerException
     */
    void save(Role role) throws CustomerException;

    /**
     * 更新角色
     * @param role
     * @throws CustomerException
     */
    void update(Role role) throws CustomerException;

    /**
     * 通过角色名查找
     * @param roleName
     * @return
     * @throws CustomerException
     */
    Role findByRoleName(String roleName) throws CustomerException;

    /**
     * 通过id来删除
     * @param id
     * @throws CustomerException
     */
    void deleteById(Integer id) throws CustomerException;

    /**
     * id查询角色
     * @param id
     * @return
     * @throws CustomerException
     */
    Role findById(Integer id) throws CustomerException;

    /**
     * 角色-权限中间表中插入新权限
     * @param roleId
     * @param permissionId
     * @throws CustomerException
     */
    @Insert("insert into role_permission(role_id,permission_id) values (#{roleId} ,#{permissionId} )")
    void addPermissionToRole(@Param("roleId") Integer roleId, @Param("permissionId") Integer permissionId) throws CustomerException;

    /**
     * 角色-权限表删除数据
     * @param roleId
     * @param permissionId
     * @throws CustomerException
     */
    @Delete("delete from role_permission where role_id = #{roleId} and permission_id = #{permissionId} ")
    void deleteRolePermission(@Param("roleId") Integer roleId, @Param("permissionId") Integer permissionId) throws CustomerException;
}
