package com.scwl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.scwl.mapper"})
@ServletComponentScan
public class ScwlApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScwlApplication.class, args);
    }

}
