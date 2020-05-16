package com.bwl.spring.controller;

import com.bwl.spring.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName PaymentHystrixController
 * @Description: TODO
 * @Author shukang
 * @Date 2020/5/14
 **/
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_global_FallBackMethod")
public class PaymentHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfoOK(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfoOK(id);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
    @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        int a = 10 / 0;
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        return result;
    }

    public String paymentInfoTimeOutHandler(@PathVariable("id") Integer id){
        return "客户端80，对方系统繁忙，请稍后再试/(ㄒoㄒ)/~~";
    }

    public String payment_global_FallBackMethod(){
        return "Global 异常处理信息，请稍后再试(〃＞目＜)";
    }
}
