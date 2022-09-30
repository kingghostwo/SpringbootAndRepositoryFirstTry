package com.ck.spring_boot_try.modules.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/common")
public class CommonController {

    @RequestMapping("/dashboard")
    public String dashboardPage(ModelMap modelMap) {
        modelMap.addAttribute("template", "/common/dashboard");
        return "index";
    }
}
