package com.jxust.service;

import com.jxust.bean.Orders;
import com.jxust.utils.CustomerException;

import java.util.List;

/**
 * 订单的业务层接口
 */
public interface OrderService {

    /**
     * 查询所有订单
     * @return
     * @throws CustomerException
     */
    List<Orders> findAll() throws CustomerException;

    /**
     * 根据id来查询订单的详情
     * @param id
     * @return
     * @throws CustomerException
     */
    Orders findById(Integer id) throws CustomerException;
}
