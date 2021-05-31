package com.blog.hotae;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan
@SpringBootApplication
public class HotaeApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotaeApplication.class, args);
    }

}
