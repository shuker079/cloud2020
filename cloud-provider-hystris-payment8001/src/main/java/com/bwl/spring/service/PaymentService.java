package com.bwl.spring.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName PaymentService
 * @Description: TODO
 * @Author shukang
 * @Date 2020/5/13
 **/
@Service
public class PaymentService {
    public String paymentInfoOK(Integer id){
        return "线程池: " + Thread.currentThread().getName()+"  PayymentInfoOK,id " + id + "\t" + "---";
    }


    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_TimeOut(Integer id){
        try{
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池: " + Thread.currentThread().getName()+"  paymentInfo_TimeOut,id " + id + "\t" + "---耗时3秒";
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池: " + Thread.currentThread().getName()+"  paymentInfo_TimeOutHandler,id " + id + "\t" + "/(ㄒoㄒ)/~~";
    }


//    服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
//            是否开启断路器
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
//            请求次数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
//            时间窗口期
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
//            失败率达到多少后跳闸
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id < 0){
            throw new RuntimeException(("------id不能是负数"));
        }

        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能是负数，请稍后再试（*゜ー゜*）id：" + id;
    }
}
