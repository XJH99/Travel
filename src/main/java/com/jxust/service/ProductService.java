package com.jxust.service;

import com.jxust.bean.Product;
import com.jxust.utils.CustomerException;
import io.swagger.models.auth.In;

import java.util.List;

public interface ProductService {

    /**
     * 查询所有产品接口
     * @return
     * @throws Exception
     */
    List<Product> findAll() throws CustomerException;

    /**
     * 添加产品
     * @param product
     */
    void saveOrUpdate(Product product) throws CustomerException;

    /**
     * 删除产品
     * @param id
     * @throws CustomerException
     */
    void delete(Integer id) throws CustomerException;

    /**
     * 根据id查询产品
     * @param id
     * @return
     * @throws CustomerException
     */
    Product findById(Integer id) throws CustomerException;
}
