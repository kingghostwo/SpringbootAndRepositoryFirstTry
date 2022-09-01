package com.ck.entity;

import lombok.Data;

@Data
public class Permission {
    private Integer permissionId;
    private String permissionDesc;
    private String permissionUrl;
    private String permissionName;
    private String permissionIcon;
    private Integer permissionPid;
}
