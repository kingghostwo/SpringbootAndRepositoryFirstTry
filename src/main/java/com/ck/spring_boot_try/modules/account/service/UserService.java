package com.ck.spring_boot_try.modules.account.service;

import com.ck.spring_boot_try.modules.account.entity.User;
import com.ck.spring_boot_try.utils.Result;

public interface UserService {

    Result<User> insertUser(User user);

    Result<User> getUserByUserName(User user);
}