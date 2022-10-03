package com.ck.spring_boot_try.modules.account.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "role_resource")
@Data
public class RoleResource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_resource_id", nullable = false)
    private int roleResourceId;
    private int roleId;
    private int resourceId;
}
