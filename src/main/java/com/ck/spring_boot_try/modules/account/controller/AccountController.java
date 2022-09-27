package com.ck.spring_boot_try.modules.account.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

    @RequestMapping("/register")
    public String registerPage(ModelMap modelMap){
        modelMap.addAttribute("template", "/account/register");
        return "indexSimple";
    }
}
