package com.ck.spring_boot_try.modules.School.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "h_clazz")
public class Clazz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clazzId;
    private String schoolName;
    /**
     * ManyToMany，一方使用 JoinTable 注解，另一方配置 mappedBy 属性
     * cascade：联级操作
     * fetch：加载数据策略
     * JoinTable：中间表
     * name： 中间表表名
     * joinColumns：表 h_clazz 参与中间表的主键
     * inverseJoinColumns：关联表 h_student 参与中间表的主键
     */
    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable(name = "h_clazz_student",
            joinColumns = @JoinColumn(name = "clazz_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students;
    /**
     * ManyToOne：多方使用 joinClumn，创建外键，一方使用 mappedBy 属性
     * cascade：联级操作
     * fetch：加载数据策略
     * JoinColumn
     * name：多方 h_clazz 表的外键 school_id
     * insertable & updatable：标识该属性是否参与插入和更新插入
     * JsonIgnore：不序列化该字段，避免无限递归
     */
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "school_id", insertable = false, updatable = false)
    @JsonIgnore
    private School school;
}
