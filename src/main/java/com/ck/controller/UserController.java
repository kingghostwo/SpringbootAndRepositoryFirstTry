package com.ck.controller;

import com.ck.entity.User;
import com.ck.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/users")
    @ResponseBody
    List<User> queryUserAll(){
        return userService.queryUserAll();
    }
    @GetMapping("user")
    @ResponseBody
    User queryUserById(){
        return userService.queryUserById(1);
    }
    @GetMapping("/userPage/{pageNum}/{pageSize}")
    @ResponseBody
    PageInfo<User> queryUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        if (pageNum == -1) {
            pageNum=1;
        }
        return userService.queryUser(pageNum,pageSize);
    }

}
