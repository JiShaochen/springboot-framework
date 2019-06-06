package com.shaochen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author JiShaochen
 * @date 2019/6/6 16:06
 * @desc
 */
@SpringBootApplication
@MapperScan("com.shaochen.mapper")
@ComponentScan(basePackages={"com"})
public class ShaochenApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShaochenApplication.class, args);
    }
}