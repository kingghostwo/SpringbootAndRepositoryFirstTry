package com.ck.spring_boot_try.modules.School.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name="h_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    private String studentName;
    private String birthPlace;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createDate;
/**
 * OneToOne：一对一关系中，有外键方使用 JoinColumn 注解，另一方使用
 * targetEntity：目标实体
 * cascade：联级操作
 * fetch：加载数据策略
 * JoinColumn
 * name 对应 h_student 表中 card_id 外键列
 */
    @OneToOne(targetEntity = Card.class, cascade = CascadeType.REFRESH)
            @JoinColumn(name = "card_id", unique = true)
            private Card studentCard;
/**
 * ManyToMany，一方使用 JoinTable 注解，另一方配置 mappedBy 属性
 * cascade：联级操作
 * fetch：加载数据策略
 * JsonIgnore：不序列化该字段，避免无限递归
*/
    @ManyToMany(mappedBy = "students", cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Clazz> clazzes;

}
