package com.ck.spring_boot_try.modules.School.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "h_card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardId;
    @Column(name = "card_no", length = 33, unique = true)
    private String cardNo;
    /**
     * OneToOne：一对一关系中，有外键方使用 JoinColumn 注解，另一方使用
     * cascade：联级操作
     * fetch：加载数据策略
     * JsonIgnore：不序列化该字段，避免无限递归
     */
    @OneToOne(mappedBy = "studentCard", cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JsonIgnore
    private Student student;
}

