package com.ck.spring_boot_try.modules.account.controller;

import com.ck.spring_boot_try.modules.account.entity.User;
import com.ck.spring_boot_try.modules.account.service.UserService;
import com.ck.spring_boot_try.utils.Result;
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
    public Result<User> insertUser(@RequestBody User user){
        return userService.insertUser(user);
    }

}
