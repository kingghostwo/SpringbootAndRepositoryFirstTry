package com.ck.controller;

import com.ck.vo.ResultInfo;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {
    @RequiresRoles(value = {"admin", "teacher"}, logical = Logical.OR)
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResultInfo deleteStudentById(@PathVariable("id") int userId) {
        return new ResultInfo("200", "success");
    }

    @RequiresRoles(value = {"admin", "teacher", "student"}, logical = Logical.OR)
    @GetMapping("/query/{id}")
    @ResponseBody
    public ResultInfo queryStudentById(@PathVariable("id") int userId) {
        return new ResultInfo("200", "success");
    }

}
