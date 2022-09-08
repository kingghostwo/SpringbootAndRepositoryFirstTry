package com.ck.spring_boot_try;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootTryApplication extends SpringBootServletInitializer {

    //将启动类作为外置容器的接口
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTryApplication.class, args);
    }

}
