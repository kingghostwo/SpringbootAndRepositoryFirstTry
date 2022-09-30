package com.ck.spring_boot_try.modules.account.service;

import com.ck.spring_boot_try.modules.account.entity.User;
import com.ck.spring_boot_try.modules.common.vo.Result;
import com.ck.spring_boot_try.modules.common.vo.SearchVo;
import com.github.pagehelper.PageInfo;

public interface UserService {

    Result<User> insertUser(User user);

    Result<User> login(User user);

    public PageInfo<User> getUsersBySearchVo(SearchVo searchVo);
}
