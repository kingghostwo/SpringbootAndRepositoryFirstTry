package com.ck.spring_boot_try.modules.account.service.impl;

import com.ck.spring_boot_try.modules.account.entity.Role;
import com.ck.spring_boot_try.modules.account.entity.User;
import com.ck.spring_boot_try.modules.account.mapper.UserMapper;
import com.ck.spring_boot_try.modules.account.mapper.UserRoleMapper;
import com.ck.spring_boot_try.modules.account.service.UserService;
import com.ck.spring_boot_try.modules.common.vo.SearchVo;
import com.ck.spring_boot_try.utils.MD5;
import com.ck.spring_boot_try.modules.common.vo.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    @Transactional
    public Result<User> insertUser(User user) {
        Result<User> result = new Result<User>(Result.ResultStatus.SUCCESS.status, "");

        if (userMapper.getUserByUserName(user.getUserName()) != null) {
            result.setStatus(Result.ResultStatus.FAILED.status);
            result.setMessage("User Name Repeat");
            return result;
        }

        user.setCreateDate(new Date());
        user.setPassword(MD5.getMD5(user.getUserName(),user.getPassword()));
        userMapper.insertUser(user);

        List<Role> roles = user.getRoles();
        if (roles != null) {
            userRoleMapper.deleteUserRoleByUserId(user.getUserId());
            for (Role role :
                    roles) {
                userRoleMapper.addUserRole(role.getRoleId(), user.getUserId());
            }
        }
        return result;
    }


    public Result<User> login(User user) {
        User userTemp = userMapper.getUserByUserName(user.getUserName());
        if (userTemp == null || !userTemp.getPassword().equals(MD5.getMD5(user.getUserName(), user.getPassword()))) {
            return new Result<>(Result.ResultStatus.FAILED.status, "userName or password error");
        }else {
            return new Result<>(Result.ResultStatus.SUCCESS.status, "");
        }
    }

    public PageInfo<User> getUsersBySearchVo(SearchVo searchVo) {
        searchVo.initSearchVo();
        PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
        return new PageInfo(
                Optional.ofNullable(userMapper.getUsersBySearchVo(searchVo))
                        .orElse(Collections.emptyList()));
    }
}
