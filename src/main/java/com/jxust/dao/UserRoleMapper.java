package com.jxust.dao;

import com.jxust.utils.CustomerException;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 用户角色桥表mapper接口
 */
@Mapper
public interface UserRoleMapper {

    /**
     * 给用户添加角色
     * @param userId
     * @param roleId
     * @throws CustomerException
     */
    @Insert("insert into user_role(user_id,role_id) values (#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") Integer userId, @Param("roleId") Integer roleId) throws CustomerException;

    /**
     * 删除用户与角色的关联
     * @param userId
     * @param roleId
     * @throws CustomerException
     */
    @Delete("delete from user_role where user_id = #{userId} and role_id = #{roleId} ")
    void deleteUserRole(@Param("userId") Integer userId, @Param("roleId") Integer roleId) throws CustomerException;
}
