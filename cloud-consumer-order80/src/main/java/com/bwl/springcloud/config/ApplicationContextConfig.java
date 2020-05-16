package com.bwl.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ApplicationContextConfig
 * @Description: TODO
 * @Author shukang
 * @Date 2020/5/10
 **/
@Configuration
public class ApplicationContextConfig {
    @Bean
//    LoadBalanced注解赋予了RestTempllate负载均衡的能力
    public RestTemplate getRestTenokate(){
        return new RestTemplate();
    }
}
