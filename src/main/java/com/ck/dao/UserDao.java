package com.ck.dao;

import com.ck.entity.User;

import java.util.List;

public interface UserDao {

    User queryUserById(Integer user);

    List<User> queryUserAll();

    User queryUserByUserName(String userName);

    User queryUserAndRoleByUserName(String userName);
}
