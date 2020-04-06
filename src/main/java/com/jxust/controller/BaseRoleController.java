package com.jxust.controller;

import com.jxust.bean.Role;
import com.jxust.service.RoleService;
import com.jxust.utils.CustomerException;
import com.jxust.utils.Message;
import com.jxust.utils.MessageUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

@Validated
@RestController
@RequestMapping("/baseRole")
public class BaseRoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 查询所有的角色
     * @return
     * @throws CustomerException
     */
    @GetMapping("findAll")
    public Message findAll() throws CustomerException {
        List<Role> roles = roleService.findAll();
        return MessageUtils.success(roles);
    }

    /**
     * 添加或更新
     * @param id
     * @param roleName
     * @param roleDesc
     * @return
     * @throws CustomerException
     */
    @ApiOperation(value = "添加或更新")
    @PostMapping("saveOrUpdate")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "编号",paramType = "form",required = false),
            @ApiImplicitParam(name = "roleName", value = "角色名",paramType = "form",required = true),
            @ApiImplicitParam(name = "roleDesc", value = "角色描述",paramType = "form",required = true),
    })
    public Message saveOrUpdate(
            Integer id,
            @NotNull String roleName,
            @NotNull String roleDesc) throws CustomerException{
        Role role = new Role();
        role.setId(id);
        role.setRoleName(roleName);
        role.setRoleDesc(roleDesc);
        roleService.saveOrUpdate(role);
        return MessageUtils.success("更新成功");
    }


    /**
     * 通过id删除
     * @param id
     * @return
     * @throws CustomerException
     */
    @ApiOperation(value = "通过id删除")
    @GetMapping("deleteById")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "编号",paramType = "query",required = true),
    })
    public Message deleteById(Integer id) throws CustomerException{
        roleService.deleteById(id);
        return MessageUtils.success("删除成功");
    }

    /**
     * 给角色授权
     * @param id
     * @param permissions
     * @return
     */
    @ApiOperation(value = "给角色授权")
    @PostMapping("authorization")
    public Message authorization(Integer id, Integer[] permissions) {
        List<Integer> ids = Arrays.asList(permissions);
        roleService.authorization(id,ids);
        return MessageUtils.success("授权成功");
    }
}
