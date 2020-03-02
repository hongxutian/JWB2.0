package com.hnu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hnu.repository")
public class JWBApplication {

    public static void main(String[] args) {
        SpringApplication.run(JWBApplication.class, args);
    }
}
