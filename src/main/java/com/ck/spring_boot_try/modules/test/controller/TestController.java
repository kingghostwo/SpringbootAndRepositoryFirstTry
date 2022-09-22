package com.ck.spring_boot_try.modules.test.controller;

import org.slf4j.Logger;
import com.ck.spring_boot_try.modules.test.entity.ApplicationTest;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {

    private final static Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Value("${com.hqyj.name}")
    private String name;
    @Autowired
    private ApplicationTest applicationTest;

    /**
     * 127.0.0.1:8080/test/helloWorld ---- get
     */
    @GetMapping(value = "/helloWorld")
    @ResponseBody
    String helloWorld(){
        return "Hello world";
    }

    @GetMapping(value = "/config")
    @ResponseBody
    String config(){
        return String.format("%s", name, applicationTest.getName());
    }

    @GetMapping(value = "/log")
    @ResponseBody
    public String logback(){
        LOGGER.trace("trace");
        LOGGER.debug("debug");
        LOGGER.info("info");
        LOGGER.warn("warn");
        LOGGER.error("error");
        return "log test";
    }

    @RequestMapping("index")
    public String testIndex(){
        return "index";
    }
}
