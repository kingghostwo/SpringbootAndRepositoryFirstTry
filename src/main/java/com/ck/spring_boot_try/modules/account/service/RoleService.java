package com.ck.spring_boot_try.modules.account.service;

import com.ck.spring_boot_try.modules.account.entity.Role;

import java.util.List;

public interface RoleService {

    List<Role> getRoles();

    List<Role> getRolesByUserId(int userId);
}
