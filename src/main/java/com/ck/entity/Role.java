package com.ck.entity;

import lombok.Data;

import java.util.List;

@Data
public class Role {
    private String roleName;
    private Integer roleId;
    private List<Permission> permissions;
//    private Integer userRoleId;
//    private Integer userId;
}
