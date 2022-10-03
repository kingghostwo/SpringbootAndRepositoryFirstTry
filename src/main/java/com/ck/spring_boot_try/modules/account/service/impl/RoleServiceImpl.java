package com.ck.spring_boot_try.modules.account.service.impl;

import com.ck.spring_boot_try.modules.account.entity.Role;
import com.ck.spring_boot_try.modules.account.mapper.RoleMapper;
import com.ck.spring_boot_try.modules.account.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> getRoles() {
        return roleMapper.getRoles();
    }

    @Override
    public List<Role> getRolesByUserId(int userId) {
        return roleMapper.getRoleByUserId(userId);
    }
}
