package com.bwl.spring.service;

import org.springframework.stereotype.Component;

/**
 * @ClassName PaymentFallbackService
 * @Description: TODO
 * @Author shukang
 * @Date 2020/5/14
 **/
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfoOK(Integer id) {
        return "------PaymentFallbackService fall back-paymentInfo_OK,(；′⌒`)";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "------PaymentFallbackService fall back-paymentInfo_TimeOut,(；′⌒`)";
    }
}
