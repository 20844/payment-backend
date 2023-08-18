package com.py.paymentbackend.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.py.paymentbackend.entity.PaymentInfo;

public interface PaymentInfoService extends IService<PaymentInfo> {

    /**
     * 创建支付信息，记录微信支付日志
     * @param plainText
     */
    void createPaymentInfo(String plainText);


}
