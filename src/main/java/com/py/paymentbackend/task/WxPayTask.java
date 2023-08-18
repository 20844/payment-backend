package com.py.paymentbackend.task;

import com.py.paymentbackend.entity.OrderInfo;
import com.py.paymentbackend.entity.RefundInfo;
import com.py.paymentbackend.enums.PayType;
import com.py.paymentbackend.service.OrderInfoService;
import com.py.paymentbackend.service.RefundInfoService;
import com.py.paymentbackend.service.WxPayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * cron表达式生成器
 *   https://cron.qqe2.com/
 *   https://www.pppet.net/
 */
@Slf4j
@Component
public class WxPayTask {

    @Resource
    private OrderInfoService orderInfoService;

    @Resource
    private WxPayService wxPayService;

    @Resource
    private RefundInfoService refundInfoService;


    /**
     * 测试
     * (cron="秒 分 时 日 月 周")
     * *：每隔一秒执行
     * 0/3：从第0秒开始，每隔3秒执行一次
     * 1-3: 从第1秒开始执行，到第3秒结束执行
     * 1,2,3：第1、2、3秒执行
     * ?：不指定
     * 日和周不能同时制定，指定其中之一，则另一个设置为？
     * 若指定日期，则不指定周，反之同理
     */
    //@Scheduled(cron="0/3 * * * * ?")
    public void testTask() {
        log.info("测试定时任务执行");
    }

    /**
     * 定时查找超时订单
     * 从第0秒开始每隔30秒执行1次，查询创建超过5分钟，并且未支付的订单
     */
    //@Scheduled(cron = "0/30 * * * * ?")
    public void orderConfirm() throws Exception {
        log.info("orderConfirm执行，定时查找超时订单...");
        List<OrderInfo> orderInfoList = orderInfoService.getNoPayOrderByDuration(5, PayType.WXPAY.getType());
        for (OrderInfo orderInfo : orderInfoList) {
            String orderNo = orderInfo.getOrderNo();
            log.warn("超时订单:{}", orderNo);
            // 核实订单状态：调用微信支付查单接口
            wxPayService.checkOrderStatus(orderNo);
        }
    }

    /**
     * 从第0秒开始每隔30秒执行1次，查询创建超过5分钟，并且未成功的退款单
     */
    //@Scheduled(cron = "0/30 * * * * ?")
    public void refundConfirm() throws Exception {
        log.info("refundConfirm 被执行......");
        // 找出申请退款超过5分钟并且未成功的退款单
        List<RefundInfo> refundInfos = refundInfoService.getNoRefundOrderByDuration(5, PayType.WXPAY.getType());
        for (RefundInfo refundInfo : refundInfos) {
            // 核实订单状态：调用微信支付查询退款接口
            String refundNo = refundInfo.getRefundNo();
            log.warn("超时未退款的退款单号:{}", refundNo);
            wxPayService.checkRefundStatus(refundNo);
        }
    }




}
