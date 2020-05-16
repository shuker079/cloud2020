package com.bwl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName EurekaMain7001
 * @Description: TODO
 * @Author shukang
 * @Date 2020/5/10
 **/

/**
 * 自我保护机制：
 *      默认情况下EurekaClient定时向EurekaServer端发送心跳包，如果Eureka的server端
 *      在一定时间内（默认90s）没有收到EurekaClient发送心跳包，便会直接从服务注册列表
 *      中剔除该服务，但是在短时间(90s)中丢失了大量的服务器心跳，这时候EurekaServer会
 *      开启自我保护机制，不会剔除该服务（该现象可能出现在如果网络不通，但是EurekaClient
 *      为出现宕机，此使如果换做别的注册中心如果一定时间内没有收到心跳将会剔除该服务，
 *      这样就出现了严重失误，因为客户端还能正常发送心跳，只是网络延迟问题，而保护机制
 *      是为了解决此问题而产生的）
 *
 *      在自我保护模式中，EurekaServer会保护服务注册表中的信息，不会注销任何服务实例
 *
 *      它的设计哲学就是宁可保留错误的服务注册信息，也不盲目注销任何可能的服务实例
 *
 *      综上，自我保护模式是一种应对网络异常的安全保护措施，它的架构哲学是宁可同时保留
 *      所有微服务（健康的微服务和不健康的微服务都会保留），也不盲目注销任何健康的微服务
 *      使用自我保护模式，可以让Eureka集群更加的健壮、稳定
 *
 *      一句话：某时刻某一个微服务不可用了，Eureka不会立刻清理，依旧会对该微服务的信息进行保存
 *      属于CAP里面的AP分支（高可用）
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class,args);
    }
}
