package com.jxust.controller;

import com.jxust.bean.User;
import com.jxust.service.UserService;
import com.jxust.utils.Message;
import com.jxust.utils.MessageUtils;
import com.jxust.vm.UserVm;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Validated
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录校验
     * @param userVm
     * @return
     */
    @PostMapping("login")
    public Message login(@RequestBody UserVm userVm) {
        Map<String,String> map = new HashMap<>();
        map.put("token","admin-token");
        return MessageUtils.success(map);
    }

    /**
     * 通过token来获取用户基本信息
     * @param token
     * @return
     */
    @ApiOperation(value = "通过token来获取用户基本信息")
    @GetMapping("info")
    public Message info(String token) {
        User user = userService.findById(1);
        return MessageUtils.success(user);
    }

    /**
     * 退出功能
     * @return
     */
    @PostMapping("logout")
    public Message logout() {
        return MessageUtils.success("退出成功");
    }
}
