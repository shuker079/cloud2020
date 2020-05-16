package com.bwl.springcloud.service.impl;

import com.bwl.springcloud.dao.PaymentDao;
import com.bwl.springcloud.entity.Payment;
import com.bwl.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName PaymentServiceImpl
 * @Description: TODO
 * @Author shukang
 * @Date 2020/5/10
 **/
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
