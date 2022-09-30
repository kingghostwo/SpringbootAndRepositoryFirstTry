package com.ck.spring_boot_try.modules.account.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "create_date")
    private Date createDate;

    @Transient
    private List<Role> roles;

    @Transient
    private boolean rememberMe;
}
