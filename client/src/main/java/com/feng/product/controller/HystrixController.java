package com.feng.product.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Author fengwen
 * @Date 2019/10/8 14:28
 * @Version V1.0
 */
@RestController
@RequestMapping("hystrix")
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {

    //第一种
   /* @HystrixCommand(fallbackMethod = "fallback")*/

    //第二种
   /* @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })*/

   /* @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")
    })*/
    @HystrixCommand
    @GetMapping("test")
    public String getHello(@RequestParam("num")Integer num){
        if(num%2==0){
            return "成功";
        }
        RestTemplate template = new RestTemplate();
        return template.getForObject("http://127.0.0.1:8086/test/name",String.class);
    }

    public String fallback(){
        return "请稍后再试。。。";
    }

    public String defaultFallback(){
        return "默认 请稍后再试。。。";
    }



}
