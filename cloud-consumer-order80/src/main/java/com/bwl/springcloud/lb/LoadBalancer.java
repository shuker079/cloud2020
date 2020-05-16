package com.bwl.springcloud.lb;


import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalancer {

//   收集Eureka上存活的集群
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
