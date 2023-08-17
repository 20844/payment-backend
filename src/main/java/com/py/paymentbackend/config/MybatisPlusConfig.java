package com.py.paymentbackend.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan("com.py.paymentbackend.mapper") // 扫描mapper
@EnableTransactionManagement // 开启事务管理
public class MybatisPlusConfig {
}
