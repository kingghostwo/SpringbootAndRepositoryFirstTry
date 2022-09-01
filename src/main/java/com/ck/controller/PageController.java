package com.ck.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sys")
public class PageController {
    @GetMapping("/gologin")
    public String goLogin(){
        return "login";
    }

    @GetMapping("/index")
    public String goIndex(){
        return "main";
    }
    @GetMapping("/error")
    public String Error(){
        return "error";
    }

}
