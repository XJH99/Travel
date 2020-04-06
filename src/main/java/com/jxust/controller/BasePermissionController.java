package com.jxust.controller;

import com.jxust.service.PermissionService;
import com.jxust.utils.CustomerException;
import com.jxust.utils.Message;
import com.jxust.utils.MessageUtils;
import com.jxust.vm.PermissionTree;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/basePermission")
public class BasePermissionController {

    @Autowired
    private PermissionService permissionService;

    /**
     * 查询权限树
     * @return
     * @throws CustomerException
     */
    @ApiOperation(value = "查询权限树")
    @GetMapping("findPermissionTree")
    public Message findPermissionTree() throws CustomerException {
        List<PermissionTree> permissionTree = permissionService.findPermissionTree();
        return MessageUtils.success(permissionTree);
    }
}
