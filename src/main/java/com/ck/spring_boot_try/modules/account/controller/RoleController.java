package com.ck.spring_boot_try.modules.account.controller;

import com.ck.spring_boot_try.modules.account.entity.Role;
import com.ck.spring_boot_try.modules.account.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping("/roles")
    public List<Role> getRoles() {
        return roleService.getRoles();
    }

}
