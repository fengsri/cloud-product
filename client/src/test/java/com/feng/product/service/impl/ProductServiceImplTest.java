package com.feng.product.service.impl;

import com.feng.product.domain.Product;
import com.feng.product.service.ProductService;
import com.feng.product.vo.ProductInfo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceImplTest {

    @Autowired
    private ProductService productService;
    @Test
    void findByIds() {
        List<Product> productList = productService.findByIds(Arrays.asList(1, 2));
        System.out.println(productList);
    }

    @Test
    void reduct() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId(1);
        productInfo.setCount(2);
        boolean result = productService.reduceProductCount(Arrays.asList(productInfo));
        System.out.println(result);
    }

}