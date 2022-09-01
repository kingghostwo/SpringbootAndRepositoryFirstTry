package com.ck.service.impl;

import com.ck.dao.RoleDao;
import com.ck.entity.Role;
import com.ck.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role queryRoleAndPermission(String roleName) {
        return roleDao.queryRoleAndPermissionByRoleName(roleName);
    }
}
