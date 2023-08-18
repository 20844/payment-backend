package com.py.paymentbackend;

import com.py.paymentbackend.config.WxPayConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.security.PrivateKey;

@SpringBootTest
class PaymentBackendApplicationTests {
    @Resource
    private WxPayConfig wxPayConfig;

    /**
     * 获取微信商户私钥
     */
    // @Test
    // void testGetWxPrivateKey() {
    //    //获取私钥路径
    //    String privateKeyPath = wxPayConfig.getPrivateKeyPath();
    //    //获取私钥,getPrivateKey为public才能获取
    //    PrivateKey partnerKey = wxPayConfig.getPrivateKey(privateKeyPath);
    //    System.out.println(partnerKey);
    // }
    @Test
    void contextLoads() {
    }



}
