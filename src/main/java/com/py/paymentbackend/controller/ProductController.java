package com.py.paymentbackend.controller;

import com.py.paymentbackend.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Api(tags = "商品管理")
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @ApiOperation("测试接口")
    @GetMapping("/test")
    public R test(){
        return R.ok().data("message", "hello").data("now",new Date());
    }
}
