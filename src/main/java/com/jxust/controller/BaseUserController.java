package com.jxust.controller;

import com.jxust.bean.User;
import com.jxust.service.UserService;
import com.jxust.utils.CustomerException;
import com.jxust.utils.Message;
import com.jxust.utils.MessageUtils;
import com.jxust.vm.UserRoleVM;
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
import java.util.List;

@Validated
@RestController
@RequestMapping("/baseUser")
public class BaseUserController {

    @Autowired
    private UserService userService;

    /**
     * 查询所有用户
     * @return
     */
    @ApiOperation(value = "查询所有用户")
    @GetMapping("findAll")
    public Message findAll() {
        List<User> users = userService.findAll();
        return MessageUtils.success(users);
    }

    /**
     * 添加用户
     * @param id
     * @param username
     * @param password
     * @param gender
     * @param email
     * @param phoneNum
     * @return
     * @throws CustomerException
     */
    @ApiOperation(value = "添加用户信息")
    @PostMapping("saveOrUpdate")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "编号",paramType = "form",required = false),
            @ApiImplicitParam(name = "username", value = "用户名",paramType = "form",required = true),
            @ApiImplicitParam(name = "password", value = "密码",paramType = "form",required = true),
            // @ApiImplicitParam(name = "DepartureTime", value = "出发时间",paramType = "form",required = true),
            @ApiImplicitParam(name = "gender", value = "性别",paramType = "form",required = true),
            @ApiImplicitParam(name = "email", value = "邮箱",paramType = "form",required = true),
            @ApiImplicitParam(name = "phoneNum", value = "电话号码",paramType = "form",required = true)
    })
    public Message saveOrUpdate(
            Integer id,
            @NotNull String username,
            @NotNull String password,
            @NotNull String gender,
            @NotNull String email,
            @NotNull String phoneNum) throws CustomerException {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setGender(gender);
        user.setPhoneNum(phoneNum);
        userService.saveOrUpdate(user);
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
        userService.deleteById(id);
        return MessageUtils.success("删除成功");
    }

    /**
     * 设置用户权限
     * @param userRoleVM
     * @return
     * @throws CustomerException
     */
    @ApiOperation(value = "设置用户权限")
    @PostMapping("setRoles")
    public Message setRoles(UserRoleVM userRoleVM) throws CustomerException {
        userService.setRoles(userRoleVM.getUserId(),userRoleVM.getRoleIds());
        return MessageUtils.success("设置成功");
    }
}
