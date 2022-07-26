package com.halead.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @title: EduApplication
 * @Author ppjjss
 * @Date: 2022/7/25 0:48
 * @Version 1.0
 */
@SpringBootApplication
//@EnableDiscoveryClient
//@EnableFeignClients
@ComponentScan(basePackages = {"com.halead.eduservice.mapper"})
public class EduApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class,args);
    }
}
