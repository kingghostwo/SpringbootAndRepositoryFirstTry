package com.ck.spring_boot_try.modules.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {

    /**
     * 127.0.0.1:8080/test/helloWorld ---- get
     */
    @GetMapping(value = "/helloWorld")
    @ResponseBody
    String helloWorld(){
        return "Hello world";
    }
}
