package com.feng.product.repository;

import com.feng.product.domain.Product;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;


    @Test
    void findByType() {
        List<Product> list = productRepository.findByIdIn(Arrays.asList(1,2));
        System.out.println(list);
    }

    @Test
    void save() {
        Product product = new Product();
        product.setId(6);
        product.setCount(10);
        product.setName("木瓜");
        product.setPrice(20.0);
        product.setType("水果");
        Product result = productRepository.save(product);
        System.out.println(result);
    }
}