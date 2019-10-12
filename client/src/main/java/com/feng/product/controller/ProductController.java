package com.feng.product.controller;

import com.feng.product.domain.Product;
import com.feng.product.enums.ErrorCodeEnum;
import com.feng.product.repository.ProductRepository;
import com.feng.product.service.ProductService;
import com.feng.product.util.ResultUtil;
import com.feng.product.vo.ProductInfo;
import com.feng.product.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @Description
 * @Author fengwen
 * @Date 2019/9/25 15:22
 * @Version V1.0
 */
@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 通过商品构面的列表进行修减商品库存
     * @param productInfoList
     */
    @PostMapping("reduce")
    public void reduceProductCount(@RequestBody List<ProductInfo> productInfoList){
        boolean result = productService.reduceProductCount(productInfoList);
    }

    /**
     * 通过商品id集合查询商品列表
     * @param listId
     * @return
     */
    @GetMapping("list")
    public List<Product> getByIds(@RequestParam("ids")List<Integer> listId){
        List<Product> list = productService.findByIds(listId);
        return list;
    }

}
