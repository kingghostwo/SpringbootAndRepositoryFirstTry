package com.ck.spring_boot_try.modules.account.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "Resource")
@Data
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int resourceId;
    private String resourceName;
    private String permission;

    @Transient
    private List<Role> roleList;
}
