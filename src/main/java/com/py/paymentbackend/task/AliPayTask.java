package com.py.paymentbackend.task;

import com.py.paymentbackend.entity.OrderInfo;
import com.py.paymentbackend.entity.RefundInfo;
import com.py.paymentbackend.enums.PayType;
import com.py.paymentbackend.service.AliPayService;
import com.py.paymentbackend.service.OrderInfoService;
import com.py.paymentbackend.service.RefundInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * cron表达式生成器
 *   https://cron.qqe2.com/
 *   https://www.pppet.net/
 * @author yangjiewei
 * @date 2022/8/29
 */
@Slf4j
@Component
public class AliPayTask {

    @Resource
    private OrderInfoService orderInfoService;

    @Resource
    private AliPayService aliPayService;

    @Resource
    private RefundInfoService refundInfoService;

    /**
     * 定时查找超时订单
     * 从第0秒开始每隔30秒执行1次，查询创建超过5分钟，并且未支付的订单
     */
    @Scheduled(cron = "0/30 * * * * ?")
    public void orderConfirm() throws Exception {
        log.info("orderConfirm执行，定时查找超时订单...");
        List<OrderInfo> orderInfoList = orderInfoService.getNoPayOrderByDuration(5, PayType.ALIPAY.getType());
        for (OrderInfo orderInfo : orderInfoList) {
            String orderNo = orderInfo.getOrderNo();
            log.warn("超时订单:{}", orderNo);
            // 核实订单状态：调用微信支付查单接口
            aliPayService.checkOrderStatus(orderNo);
        }
    }

    /**
     * 从第0秒开始每隔30秒执行1次，查询创建超过5分钟，并且未成功的退款单
     */
    @Scheduled(cron = "0/30 * * * * ?")
    public void refundConfirm() throws Exception {
        log.info("refundConfirm 被执行......");
        // 找出申请退款超过5分钟并且未成功的退款单
        List<RefundInfo> refundInfos = refundInfoService.getNoRefundOrderByDuration(5, PayType.ALIPAY.getType());
        for (RefundInfo refundInfo : refundInfos) {
            // 核实订单状态：调用微信支付查询退款接口
            String refundNo = refundInfo.getRefundNo();
            log.warn("超时未退款的退款单号:{}", refundNo);
            aliPayService.checkRefundStatus(refundNo);
        }
    }


}
