package com.ck.spring_boot_try.modules.account.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

    @RequestMapping("/register")
    public String registerPage(ModelMap modelMap) {
        modelMap.addAttribute("template", "/account/register");
        return "indexSimple";
    }

    @RequestMapping("/login")
    public String loginPage(ModelMap modelMap) {
        modelMap.addAttribute("template", "/account/login");
        return "indexSimple";
    }

    @RequestMapping("/logout")
    public String logoutPage(ModelMap modelMap) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        modelMap.addAttribute("template", "/account/login");
        return "indexSimple";
    }

    @RequestMapping("/users")
    public String usersPage(ModelMap modelMap) {
        modelMap.addAttribute("template", "/account/users");
        return "index";
    }

}
