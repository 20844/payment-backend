package com.py.paymentbackend.controller;

import com.alipay.api.AlipayApiException;
import com.py.paymentbackend.service.AliPayService;
import com.py.paymentbackend.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Slf4j
@CrossOrigin
@Api(tags = "网站支付宝支付")
@RestController
@RequestMapping("/api/ali-pay")
public class AliPayController {

    @Resource
    private AliPayService aliPayService;

    @Resource
    private Environment config;


    /**
     * 1.统一收单下单并支付页面接口的调用
     */
    @ApiOperation("统一收单下单并支付页面接口的调用")
    @PostMapping("/trade/page/pay/{productId}")
    public R tradePagePay(@PathVariable Long productId) throws AlipayApiException {
        // 记录日志 下单 返回数据
        log.info("统一收单下单并支付页面接口调用");
        //支付宝开放平台接受 request请求对象后
        //公为开发者生成一个html 形式的 form 表单，包合自动提交的鄉本
        String formStr = aliPayService.tradeCreate(productId);
        //我们将form 表单字符串反回给前端程序，之后前端将会调用自动提交脚本，进行表单的提交
        //此时，表单会自动提交到action 属性所指向的支付宝开放平台中，从而为用户展示一个支付页面
        return R.ok().data("formStr", formStr);
    }



}
