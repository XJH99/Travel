package com.jxust.service.impl;

import com.jxust.bean.Orders;
import com.jxust.dao.OrderMapper;
import com.jxust.service.OrderService;
import com.jxust.utils.CustomerException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单的业务层实现类
 */
@Transactional
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    /**
     * 查询所有订单
     * @return
     * @throws CustomerException
     */
    @Override
    public List<Orders> findAll() throws CustomerException {
        return orderMapper.findAll();
    }

    /**
     * 根据id查询订单
     * @param id
     * @return
     * @throws CustomerException
     */
    @Override
    public Orders findById(Integer id) throws CustomerException {
        return orderMapper.findById(id);
    }
}
