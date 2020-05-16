package com.bwl.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @ClassName PaymentConsulController
 * @Description: TODO
 * @Author shukang
 * @Date 2020/5/12
 **/
@RestController
@Slf4j
public class PaymentConsulController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/consul")
    public String paymewntConsul(){
        return "springcloud with consul :" + serverPort+"\t" + UUID.randomUUID().toString();
    }
}
