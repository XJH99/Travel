package com.jxust.dao;

import com.jxust.bean.Orders;
import com.jxust.utils.CustomerException;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 订单相关接口
 */
@Mapper
public interface OrderMapper {
    /**
     * 查询所有的订单
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
