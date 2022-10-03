package com.ck.spring_boot_try.modules.account.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
@Data
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_role_id", nullable = false)
    private int userRoleId;
    private int userId;
    private int roleId;
}
