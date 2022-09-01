package com.ck.controller;

import com.ck.service.UserService;
import com.ck.vo.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sys")
public class SystemController {
    @Autowired
    private UserService userService;
    @GetMapping("/login")
    @ResponseBody
    public ResultInfo login(String userName, String userPassword){
        return userService.login(userName,userPassword);
    }


}
