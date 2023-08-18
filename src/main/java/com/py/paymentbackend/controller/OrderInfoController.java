package com.py.paymentbackend.controller;

import com.py.paymentbackend.entity.OrderInfo;
import com.py.paymentbackend.service.OrderInfoService;
import com.py.paymentbackend.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "商品订单管理")
@CrossOrigin
@RestController
@RequestMapping("/api/order-info")
public class OrderInfoController {

    @Resource
    private OrderInfoService orderInfoService;


    @ApiOperation("订单列表")
    @GetMapping("/list")
    public R list() {
        List<OrderInfo> orderInfoList = orderInfoService.listOrderByCreateTimeDesc();
        return R.ok().data("list", orderInfoList);
    }



}

