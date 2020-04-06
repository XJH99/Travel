package com.jxust.service.impl;

import com.jxust.bean.Product;
import com.jxust.dao.ProductMapper;
import com.jxust.service.ProductService;
import com.jxust.utils.CustomerException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 业务层实现类
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    //按照名称来装配
    @Resource
    private ProductMapper productMapper;

    /**
     * 查询所有产品
     * @return
     * @throws CustomerException
     */
    @Override
    public List<Product> findAll() throws CustomerException {
        return productMapper.findAll();
    }

    /**
     * 添加产品
     * @param product
     * @throws CustomerException
     */
    @Override
    public void saveOrUpdate(Product product) throws CustomerException {
        //id不为空的时候进行更新产品
        if (product.getId() != null) {
            productMapper.update(product);
        }else {
            productMapper.save(product);
        }
    }

    /**
     * 删除产品
     * @param id
     * @throws CustomerException
     */
    @Override
    public void delete(Integer id) throws CustomerException {
        Product product = productMapper.findById(id);
        if (product != null) {
            productMapper.delete(id);
        }else {
            throw new CustomerException("产品不存在");
        }

    }

    /**
     * 根据id查询产品
     * @param id
     * @return
     * @throws CustomerException
     */
    @Override
    public Product findById(Integer id) throws CustomerException {
        return productMapper.findById(id);
    }


}
