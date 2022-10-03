package com.ck.spring_boot_try.modules.account.controller;

import com.ck.spring_boot_try.modules.account.entity.User;
import com.ck.spring_boot_try.modules.account.service.UserService;
import com.ck.spring_boot_try.modules.common.vo.Result;
import com.ck.spring_boot_try.modules.common.vo.SearchVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/register", consumes = "application/json")
    public Result<User> register(@RequestBody User user) {
        return userService.insertUser(user);
    }

    @PostMapping(value = "/login", consumes = "application/json")
    public Result<User> login(@RequestBody User user) {
        return userService.login(user);
    }

    @PostMapping(value = "/users", consumes = "application/json")
    public PageInfo<User> getUsersBySearchVo(@RequestBody SearchVo searchVo) {
        return userService.getUsersBySearchVo(searchVo);
    }

    @RequestMapping("/user/{userId}")
    public User getUserById(@PathVariable int userId) {
        return userService.getUserById(userId);
    }

    @PutMapping(value = "/user", consumes = "application/json")
    public Result<User> updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/user/{userId}")
//@RequiresPermissions(value={"deleteUser"}, logical= Logical.OR)
    public Result<User> deleteUser(@PathVariable int userId) {
        return userService.deleteUser(userId);
    }

}
