package com.ck.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
public class User {
    private Integer userId;
    private String userName;
    private String userPassword;
    private Integer userAge;
    private String userSex;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date userBirthday;
    private String userTel;
    private String userEmail;
//    private IdCard idCard;
//    private List<BankCard> bankCards;
    private List<Role> role;

}
