package com.feng.product.service;

import com.feng.product.domain.Product;
import com.feng.product.vo.ProductInfo;

import java.util.List;

/**
 * @Description
 * @Author fengwen
 * @Date 2019/10/7 17:31
 * @Version V1.0
 */
public interface ProductService {

    /**
     * 通过id查询商品
     * @param list
     * @return
     */
    List<Product> findByIds(List<Integer> list);


    boolean reduceProductCount(List<ProductInfo> productInfoList);

}
