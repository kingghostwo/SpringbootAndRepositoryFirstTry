package com.ck.dao;

import com.ck.entity.Role;

public interface RoleDao {
    Role queryRoleAndPermissionByRoleName(String roleName);
}
