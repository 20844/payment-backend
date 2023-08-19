package com.py.paymentbackend.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.py.paymentbackend.entity.PaymentInfo;

import java.util.Map;

public interface PaymentInfoService extends IService<PaymentInfo> {

    /**
     * 创建支付信息，记录微信支付日志
     * @param plainText
     */
    void createPaymentInfo(String plainText);

    /**
     * 创建支付宝支付日志
     * @param params
     */
    void createPaymentInfoForAlipay(Map<String, String> params);


}
