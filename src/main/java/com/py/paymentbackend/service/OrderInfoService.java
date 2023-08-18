package com.py.paymentbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.py.paymentbackend.entity.OrderInfo;
import com.py.paymentbackend.enums.OrderStatus;

import java.util.List;


public interface OrderInfoService extends IService<OrderInfo> {

    /**
     * 保存订单
     */
    OrderInfo createOrderByProductId(Long productId, String paymentType);

    /**
     * 缓存二维码
     */
    void saveCodeUrl(String orderNo, String codeUrl);

    /**
     * 查询订单列表并按照创建时间降序返回
     */
    List<OrderInfo> listOrderByCreateTimeDesc();

    /**
     * 根据订单号获取订单状态
     */
    String getOrderStatus(String orderNo);

    /**
     * 更新订单支付状态
     */
    void updateStatusByOrderNo(String orderNo, OrderStatus orderStatus);

    /**
     * 找出创建超过minutes分钟并且未支付的订单
     */
    List<OrderInfo> getNoPayOrderByDuration(int minutes, String payType);

    /**
     * 根据订单号查订单
     */
    OrderInfo getOrderByOrderNo(String orderNo);
}
