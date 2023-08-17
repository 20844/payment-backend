package com.py.paymentbackend.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.py.paymentbackend.entity.Product;
import com.py.paymentbackend.mapper.ProductMapper;
import com.py.paymentbackend.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
