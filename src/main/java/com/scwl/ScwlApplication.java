package com.scwl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan(basePackages = {"com.scwl.mapper"})
@ServletComponentScan
@EnableScheduling
public class ScwlApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScwlApplication.class, args);
    }

}
