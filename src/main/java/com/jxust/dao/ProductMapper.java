package com.jxust.dao;

import com.jxust.bean.Product;
import com.jxust.utils.CustomerException;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * DAO层接口，mapper注解非常重要
 */
@Mapper
public interface ProductMapper {

    /**
     * 查询所有产品
     * @return
     * @throws Exception
     */
    List<Product> findAll() throws CustomerException;

    /**
     * 产品添加
     * @param product
     */
    void save(Product product) throws CustomerException;

    /**
     * 更新产品
     * @param product
     */
    void update(Product product) throws CustomerException;

    /**
     * 删除产品
     * @param id
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
