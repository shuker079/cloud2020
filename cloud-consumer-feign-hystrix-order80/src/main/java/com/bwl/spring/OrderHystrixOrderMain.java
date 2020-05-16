package com.bwl.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName OrderHystrixOrderMain
 * @Description: TODO
 * @Author shukang
 * @Date 2020/5/14
 **/
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderHystrixOrderMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixOrderMain.class,args);
    }
}
