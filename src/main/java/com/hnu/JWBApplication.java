package com.hnu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.hnu.repository")
@EnableTransactionManagement
public class JWBApplication {

    public static void main(String[] args) {
        SpringApplication.run(JWBApplication.class, args);
    }
}
