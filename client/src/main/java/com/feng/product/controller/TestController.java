package com.feng.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author fengwen
 * @Date 2019/9/25 16:12
 * @Version V1.0
 */
@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("msg")
    public String getMessage(){
        return "product hello word";
    }

}
