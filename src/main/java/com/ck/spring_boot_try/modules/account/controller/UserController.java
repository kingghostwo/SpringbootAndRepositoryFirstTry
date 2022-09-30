package com.ck.spring_boot_try.modules.account.controller;

import com.ck.spring_boot_try.modules.account.entity.User;
import com.ck.spring_boot_try.modules.account.service.UserService;
import com.ck.spring_boot_try.modules.common.vo.Result;
import com.ck.spring_boot_try.modules.common.vo.SearchVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/register", consumes = "application/json")
    public Result<User> register(@RequestBody User user){
        return userService.insertUser(user);
    }

    @PostMapping(value = "/login", consumes = "application/json")
    public Result<User> login(@RequestBody User user) {
        return userService.login(user);
    }

    @PostMapping(value="/users", consumes="application/json")
    public PageInfo<User> getUsersBySearchVo(@RequestBody SearchVo searchVo) {
        return userService.getUsersBySearchVo(searchVo);
    }

}
