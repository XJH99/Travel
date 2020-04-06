package com.jxust.controller;

import com.jxust.bean.Orders;
import com.jxust.service.OrderService;
import com.jxust.utils.CustomerException;
import com.jxust.utils.Message;
import com.jxust.utils.MessageUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 查询所有订单
     * @return
     * @throws CustomerException
     */
    @ApiOperation(value = "查询所有的订单")
    @GetMapping("findAll")
    public Message findAll() throws CustomerException {
        List<Orders> orders = orderService.findAll();
        return MessageUtils.success(orders);
    }

    /**
     * 根据id来查询订单
     * @param id
     * @return
     * @throws CustomerException
     */
    @ApiOperation(value = "根据id查询对应订单")
    @GetMapping("findById")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "编号",paramType = "query",required = true),
    })
    public Message findById(Integer id) throws CustomerException {
        Orders order = orderService.findById(id);
        return MessageUtils.success(order);
    }
}
