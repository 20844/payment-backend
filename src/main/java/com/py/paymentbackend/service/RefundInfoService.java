package com.py.paymentbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.py.paymentbackend.entity.RefundInfo;


public interface RefundInfoService extends IService<RefundInfo> {

    RefundInfo createRefundByOrderNo(String orderNo, String reason, String paymentType);

    void updateRefund(String content);
}
