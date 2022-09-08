package com.ck.spring_boot_try.modules.test.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource("classpath:config/application.properties")
public class ApplicationTest {

    @Value("${com.hqyj.name}")
    private String name;
    private String a = "test";

}
