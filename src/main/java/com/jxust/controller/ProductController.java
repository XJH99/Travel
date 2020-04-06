package com.jxust.controller;

import com.jxust.bean.Product;
import com.jxust.service.ProductService;
import com.jxust.utils.CustomerException;
import com.jxust.utils.Message;
import com.jxust.utils.MessageUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * 旅游产品控制器类
 */
@Validated  //数据校验注解
@RestController
@RequestMapping("/product")
@CrossOrigin    //解决跨域问题注解
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * GET方式请求，查询所有产品
     * @return
     * @throws CustomerException
     */
    @ApiOperation(value = "查询所有旅游路线")
    @GetMapping("findAll")
    public Message findAll() throws CustomerException {
        List<Product> products = productService.findAll();
        return MessageUtils.success(products);
    }


    /**
     * post方式，添加产品与更新产品
     * @param id
     * @param productName
     * @param cityName
     * @param productPrice
     * @param productDesc
     * @param productStatus
     * @return
     * @throws CustomerException
     */
    @ApiOperation(value = "添加旅游产品路线")
    @PostMapping("saveOrUpdate")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "编号",paramType = "form",required = false),
            @ApiImplicitParam(name = "productName", value = "产品名称",paramType = "form",required = true),
            @ApiImplicitParam(name = "cityName", value = "目的城市",paramType = "form",required = true),
           // @ApiImplicitParam(name = "DepartureTime", value = "出发时间",paramType = "form",required = true),
            @ApiImplicitParam(name = "productPrice", value = "产品价格",paramType = "form",required = true),
            @ApiImplicitParam(name = "productDesc", value = "产品描述",paramType = "form",required = true),
            @ApiImplicitParam(name = "productStatus", value = "状态",paramType = "form",required = true)
    })
    public Message saveOrUpdate(
            Integer id,
            @NotNull String productName,    //@NotNull注解表示传入参数时不能为空
            @NotNull String cityName,
            //@NotNull Date departureTime,
            @NotNull Double productPrice,
            @NotNull String productDesc,
            @NotNull Integer productStatus) throws CustomerException {
        Product product = new Product();
        product.setId(id);
        product.setProductName(productName);
        product.setCityName(cityName);
        product.setDepartureTime(new Date());
        product.setProductPrice(productPrice);
        product.setProductDesc(productDesc);
        product.setProductStatus(productStatus);
        productService.saveOrUpdate(product);
        return MessageUtils.success("更新成功");
    }

    /**
     * 根据id删除产品
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id来删除产品")
    @GetMapping("delete")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "编号",paramType = "query",required = true),
    })
    public Message delete(Integer id) {
        productService.delete(id);
        return MessageUtils.success("删除成功");
    }

    /**
     * 根据id来查询产品
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id来查询产品")
    @GetMapping("findById")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "编号",paramType = "query",required = true),
    })
    public Message findById(Integer id){
        System.out.println(id);
        Product product = productService.findById(id);
        System.out.println(product);
        return MessageUtils.success(product);
    }

}
