package com.ck.spring_boot_try.modules.School.entity;

import javax.persistence.*;
import java.beans.Transient;
import java.util.List;

@Entity
@Table(name="h_school")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int schoolId;
    private int schoolName;
    private String region;


/**
 * OneToMany：多方使用 joinClumn，创建外键，一方使用 mappedBy 属性
 * cascade：联级操作
 * fetch：加载数据策略
 */
    @OneToMany(mappedBy = "school", cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
            private List<Clazz> clazzes;
}
