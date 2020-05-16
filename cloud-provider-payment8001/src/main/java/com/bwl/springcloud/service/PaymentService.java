package com.bwl.springcloud.service;

import com.bwl.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
