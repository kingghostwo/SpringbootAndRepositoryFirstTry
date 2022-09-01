package com.ck.service;

import com.ck.entity.Role;

public interface RoleService {
    Role queryRoleAndPermission(String roleName);
}
