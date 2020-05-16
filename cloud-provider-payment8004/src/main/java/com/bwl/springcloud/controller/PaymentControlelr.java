package com.bwl.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @ClassName PaymentControlelr
 * @Description: TODO
 * @Author shukang
 * @Date 2020/5/11
 **/
@RestController
@Slf4j
public class PaymentControlelr {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/zk")
    public String paymentzk(){
        return "springcloud with zookeeper: " + serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
