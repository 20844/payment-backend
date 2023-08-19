package com.py.paymentbackend;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
public class AlipayTest {

    @Resource
    private Environment config;

    /**
     * appid = 9021000125676341
     */
    @Test
    void testGetAlipayConfig(){
        log.info("appid = " + config.getProperty("alipay.app-id"));
    }

}
