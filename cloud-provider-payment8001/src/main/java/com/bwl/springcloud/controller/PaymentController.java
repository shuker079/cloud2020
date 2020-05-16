package com.bwl.springcloud.controller;

import com.bwl.springcloud.common.CommonResult;
import com.bwl.springcloud.entity.Payment;
import com.bwl.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName PaymentController
 * @Description: TODO
 * @Author shukang
 * @Date 2020/5/10
 **/
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

//    通过服务发现来获取到该服务的信息
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("******插入结果：" + result+"serverPort:"+serverPort);
        if (result > 0) {
            return CommonResult.success(result);
        } else {
            return CommonResult.faield("添加失败");
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("******查询结果：" + payment);
        if (payment != null) {
            return CommonResult.success(payment);
        }else {
            return CommonResult.faield("id错误，查询失败");
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        services.forEach(System.out::println);
        System.out.println("-------------------");
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMANT-SERVICE");
        for (ServiceInstance s :instances) {
            System.out.println(s.getHost()+"-->"+s.getPort()+"-->"+s.getInstanceId()+"-->"+s.getUri()+"-->"+s.getServiceId()+"-->"+s.getScheme());
        }
        return this.discoveryClient;
    }


    @GetMapping("/payment/lb")
    public String  getPaymentLB(){
        return serverPort;
    }


    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try{
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return serverPort;
    }
}
