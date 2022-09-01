package com.ck.service;

import com.ck.entity.User;
import com.ck.vo.ResultInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {
    List<User> queryUserAll();

    User queryUserById(int userId);

    PageInfo<User> queryUser(int pageNum, int pageSize);

    User queryUserByUserName(String userName);

    ResultInfo login(String userName, String userPassword);

    User queryUserAndRoleByUserName(String userName);
}
