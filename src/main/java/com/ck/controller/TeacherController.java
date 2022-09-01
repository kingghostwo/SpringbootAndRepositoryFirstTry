package com.ck.controller;

import com.ck.vo.ResultInfo;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Teacher")
public class TeacherController {
    @DeleteMapping("/delete/{id}")
    @RequiresRoles(value = {"admin", "teacher"}, logical = Logical.OR)
    @ResponseBody
    public ResultInfo deleteStudentById(@PathVariable("id") int userId) {
        return new ResultInfo("200", "success");
    }

    @GetMapping("/query/{id}")
//    @RequiresRoles(value = {"admin", "teacher"}, logical = Logical.OR)
//    两种不一样的设置方式，
    @RequiresPermissions(value = {"teacher:query"})
    @ResponseBody
    public ResultInfo queryStudentById(@PathVariable("id") int userId) {
        return new ResultInfo("200", "success");
    }

}
