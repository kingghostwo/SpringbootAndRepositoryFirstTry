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
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
        User userTemp = userMapper.getUserByUserName(user.getUserName());
        if (userTemp != null) {
            result.setStatus(Result.ResultStatus.FAILED.status);
            result.setMessage("User Name Repeat");
            return result;
        }

        user.setCreateDate(new Date());
        user.setPassword(MD5.getMD5(user.getUserName(), user.getPassword()));
        userMapper.insertUser(user);

        List<Role> roles = user.getRoles();
        if (roles != null) {
            userRoleMapper.deleteUserRoleByUserId(user.getUserId());
            for (Role role :
                    roles) {
                userRoleMapper.addUserRole(role.getRoleId(), user.getUserId());
            }
        }

//        我认为这段需要在事务提交之后再进行更新Role的操作，
//        因为前端传到后端的数据是没有包含UserId的，
//        userId是再进入数据库之后再由数据库自增形成，
//        事务没有提交时是没有这个ID值，也就导致后面的getId失败,思考一个解决方案

        //判断是否开启了事务
//        if (TransactionSynchronizationManager.isActualTransactionActive()) {
//            //将操作注册到“afterCommit”(事务提交之后)
//            TransactionSynchronizationManager
//                    .registerSynchronization(new TransactionSynchronizationAdapter() {
//                        @Override
//                        public void afterCommit() {
//                            // 事务提交后执行回调
//                            List<Role> roles = user.getRoles();
//                            if (roles != null) {
//                                userRoleMapper.deleteUserRoleByUserId(user.getUserId());
//                                for (Role role :
//                                        roles) {
//                                    userRoleMapper.addUserRole(role.getRoleId(), user.getUserId());
//                                }
//                            }
//                        }
//                    });
//            //没有开启事务的直接执行
//        } else {
//            List<Role> roles = user.getRoles();
//            if (roles != null) {
//                userRoleMapper.deleteUserRoleByUserId(user.getUserId());
//                for (Role role :
//                        roles) {
//                    userRoleMapper.addUserRole(role.getRoleId(), user.getUserId());
//                }
//            }
//        }
        return result;
    }

    @Override
    public User getUserByUserName(String userName) {
        userMapper.getUserByUserName(userName);
        return null;
    }


    public Result<User> login(User user) {

        User userTemp = userMapper.getUserByUserName(user.getUserName());
        if (userTemp == null || !userTemp.getPassword().equals(MD5.getMD5(user.getUserName(), user.getPassword()))) {
            return new Result<>(Result.ResultStatus.FAILED.status, "userName or password error");
        }else {
            return new Result<>(Result.ResultStatus.SUCCESS.status, "");
        }
//        UsernamePasswordToken usernamePasswordToken =
//                new UsernamePasswordToken(user.getUserName(),
//                        MD5.getMD5(user.getUserName(), user.getPassword()));
//        usernamePasswordToken.setRememberMe(user.isRememberMe());
//        try {
//            Subject subject = SecurityUtils.getSubject();
//            subject.login(usernamePasswordToken);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new Result<User>(Result.ResultStatus.FAILED.status, "");
//        }
//        return new Result<User>(Result.ResultStatus.SUCCESS.status, "");
    }

    public PageInfo<User> getUsersBySearchVo(SearchVo searchVo) {
        searchVo.initSearchVo();
        PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
        return new PageInfo(
                Optional.ofNullable(userMapper.getUsersBySearchVo(searchVo))
                        .orElse(Collections.emptyList()));
    }

    @Override
    public User getUserById(int userId) {
        return userMapper.getUserById(userId);
    }

    @Override
    @Transactional
    public Result<User> updateUser(User user) {
        User userTemp = userMapper.getUserByUserName(user.getUserName());
        if (userTemp != null && user.getUserId() != userTemp.getUserId()) {
            return new Result<User>(Result.ResultStatus.FAILED.status, "User name is repeat.");
        }
        userMapper.updateUser(user);
        List<Role> roles = user.getRoles();
        if (!roles.isEmpty()) {
            userRoleMapper.deleteUserRoleByUserId(user.getUserId());
            for (Role role : roles) {
                userRoleMapper.addUserRole(role.getRoleId(), user.getUserId());
            }
        }
        return new Result<User>(Result.ResultStatus.SUCCESS.status, "update Success");
    }

    @Override
    @Transactional
    public Result<User> deleteUser(int userId) {
        userMapper.deleteUser(userId);
        return new Result<User>(Result.ResultStatus.SUCCESS.status, "delete success");
    }

}
