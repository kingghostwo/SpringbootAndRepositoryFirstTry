package com.ck.spring_boot_try.modules.account.service;

import com.ck.spring_boot_try.modules.account.entity.User;
import com.ck.spring_boot_try.modules.common.vo.Result;
import com.ck.spring_boot_try.modules.common.vo.SearchVo;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {

    Result<User> insertUser(User user);

    Result<User> login(User user);

    PageInfo<User> getUsersBySearchVo(SearchVo searchVo);

    User getUserById(int userId);

    Result<User> updateUser(User user);

    Result<User> deleteUser(int userId);

    User getUserByUserName(String userName);

}
