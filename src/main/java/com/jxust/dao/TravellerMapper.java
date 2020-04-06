package com.jxust.dao;

import com.jxust.bean.Traveller;
import com.jxust.utils.CustomerException;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 游客mapper接口
 */
@Mapper
public interface TravellerMapper {

    /**
     * 通过订单id来查询游客信息
     * @param orderId
     * @return
     * @throws CustomerException
     */
    List<Traveller> findByOrderId(Integer orderId) throws CustomerException;
}
