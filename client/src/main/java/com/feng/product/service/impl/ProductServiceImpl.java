package com.feng.product.service.impl;

import com.feng.product.domain.Product;
import com.feng.product.enums.ErrorCodeEnum;
import com.feng.product.exception.BusinessException;
import com.feng.product.repository.ProductRepository;
import com.feng.product.service.ProductService;
import com.feng.product.vo.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @Description
 * @Author fengwen
 * @Date 2019/10/7 17:31
 * @Version V1.0
 */
@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductRepository repository;

    /**
     * 通过id查询商品
     * @param list
     * @return
     */
    @Override
    public List<Product> findByIds(List<Integer> list) {
        return repository.findByIdIn(list);
    }

    /**
     * 减库存
     * @param productInfoList
     * @return
     */
    @Override
    @Transactional
    public boolean reduceProductCount(List<ProductInfo> productInfoList) {
        for(ProductInfo productInfo:productInfoList){
            Optional<Product> optional = repository.findById(productInfo.getProductId());
            if(!optional.isPresent()){
                throw new BusinessException(ErrorCodeEnum.NOT_EXIST_PRODUCT_ERROR);
            }
            Product product = optional.get();
            int result = product.getCount()-productInfo.getCount();
            if(result<0){
                throw new BusinessException(ErrorCodeEnum.PRODUCT_COUNT_ERROR);
            }
            product.setCount(result);
            repository.save(product);
        }
        return true;
    }


}
