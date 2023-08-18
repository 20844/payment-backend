package com.py.paymentbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PaymentBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentBackendApplication.class, args);
    }

}
