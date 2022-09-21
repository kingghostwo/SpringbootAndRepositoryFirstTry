package com.ck.spring_boot_try.modules.account.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Role")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;
    private String roleName;

}
