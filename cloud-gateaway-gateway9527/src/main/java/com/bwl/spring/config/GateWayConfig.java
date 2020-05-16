package com.bwl.spring.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName GateWayConfig
 * @Description: TODO
 * @Author shukang
 * @Date 2020/5/15
 **/
@Configuration
public class GateWayConfig {
    /**
     * 配置一个id为route-name的路由规则
     * 当访问地址 http://localhost:9527/guonei时会自动转发到地址：http://news.baidu.com/guonei
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_rooute_bwl",
                r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }
}
