package com.bwl.springcloud.controller;

import com.bwl.springcloud.common.CommonResult;
import com.bwl.springcloud.entity.Payment;
import com.bwl.springcloud.service.PaymenttFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName PaymentFeignController
 * @Description: TODO
 * @Author shukang
 * @Date 2020/5/13
 **/
@RestController
@Slf4j
public class PaymentFeignController {
    @Resource
    private PaymenttFeignService paymenttFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        int i = 0;
        return paymenttFeignService.getPaymentById(id);
    }


    @GetMapping("/consumer/payment/feign/timeout")
    String paymentFeignTimeout(){
//        openfeign-ribbon,客户端一般默认等待1s钟
        return paymenttFeignService.paymentFeignTimeout();
    }
}
