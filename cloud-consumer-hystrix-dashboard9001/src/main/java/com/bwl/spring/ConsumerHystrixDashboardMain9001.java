package com.bwl.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @ClassName ConsumerHystrixDashboardMain9001
 * @Description: TODO
 * @Author shukang
 * @Date 2020/5/15
 **/
@SpringBootApplication
@EnableHystrixDashboard
public class ConsumerHystrixDashboardMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerHystrixDashboardMain9001.class,args);
    }
}
