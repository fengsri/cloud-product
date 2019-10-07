package com.feng.product.repository;

import com.feng.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @Author fengwen
 * @Date 2019/9/25 15:40
 * @Version V1.0
 */

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    List<Product> findByIdIn(List<Integer> list);

}
